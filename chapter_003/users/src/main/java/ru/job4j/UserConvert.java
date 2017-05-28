package ru.job4j;

import java.util.*;

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
     * @param list
     * @return
     */
    public HashMap<Integer, User> process(List<User> list) {
        Integer id;
        HashMap<Integer, User> hashMapUsers = new HashMap<>();
        for (User user: list) {
            id = user.getId();
            hashMapUsers.put(id, user);
        }
        return hashMapUsers;
    }
}
