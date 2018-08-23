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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**.
 * Task 8.5.1.
 * Connection to website
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class ConnectionWeb {

    /**.
     * Logger for class ConnectionWeb
     */
    private final static Logger log = LoggerFactory.getLogger(ConnectionWeb.class);

    /**.
     * Link to Singleton class
     */
    private static ConnectionWeb connectionWeb;

    /**.
     * Is main url page for parsing
     */
    private String MAIN_URL;

    /**.
     * For date format
     */
    private final SimpleDateFormat convert = new SimpleDateFormat("d MMM yy, HH:mm", new Locale("ru", "RU"));

    /**.
     * Check the last date
     */
    private String checkTime;

    /**.
     * Check the last offer
     */
    private String checkOffer;

    /**.
     * Temp value for checking
     */
    private String firstDateToSearch;

    /**.
     * Temp value for checking
     */
    private String firstOfferToSearch;

    /**.
     * Check to first offers in this search
     */
    private boolean checkFirst;

    /**.
     * For checking current year
     */
    private int year;

    /**.
     * Connection to database
     */
    private final ConnectDB db = new ConnectDB();

    /**.
     * Index for database
     */
    private int countWrites = 1;

    /**.
     * Constructor for class ConnectionWeb
     */
    private ConnectionWeb() {
        log.info("Initializing the constructor");
        Calendar date = Calendar.getInstance();
        year = date.get(Calendar.YEAR);

        Settings settings = Settings.getInstance();
        MAIN_URL = settings.getValues("jdbc.url");

        checkFirst = true;
    }

    /**.
     * Method for connection to website
     */
    public void getDataWebSite() {
        log.info("Initialization parsing site from connetionWeb");
        boolean endSearch = true;
        int page = 1;
        Document document;

        try {
            while (endSearch) {
                if (page == 1) {
                    document = Jsoup.connect(MAIN_URL).get();
                } else {
                    document = Jsoup.connect(String.format("%s/%d", MAIN_URL, page)).get();
                }

                Elements headEl = document.select("tr:has(td.postslisttopic)");

                if (headEl.size() < 5) {
                    break;
                }

                page++;
                for (Element element : headEl) {
                    String text = element.text().toLowerCase();
                    if (text.contains("java") && !text.contains("script")) {
                        Elements info = element.select("td.postslisttopic");
                        Elements date = element.select("td.altCol");

                        String infoText = info.get(0).getElementsByTag("a").text();
                        String dateText = date.get(1).text();

                        if (!dateText.contains("сегодня") && !dateText.contains("вчера")) {
                            int timer = 2000 + Integer.parseInt(dateText.split(" ")[2].substring(0, 2));
                            if (year != +timer) {
                                endSearch = false;
                                break;
                            }
                        }
                        String time = getTimeAdding(dateText);

                        if (checkFirst) {
                            firstOfferToSearch = infoText;
                            firstDateToSearch = time;
                            checkFirst = false;
                        }

                        if (checkTime != null && checkOffer != null) {
                            if (!checkOffer.equals(infoText) && !checkTime.equals(time)) {
                                db.add(countWrites, infoText, time);
                                countWrites++;
                            } else {
                                checkOffer = firstOfferToSearch;
                                checkTime = firstDateToSearch;
                                checkFirst = true;
                                break;
                            }
                        } else {
                            db.add(countWrites, infoText, time);
                            countWrites++;
                        }
                    }
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**.
     * Method for formater date
     * @param data for create Time stamp
     * @return new TimeStamp
     */
    public String getTimeAdding(String data) {
        log.info("Convertion time for database");
        Calendar calendar = Calendar.getInstance();
        if (data.contains("сегодня")) {
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(data.substring(9, 11)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(data.substring(12, 14)));
        } else if (data.contains("вчера")) {

            calendar.add(Calendar.DATE, -1);
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(data.substring(7, 9)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(data.substring(10, 12)));
        } else {
            try {
                Date dateTemp = convert.parse(data);
                calendar.setTime(dateTemp);
            } catch (ParseException e) {
                log.error(e.getMessage(), e);
            }
        }

        return convert.format(calendar.getTime());
    }

    /**.
     * Create and return object for connetionWeb
     * @return connectionWeb
     */
    public static ConnectionWeb newInstance() {
        log.info("Returned single object connectionWeb");
        if (connectionWeb == null) {
            connectionWeb = new ConnectionWeb();
        }
        return connectionWeb;
    }
}
