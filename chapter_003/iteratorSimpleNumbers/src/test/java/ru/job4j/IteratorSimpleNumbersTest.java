package ru.job4j;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 4.1.3
 * Create iterator for simple numbers
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class IteratorSimpleNumbersTest {

    /**.
     * Method for check method Next
     */
    @Test
    public void whenNeedTakeAwayOnlySimpleNumbersThenDoIt() {
        int checkNum = 0;
        int[][] array = {{2, 3}, {7, 8}};
        IteratorSimpleNumbers iter = new IteratorSimpleNumbers(array);
        int[] testArray = {2, 3, 7};
        int[] resultArray = new int[3];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = (Integer) iter.next();
            if(resultArray[i] != testArray[i]) {checkNum++;}
        }
        boolean fact = true;
        boolean expect = true;
        if(checkNum != 0) {fact = false;}
        assertThat(fact, is(expect));
    }

    /**.
     * Test working hasNext
     */
    @Test
    public void whenIterateTwoTimeArrayThenHasNextReturnfalse() {
        int[][] array = {{2, 3, 11}, {4, 5}};
        IteratorSimpleNumbers iter = new IteratorSimpleNumbers(array);
        iter.next();
        iter.next();
        boolean result = iter.hasNext();
        assertThat(result, is(true));
    }

    /**.
     * Test working hasNext if not simple numbers
     */
    @Test
    public void whenInArrayNotSimpleNumberThenHasNextReturnFalse() {
        int[][] array = {{4, 6}, {8, 9}};
        IteratorSimpleNumbers iter = new IteratorSimpleNumbers(array);
        boolean result = iter.hasNext();
        assertThat(result, is(false));
    }

    /**.
     * Test working hasNext if in array not numbers
     */
    @Test
    public void whenInArrayNoElementThenHasNextReturnNEE() {
        int[][] value = null;
        IteratorSimpleNumbers iter = new IteratorSimpleNumbers(value);
        try {
            iter.hasNext();
        } catch (NoSuchElementException nee) {
            assertThat(nee.getMessage(), is("In this array not element"));
        }
    }

    /**.
     * Test when is one array
     */
    @Test
    public void whenIsOneArray() {
        IteratorSimpleNumbers it = new IteratorSimpleNumbers(new int[][] {{1, 2, 3, 4}});
        it.next();
        assertThat(it.hasNext(), is(true));
    }
}