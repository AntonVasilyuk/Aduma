package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
 * Task 7.3.2.
 * Test class UserStorage
 *
 * @author Anton Vasilyuk on 28.07.2017.
 * @version 1.0.
 */
public class UserStorageTest {

    /**.
     * @link is link to the structure
     */
    private UserStorage link;

    /**.
     * This method is preparing gor testing
     */
    @Before
    public void preparingForThisTests() {
        link = new UserStorage();
    }

    /**.
     * Test method add
     */
    @Test
    public void whenNeedAddOneElementThenElementAddingToStructure() {
        link.add(new User(1, 100));
        Map<Integer, User> map = link.getStorage();
        int result = map.size();
        assertThat(result, is(1));
    }

    /**.
     * Test method update
     */
    @Test
    public void whenNeedUpdateElementRegisteredInStructure() {
        link.add(new User(1, 100));
        link.update(1, 50);
        Map<Integer, User> map = link.getStorage();
        int result = map.get(1).getAmount();
        assertThat(result, is(150));
    }

    /**.
     * Test method delete
     */
    @Test
    public void whenNeedDeleteElementFromTheStructure() {
        link.add(new User(1, 100));
        link.delete(1);
        Map<Integer, User> map = link.getStorage();
        int result = map.size();
        assertThat(result, is(0));
    }

    /**.
     * Test method transfer
     */
    @Test
    public void whenNeedTransferMoneyFromFirstUserToSecondUser() {
        link.add(new User(1, 100));
        link.add(new User(2, 200));
        link.transfer(1, 2, 50);
        Map<Integer, User> map = link.getStorage();
        boolean result = false;
        if (map.get(2).getAmount() == 250) {
            result = true;
        }
        assertThat(result, is(true));
    }

}