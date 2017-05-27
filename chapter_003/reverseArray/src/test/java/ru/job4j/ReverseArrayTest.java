package ru.job4j;

import java.util.*;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
 * Chapter_003
 * Task 3.1.3
 * Test transform collection to array and back
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class ReverseArrayTest {
    /**.
     * Test method transform array to collection
     */
    @Test
    public void whenNeedTransformArrayToCollectionThenDoIt() {
        ReverseArray reverseArray = new ReverseArray();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = reverseArray.toList(array);
        List<Integer> listSecond = new LinkedList<>();
        listSecond.add(1);
        listSecond.add(2);
        listSecond.add(3);
        listSecond.add(4);
        listSecond.add(5);
        listSecond.add(6);
        listSecond.add(7);
        listSecond.add(8);
        listSecond.add(9);
        boolean fact = false;
        if (list.containsAll(listSecond)) {fact = true;}
        boolean expect = true;
        assertThat(fact, is(expect));
    }

    /**.
     * Test transform collection to array
     */
    @Test
    public void whenNeedTransformCollectionToArrayThenDoIt() {
        ReverseArray reverseArray = new ReverseArray();
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        int[][] array = reverseArray.toArray(list, 3);
        int[][] arraySecond = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        boolean fact = true;
        boolean expect = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array.length;j++) {
                if (array[i][j] != arraySecond[i][j]) {
                    fact = false;
                    break;
                }
            }
        }
        assertThat(fact, is(expect));
    }
}
