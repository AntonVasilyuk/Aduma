package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 5.4.2.
 * Test working my LinkedSet
 *
 * Created by ANTON on 17.06.2017.
 * @version 1.0
 */
public class SimpleSetLinkedTest {

    /**.
     * @set is reference to an SimpleSetLinked
     */
    SimpleSetLinked set;

    /**.
     * preparing for test
     */
    @Before
    public void preparingForTest() {
        set = new SimpleSetLinked();
    }

    /**.
     * Test working method add
     */
    @Test
    public void whenAddOneElement(){
        String one = "Test";
        set.add(one);
        String test = (String) set.iterator().next();
        assertThat(test, is("Test"));
    }

    /**.
     * Test add null element
     */
    @Test
    public void whenAddNullElement() {
        String one = null;
        try {
            set.add(one);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Element is null"));
        }
    }

    /**.
     * Test add one element two times
     */
    @Test
    public void whenAddElementTwoTimesThenAddOnlyOneElement() {
        String one = "Test";
        set.add(one);
        set.add(one);
        set.iterator().next();
        boolean test = set.iterator().hasNext();
        assertThat(test, is(false));
    }
}