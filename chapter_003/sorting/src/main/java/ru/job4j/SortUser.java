package ru.job4j;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;

/**.
 * Chapter_003
 * Task 3.3.1
 * Sorting array users by name
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class SortUser {

    /**.
     * Sorting array by age
     * @param list it's list for sorting
     * @return sorting list
     */
    public Set<User> sort(List<User> list) {
        Set<User> sortingList = new TreeSet<>();
        for (User user : list) {
            sortingList.add(user);
        }
        return sortingList;
    }

    /**.
     * Sorting array by hashCod
     * @param list it's list for sorting
     * @return sorting array
     */
    public List<User> sortHash(List<User> list) {
        Collections.sort(list, (o1, o2) -> Integer.valueOf(o1.hashCode()).compareTo(Integer.valueOf(o2.hashCode())));
        return list;
    }

    /**.
     * Sorting by length
     * @param list it's list for sorting
     * @return result
     */
    public List<User> sortLength(List<User> list) {
        Collections.sort(list, (o1, o2) -> Integer.valueOf(o1.getName().length()).compareTo((o2.getName().length())));
        return list;
    }

}
