package ru.job4j;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 5.2.2
 * Test method User
 * @author  Anton Vasilyuk on 10.06.2017.
 * @version 1.0
 */
public class UserTest {

    /**.
     * Check working method getId
     */
    @Test
    public void whenCreateNewUserThenGetIdReturnItId() {
        User us = new User("Bingo");
        assertThat(us.getId(), is("Bingo"));
    }

    /**.
     * Check working method setId
     */
    @Test
    public void whenChangeIdUser() {
        User us = new User("Bingo");
        us.setId("No Bingo");
        assertThat(us.getId(), is("No Bingo"));
    }
}