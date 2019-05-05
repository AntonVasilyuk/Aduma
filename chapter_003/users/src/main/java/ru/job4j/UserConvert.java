package ru.job4j;

import java.util.HashMap;
import java.util.List;

/**.
 * Chapter_003
 * Task 3.2.2
 * Create collection HashMap
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class UserConvert {

    /**.
     * Method for convert from List to HashMap
     * @param list list users
     * @return result
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMapUsers = new HashMap<>();
        for (User user: list) {
            hashMapUsers.put(user.getId(), user);
        }
        return hashMapUsers;
    }
}
