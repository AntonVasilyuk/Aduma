package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 5.2.2
 * Test method Role Store
 * @author  Anton Vasilyuk on 10.06.2017.
 * @version 1.0
 */
public class RoleStoreTest {

    /**.
     * Link for container model role
     */
    RoleStore rolSrore;

    /**.
     * Preparing for test
     */
    @Before
    public void preparingForTest() {
        rolSrore = new RoleStore();
    }

    /**.
     * Check working method add
     */
    @Test
    public void whenAddOneElementToArray() {
        User userOne = new User("Awast");
        rolSrore.add(userOne);
        assertThat(rolSrore.showByPosition(0).getId(), is("Awast"));
    }

    /**.
     * Check working method update
     */
    @Test
    public void whenUpdateUserOneToUserTwo() {
        User userTwo = new User("No Awast");
        rolSrore.update(0, userTwo);
        assertThat(rolSrore.showByPosition(0).getId(), is("No Awast"));
    }

    /**.
     * Check working method remove
     */
    @Test
    public void whenRemoveElement() {
        User userTree = new User("No Awast");
        rolSrore.add(userTree);
        rolSrore.remove(0);
        assertNull(rolSrore.showByPosition(0));
    }
}
