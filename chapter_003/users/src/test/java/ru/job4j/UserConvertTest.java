package ru.job4j;

import java.util.*;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
 * Chapter_003
 * Task 3.2.2
 * Test create collection HashMap
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class UserConvertTest {
    /**.
     * Method for test method convert from class UserConvert
     */
    @Test
    public void whenIsListUsersThenConvertIsToMap() {
        UserConvert userconv = new UserConvert();
        HashMap<Integer, User> hashMapUsers = new HashMap<>();
        List<User> list = new LinkedList<>();
        User userOne = new User(1, "Boris", "Moscow");
        User userTwo = new User(2, "Ivan", "Novosibirsk");
        User userThird = new User(3, "Gregory", "Dacota");
        list.add(userOne);
        list.add(userTwo);
        list.add(userThird);
        hashMapUsers = userconv.process(list);
        boolean fact = false;
        boolean expect = true;
        if (hashMapUsers.containsKey(1) && hashMapUsers.containsKey(2) && hashMapUsers.containsKey(3)) {
            fact = true;
        }
        assertThat(fact, is(expect));
    }
}
