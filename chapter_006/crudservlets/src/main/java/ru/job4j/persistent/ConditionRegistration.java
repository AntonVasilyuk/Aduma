package ru.job4j.persistent;

import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**.
 * Task 9.2.1.
 * Condition of registration
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class ConditionRegistration {

    /**.
     * It's logger for this class
     */
    private static final Logger LOG = Logger.getLogger(ConditionRegistration.class);

    /**.
     * @time is time creating user
     */
    private final Calendar date;

    /**.
     * @country is place living user
     */
    private final String country;

    /**.
     * @city is place living user
     */
    private final String city;

    /**.
     * Constructor
     * @param time is time
     * @param country is country
     * @param city is city
     */
    public ConditionRegistration(Long time, String country, String city) {
        this.date = new GregorianCalendar();
        date.setTime(new Date(time));
        this.country = country;
        this.city = city;
    }

    /**.
     * Getter for time
     * @return time
     */
    public Calendar date() {
        return date;
    }

    /**.
     * Getter for country
     * @return country
     */
    public String county() {
        return country;
    }

    /**.
     * Getter for city
     * @return city
     */
    public String city() {
        return city;
    }
}
