package ru.job4j.persistent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**.
 * Task 9.2.1.
 * Model for info about user
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */

public class User {

    /**.
     * It's id for the user
     */
    private final int id;

    /**.
     * It's name for the user
     */
    private final String name;

    /**.
     *  It's login for the user
     */
    private final String login;

    /**.
     * It's email for the user
     */
    private final String email;

    /**.
     * It's date created for the user
     */
    private final Calendar createDate;

    /**.
     * It's password for user
     */
    private final String password;

    /**.
     * It's role user
     */
    private final String role;

    /**.
     * It's country users
     */
    private String country;

    /**.
     * It's city
     */
    private String city;

    /**.
     * It's format for formating date
     */
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    /**.
     * Construcor for class User
     * @param id it's id the user
     * @param name it's name the user
     * @param login it's login the user
     * @param password it's password the user
     * @param email it's email the user
     * @param time it's time for creating date
     * @param role it's role for user
     * @param country it's country for user
     * @param city it's city user
     */
    public User(int id, String name, String login, String password, String email, Long time,
                String role, String country, String city) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.createDate = new GregorianCalendar();
        createDate.setTime(new Date(time));
        this.role = role;
        this.country = country;
        this.city = city;
    }

    /**.
     * Construcor for class User
     * @param name it's name the user
     * @param login it's login the user
     * @param password it's password the user
     * @param email it's email the user
     * @param country it's country for user
     * @patam city it's city user
     */
    public User(String name, String login, String email, String password, String role, String country, String city) {
        id = -1;
        createDate = new GregorianCalendar();
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
        this.country = country;
        this.city = city;
    }

    /**.
     * Method for checking users on equality
     * @param checkLogin it's equality login
     * @param checkEmail it's equality email
     * @return result checking
     */
    public boolean equals(String checkLogin, String checkEmail) {
        if (this.login.equals(checkLogin) || this.email.equals(checkEmail)) {
            return true;
        } else {
            return false;
        }
    }

    /**.
     * Method for checking users on equality
     * @param user user for equality
     * @return result
     */
    public boolean equals(User user) {
        if (this.login.equals(user.login) || this.email.equals(user.email)) {
            return true;
        } else {
            return false;
        }
    }

    /**.
     * Method for out info about user
     * @return text line with info
     */
    @Override
    public String toString() {
        return "User " + "id-" + id + " name-" + name + " login-" + login + ", email-" + email +
                 "role - " + role;
    }

    /**.
     * Getter for id user
     * @return id
     */
    public int getId() {
        return id;
    }

    /**.
     * Getter for name of the user
     * @return name
     */
    public String getName() {
        return name;
    }

    /**.
     * Getter for login of the user
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**.
     * Getter for email of the user
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**.
     * Getter for password
     * @return password the user
     */
    public String getPassword() {
        return password;
    }

    /**.
     * Getter for role
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**.
     * Getter for country
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**.
     * Setter for country
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**.
     * Getter for city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**.
     * Setter for city
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }
}
