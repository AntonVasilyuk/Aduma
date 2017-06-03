package ru.job4j;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 4.1.1
 * Test working iterator array
 *
 * @author Anton Vasilyuk on 03.06.2017.
 * @version 1.0
 * @since 0.1
 */
public class IteratorArrayTest {

    /**.
     * Test working iterator
     */
    @Test
    public void whenNeedGetAllElementFromMultidimensionalArray() {
        IteratorArray iter = new IteratorArray(new int[][] {{1, 2}, {3, 4}});
        int[] arrayResult = new int[4];
        int[] check = {1, 2, 3, 4};
        int num = 0;

        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = (Integer) iter.next();
        }
        for (int i = 0; i < arrayResult.length; i++) {
            if (arrayResult[i] != check[i]) {num++;}
        }

        boolean expect = true;
        boolean fact = false;
        if (num == 0) {fact = true;}
        assertThat(fact, is(expect));
    }
}