package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Task 5.5.1.
 * Create check for cyclicity
 *
 * Created by ANTON VASILYUK on 16.06.2017.
 * @version 1.0
 */
public class UserTest {

    /**.
     * @user is link of the user
     */
    private User user;

    /**.
     * Is preparing for testing
     */
    @Before
    public void preparingForTest() {
        user = new User("Sergei", 2, 2014, 1, 24);
    }

    /**.
     * Test method get name
     */
    @Test
    public void whenGetNameThenReturnNameUser() {
        String test = user.getName();
        assertThat(test, is("Sergei"));
    }

    /**.
     * Test method set name
     */
    @Test
    public void whenSetNameGoshaThenGetNameReturnGosha() {
        user.setName("Gosha");
        String test = user.getName();
        assertThat(test, is("Gosha"));
    }

    /**.
     * Test method get amount children
     */
    @Test
    public void whenGetChildrenThenReturnAmountChildrenByTheUser() {
        int amount = user.getChildren();
        assertThat(amount, is(2));
    }

    /**.
     * Test method set children
     */
    @Test
    public void whenSetChildrenThreeThenGetChildrenReturnThree() {
        user.setChildren(3);
        int amount = user.getChildren();
        assertThat(amount, is(3));
    }

    /**.
     * Test method get Birthday
     */
    @Test
    public void whenGetBirthdayThenReturnBirthday() {
        Calendar date = user.getBirthday();
        Calendar test = new GregorianCalendar(2014, 1, 24);
        boolean result = false;
        if (date.equals(test)) {
            result = true;
        }
        assertThat(result, is(true));
    }

    /**.
     * Test method set new date of the birthday
     */
    @Test
    public void whenSetNewDateBirthdayThenGetReturnNewDateBirthday() {
        Calendar newDate = new GregorianCalendar(1964, 1, 3);
        user.setBirthday(newDate);
        Calendar test = user.getBirthday();
        boolean result = false;
        if (newDate.equals(test)) {
            result = true;
        }
        assertThat(result, is(true));
    }
}