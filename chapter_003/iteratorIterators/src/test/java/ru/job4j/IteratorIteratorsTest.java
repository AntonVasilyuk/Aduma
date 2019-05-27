package ru.job4j;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
 * Task 4.1.4
 * Test methos create iterator for iterators
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class IteratorIteratorsTest {

    /**.
     * Iterator for write convert iterator iterators
     */
    private Iterator<Integer> convertIterator;

    /**.
     * Preparing for test method
     */
    @Before
    public void preparingForTesting() {
        List<Integer> listOne = new ArrayList(List.of(1, 2, 3));
        List<Integer> listTwo = new ArrayList(List.of(4, 5, 6));
        List<Integer> listThird = new ArrayList(List.of(7, 8));
        List<Iterator<Integer>> it = new ArrayList(List.of(
                (listOne.iterator()), listTwo.iterator(), listThird.iterator()));
        IteratorIterators iterators = new IteratorIterators();
        this.convertIterator = iterators.convert(it.iterator());
    }

    /**.
     * Test method hasNext
     */
    @Test
    public void whenCheckNextElementThenHasNextReturnTrue() {
        boolean result = convertIterator.hasNext();
        assertThat(result, is(true));
    }

    /**.
     * Test method hasNext
     */
    @Test
    public void whenIterateEightTimeThenHasNextReturnFalse() {
        for (int i = 0; i < 8; i++) {
            convertIterator.next();
        }
        boolean result = convertIterator.hasNext();
        assertThat(result, is(false));
    }

    /**.
     * Test method next
     */
    @Test
    public void whenIterateFiveTimeArrayThenHasNextReturnFive() {
        convertIterator.next();
        convertIterator.next();
        convertIterator.next();
        convertIterator.next();
        Integer result = convertIterator.next();
        assertThat(result, is(5));
    }

    /**.
     * Test method hasNext
     */
    @Test
    public void whenArrayIsNullThenHasNextReturnNEE() {
        Iterator<Iterator<Integer>> value = null;
        IteratorIterators iter = new IteratorIterators();
        try {
            iter.hasNext();
        } catch (NoSuchElementException nee) {
            assertThat(nee.getMessage(), is("No element in this array."));
        }
    }
}
