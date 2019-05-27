package ru.job4j;

import java.util.List;
import java.util.TreeSet;
import java.util.Set;
import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
 * Chapter_003
 * Task 3.3.1
 * Test sorting array users by name
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class SortUserTest {

    /**.
     * Test sorting by age
     */
    @Test
    public void whenAddArrayThenGetSortingArray() {
        SortUser sortUser = new SortUser();
        Set<User> sortingList = new TreeSet<>();
        User one = new User("Ivan", 23);
        User two = new User("Boris", 20);
        User three = new User("Vladimir", 55);
        List<User> list = List.of(one, two, three);
        sortingList = sortUser.sort(list);
        String fact = "Result sorting : ";
        for (User user : sortingList) {
            fact += user.getAge();
        }
        String expect = "Result sorting : 202355";
        assertThat(fact, is(expect));

    }

    /**.
     * Test sorting by hashCod
     */
    @Test
    public void whenAddArrayThenGetSortingArrayByHashCod() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        List<User> sortingList = new ArrayList<>();
        User one = new User("Ivan", 23);
        User two = new User("Boris", 20);
        User three = new User("Vladimir", 55);
        list.add(one);
        list.add(two);
        list.add(three);
        sortingList = sortUser.sortHash(list);
        String fact = "Result sorting : ";
        for (User user : sortingList) {
            fact += user.getAge();
        }
        String expect = "Result sorting : 552023";
        assertThat(fact, is(expect));

    }

    /**.
     * Test sorting by hashCod
     */
    @Test
    public void whenAddArrayThenGetSortingArrayByLengthName() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        List<User> sortingList = new ArrayList<>();
        User one = new User("Ivan", 23);
        User two = new User("Boris", 20);
        User three = new User("Vladimir", 55);
        list.add(one);
        list.add(two);
        list.add(three);
        sortingList = sortUser.sortLength(list);
        String fact = "Result sorting : ";
        for (User user : sortingList) {
            fact += user.getAge();
        }
        String expect = "Result sorting : 232055";
        assertThat(fact, is(expect));
    }
}
