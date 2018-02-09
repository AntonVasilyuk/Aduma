package ru.job4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**.
 * Task 8.5.1.
 * Connection to website
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class ConnectionWeb {

    /**.
     * Logger for info
     */
    private final static Logger log = LoggerFactory.getLogger(ConnectionWeb.class);

    /**.
     * For date format
     */
    private final SimpleDateFormat convert = new SimpleDateFormat("dd MMM yy, HH:mm");

    /**.
     * Check the last date
     */
    private Timestamp check;

    /**.
     * Connection to database
     */
    private final ConnectDB db = new ConnectDB();

    /**.
     * Connection to website
     * @throws IOException is may be exception
     */
    public void getDataWebSite() throws IOException {
        Document document = Jsoup.connect("http://sql.ru/forum/job-offers").userAgent("Mozilla").get();
        Elements headEl = document.select("tr:has(postslisttopic)");
        for (Element element : headEl) {
            String text = element.text().toLowerCase();
            if (text.contains("java") && !text.contains("script")) {
                Elements info = headEl.select("td.postlisttopic > a[href]");
                Elements date = headEl.select("td.altCol");

                String infoText = info.get(0).attr("href");
                String dateText = date.get(1).text();
                Timestamp time = getTimeStamp(dateText);

                if(check != null && !check.equals(time)) {
                    db.add(infoText, time);
                } else {
                    break;
                }
            }
        }
    }

    /**.
     * Create TimeStamp
     * @param data for create Time stamp
     * @return new TimeStamp
     */
    public Timestamp getTimeStamp(String data) {
        Calendar calendar = Calendar.getInstance();
        if (data.contains("сегодня")) {
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(data.substring(9, 11)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(data.substring(12, 14)));
        } else if (data.contains("вчера")) {
            calendar.set(Calendar.DATE, -1);
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(data.substring(7, 9)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(data.substring(10, 12)));
        } else {
            try {
                calendar.setTime(convert.parse(data));
            } catch (ParseException e) {
                log.error(e.getMessage(), e);
            }
        }
        return new Timestamp(calendar.getTimeInMillis());
    }
}
