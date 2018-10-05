package ru.job4j.LayoutPersistent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
     * It's format for formating date
     */
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    /**.
     * Construcor for class User
     * @param id it's id the user
     * @param name it's name the user
     * @param login it's login the user
     * @param email it's email the user
     */
    public User(int id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = new GregorianCalendar();
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
        return "User " + "id-'" + id + " name-'" + name + " login-'" + login + ", email-'" + email + '\'' +
                ", createDate-'" + sdf.format(createDate.getTime());
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
}
