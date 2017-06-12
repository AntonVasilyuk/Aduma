package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 5.2.2
 * Test method UserStore
 * @author  Anton Vasilyuk on 10.06.2017.
 * @version 1.0
 */
public class UserStoreTest{

    /**.
     * usStore is link to container users
     */
    UserStore usStore;

    /**.
     * Preparing for test
     */
    @Before
    public void preparingForTest() {
        usStore = new UserStore();
    }

    /**.
     * Check working method add
     */
    @Test
    public void whenAddOneElementToArray() {
        User userOne = new User("Bingo");
        usStore.add(userOne);
        assertThat(usStore.showByPosition(0).getId(), is("Bingo"));
    }

    /**.
     * Check working method update
     */
    @Test
    public void whenUpdateUserOneToUserTwo() {
        User userTwo = new User("No Bingo");
        usStore.add(userTwo);
        usStore.update("Bingo", userTwo);
        assertThat(usStore.showByPosition(0).getId(), is("Bingo"));
    }

    /**.
     * Check working method remove
     */
    @Test
    public void whenRemoveElement() {
        User userTree = new User("No Bingo");
        usStore.add(userTree);
        usStore.remove(0);
        assertNull(usStore.showByPosition(0));
    }
}