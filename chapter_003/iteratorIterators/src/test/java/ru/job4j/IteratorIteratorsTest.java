package ru.job4j;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 4.1.4
 * Test methods create iterator for iterators
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
        List<Integer> listOne = new ArrayList(Arrays.asList(1, 2, 3));
        List<Integer> listTwo = new ArrayList(Arrays.asList(4, 5, 6));
        List<Integer> listThird = new ArrayList(Arrays.asList(7, 8));
        List<Iterator<Integer>> it = new ArrayList(Arrays.asList
                ((listOne.iterator()), listTwo.iterator(), listThird.iterator()));
        IteratorIterators iterators = new IteratorIterators();
        this.convertIterator = iterators.convert(it.iterator());
    }

    /**.
     * Test method hasNext
     */
    @Test
    public void whenNeedCheckNextElement() {
        boolean result = convertIterator.hasNext();
        assertThat(result, is(true));
    }

    /**.
     * Test method next
     */
    @Test
    public void whenNeedCheckMoveIterator() {
        convertIterator.next();
        convertIterator.next();
        convertIterator.next();
        convertIterator.next();
        Integer result = convertIterator.next();
        assertThat(result, is(5));
    }
}