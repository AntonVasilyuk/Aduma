package ru.job4j;

import java.util.*;
/**
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
     * @param list
     * @return sorting list
     */
    public Set<User> sort (List<User> list) {
        Set<User> sortingList = new TreeSet<>();
        for(User user : list) {
            sortingList.add(user);
        }
        return sortingList;
    }

    /**.
     * Sorting array by hashCod
     * @param list
     * @return sorting array
     */
    public List<User> sortHash (List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            public int compare(User o1, User o2) {
                return String.valueOf(o1.hashCode()).compareTo(String.valueOf(o2.hashCode()));
            }
        });
        return list;
    }

    public List<User> sortLength (List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            public int compare(User o1, User o2) {
                return String.valueOf(o1.getName().length()).compareTo(String.valueOf(o2.getName().length()));
            }
        });
        return list;
    }

}
