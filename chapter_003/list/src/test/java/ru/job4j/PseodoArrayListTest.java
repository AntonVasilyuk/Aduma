package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 5.3.1
 * Test working pseodo List
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class PseodoArrayListTest {

    /**.
     * @psy is link to container
     */
    PseodoArrayList psy;

    /**.
     * Preparing for test
     */
    @Before
    public void preparing() {
        psy = new PseodoArrayList(3);
    }

    /**.
     * Test for method add
     */
    @Test
    public void add() {
        int one = psy.sizeObjects();
        Object objOne = new Object();
        psy.add(objOne);
        int two = psy.sizeObjects();
        boolean fact = false;
        if ((one + 1) == two) {fact = true;}
        assertThat(fact, is(true));
    }

    /**.
     * Test for method get
     */
    @Test
    public void get() {
        Object obj = new Object();
        psy.add(obj);
        boolean fact = false;
        if (obj.hashCode() == psy.get(0).hashCode()) {fact = true;}
        assertThat(fact, is(true));
    }

    @Test
    public void whenAmountNumberMoreSizeContainer() {
        Object one = new Object();
        Object two = new Object();
        Object three = new Object();
        Object four = new Object();
        psy.add(one);
        psy.add(two);
        psy.add(three);
        psy.add(four);
        int numElement = psy.sizeObjects();
        assertThat(numElement, is(4));
    }

    @Test
    public void whenIndexForMethodGetMoreSizeContainer() {
        try {
            psy.get(100);
        } catch (NoSuchElementException nee) {
            assertThat(nee.getMessage(), is("There is not such index"));
        }
    }
}