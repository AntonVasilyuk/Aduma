package ru.job4j;

import org.junit.Test;
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
        int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        IteratorSimpleNumbers iter = new IteratorSimpleNumbers(array);
        int[] testArray = {2, 3, 5, 7, 11};
        int[] resultArray = new int[5];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = (Integer) iter.next();
            if(resultArray[i] != testArray[i]) {checkNum++;}
        }
        boolean fact = true;
        boolean expect = true;
        if(checkNum != 0) {fact = false;}
        assertThat(fact, is(expect));

    }

}