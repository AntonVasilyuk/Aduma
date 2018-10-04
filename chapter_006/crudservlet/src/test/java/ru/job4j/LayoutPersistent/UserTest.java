package ru.job4j.LayoutPersistent;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void whenNeedEqualsUsers() {
        int id = 0;
        String name = "user";
        String email = "resu";
        User user = new User(id, name, name, email);
        Assert.assertTrue(user.equals(name, email));
    }

    @Test
    public void whenNeedGettingIdForUser() {
        int id = 0;
        String name = "user";
        String email = "resu";
        User user = new User(id, name, name, email);
        Assert.assertTrue(user.getId() == 0);
    }
}