package ru.job4j;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 5.2.2
 * Test method Role
 * @author  Anton Vasilyuk on 10.06.2017.
 * @version 1.0
 */
public class RoleTest {

    /**.
     * Check working method getId
     */
    @Test
    public void whenCreateNewUserThenGetIdReturnItId() {
        Role rl = new Role("Bingo");
        assertThat(rl.getId(), is("Bingo"));
    }

    /**.
     * Check working method setId
     */
    @Test
    public void whenChangeIdUser() {
        Role rl = new Role("Bingo");
        rl.setId("No Bingo");
        assertThat(rl.getId(), is("No Bingo"));
    }
}