package ru.job4j;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Task 5.5.1.
 * Create model User ond new Map
 *
 * Created by ANTON VASILYUK on 20.06.2017.
 * @version 1.0
 */
public class User {

    /**.
     * @name is name user
     */
    private String name;

    /**.
     * @children is amount child by the user
     */
    private int children;

    /**.
     * @birthday is date birthday of the user
     */
    Calendar birthday;

    /**.
     * Is constructor for model User
     * @param name
     * @param children
     * @param year is year of birth date
     * @param month is month of birth date
     * @param day is day of mirth date
     */
    public User(String name, int children, int year, int month, int day) {
        this.name = name;
        this.children = children;
        this.birthday = new GregorianCalendar(year, month, day);
    }

    /**.
     * Getter for name
     * @return name
     */
    public String getName() {return this.name;}

    /**.
     * Setter for name
     * @param name is name of the user
     */
    public void setName(String name) {this.name = name;}

    /**.
     * Getter for children of the user
     * @return amount children by the user
     */
    public int getChildren() { return this.children;}

    /**.
     * Setter for children
     * @param children is amount children by the user
     */
    public void setChildren(int children) {this.children = children;}

    /**.
     * Getter for birthday
     * @return birthday
     */
    public Calendar getBirthday() {return this.birthday;}

    /**.
     * Change Date birthday
     * @param date is new date
     */
    public void setBirthday(Calendar date) {this.birthday = date;}
}
