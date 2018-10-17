package ru.job4j.layoutPersistent;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class UserTest {

    /**.
     * Testing method equals from class user
     */
    @Test
    public void whenNeedEqualsUsers() {
        int id = 0;
        String name = "user";
        String email = "resu";
        User user = new User(id, name, name, email, Calendar.getInstance().getTimeInMillis());
        Assert.assertTrue(user.equals(name, email));
    }

    /**.
     * Testing getter id from class user
     */
    @Test
    public void whenNeedGettingIdForUser() {
        int id = 0;
        String name = "user";
        String email = "resu";
        long time = Calendar.getInstance().getTimeInMillis();
        User user = new User(id, name, name, email, time);
        Assert.assertTrue(user.getId() == 0);
    }
}