package ru.job4j;

import java.util.List;
import java.util.LinkedList;
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
        List<Integer> listSecond = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        boolean fact = false;
        if (list.containsAll(listSecond)) {
            fact = true;
        }
        boolean expect = true;
        assertThat(fact, is(expect));
    }

    /**.
     * Test transform collection to array
     */
    @Test
    public void whenNeedTransformCollectionToArrayThenDoIt() {
        ReverseArray reverseArray = new ReverseArray();
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] array = reverseArray.toArray(list, 3);
        int[][] arraySecond = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        boolean fact = true;
        boolean expect = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != arraySecond[i][j]) {
                    fact = false;
                    break;
                }
            }
        }
        assertThat(fact, is(expect));
    }

    /**.
     * Test Create List<Integer> from Array
     */
    @Test
    public void whenNeedCreateListFromSeveralArrayThenCheckIt() {
        ReverseArray reverseArray = new ReverseArray();
        List<Integer> listInteger = new LinkedList<>();
        List<Integer> listCheck = List.of(1, 2, 3, 7, 9);
        List<int[]> listArray = new LinkedList<>();
        int[] one = {1, 2, 3};
        int[] second = {7, 9};
        listArray.add(one);
        listArray.add(second);
        listInteger = reverseArray.convert(listArray);
        boolean fact = false;
        boolean expect = true;
        if (listCheck.containsAll(listInteger)) {
            fact = true;
        }
        assertThat(fact, is(expect));
    }
}
