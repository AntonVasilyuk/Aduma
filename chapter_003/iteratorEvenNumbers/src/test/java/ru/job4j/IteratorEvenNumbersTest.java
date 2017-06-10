package ru.job4j;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 4.1.2
 * Test create Iterator even numbers
 *
 * @author Anton Vasilyuk on 03.06.2017.
 * @version 1.0
 * @since 0.1
 */

public class IteratorEvenNumbersTest {

    /**.
     * Testing Iterator for even numbers
     */
    @Test
    public void whenNeedAddOnlyEvenNumbers() {
        IteratorEvenNumbers iter = new IteratorEvenNumbers(new int[][] {{1, 2}, {3, 4}});
        int[] arrayResult = new int[2];
        int[] check = {2, 4};

        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = (Integer) iter.next();
        }

        boolean fact = true;
        for (int i = 0; i < arrayResult.length; i++) {
            if (arrayResult[i] != check[i]) {fact = false;}
        }
        assertThat(fact, is(true));
    }

    @Test
    public void whenIterateOneTimeThenHasNextReturnTrue() {
        IteratorEvenNumbers iter = new IteratorEvenNumbers(new int[][] {{1, 2}, {3, 4}});
        iter.next();
        boolean result = iter.hasNext();
        assertThat(result, is(true));
    }

    @Test
    public void whenIterateTwoTimeThenHasNextReturnFalse() {
        IteratorEvenNumbers iter = new IteratorEvenNumbers(new int[][] {{1, 2}, {3, 4}});
        iter.next();
        iter.next();
        boolean result = iter.hasNext();
        assertThat(result, is(false));
    }

    @Test
    public void whenArrayIsNullThenHasNextReturnNEE() {
        int[][] value = null;
        IteratorEvenNumbers iter = new IteratorEvenNumbers(value);
        try {
            iter.hasNext();
        } catch (NoSuchElementException nee) {
            assertThat(nee.getMessage(), is("No element in this array."));
        }
    }

    /**.
     * Test when is one array
     */
    @Test
    public void whenIsOneArray() {
        IteratorEvenNumbers it = new IteratorEvenNumbers(new int[][] {{1, 2, 3, 4}});
        it.next();
        assertThat(it.hasNext(), is(true));
    }
}