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
        Role userOne = new Role("Awast");
        rolSrore.add(userOne);
        assertThat(rolSrore.showByPosition("Awast").getId(), is("Awast"));
    }

    /**.
     * Check working method update
     */
    @Test
    public void whenUpdateUserOneToUserTwo() {
        Role userOne = new Role("Awast");
        rolSrore.add(userOne);
        rolSrore.update("No Awast", userOne);
        assertThat(rolSrore.showByPosition("No Awast").getId(), is("No Awast"));
    }

    /**.
     * Check working method remove
     */
    @Test
    public void whenRemoveElement() {
        String text = "No Awast";
        Role roleTree = new Role(text);
        rolSrore.add(roleTree);
        rolSrore.remove(text);
        assertNull(rolSrore.showByPosition(text));
    }
}