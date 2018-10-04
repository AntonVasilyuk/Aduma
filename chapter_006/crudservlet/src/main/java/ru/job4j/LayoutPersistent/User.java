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

    private final int id;

    private final String name;

    private final String login;

    private final String email;

    private final Calendar createDate;

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public User(int id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = new GregorianCalendar();
    }

    public boolean equals(String checkLogin, String checkEmail) {
        if (this.login.equals(checkLogin) || this.email.equals(checkEmail)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(User user) {
        if (this.login.equals(user.login) || this.email.equals(user.email)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "User " + "id-'" + id + " name-'" + name + " login-'" + login + ", email-'" + email + '\'' +
                ", createDate-'" + sdf.format(createDate.getTime());
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        System.out.println(new User(1, "tom", "tom", "tom"));
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }


}
