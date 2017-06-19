package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 5.4.1.
 * Test working class SimpleSetArray
 *
 * Created by ANTON on 16.06.2017.
 * @version 1.0
 */
public class SimpleSetArrayTest {

    /**.
     * Link for SimpleSetArray
     */
    SimpleSetArray set;

    /**.
     * Preparing for test
     */
    @Before
    public void preparingForTest() {
        set = new SimpleSetArray(3);
    }

    /**.
     * Test working method add
     */
    @Test
    public void whenAddElementToSet() {
        String one = "Test";
        set.add(one);
        String test = (String) set.iterator().next();
        assertThat(test, is("Test"));
    }

    /**.
     * Test adding null element to the set
     */
    @Test
    public void whenAddNullElement() {
        String test = null;
        try {
            set.add(test);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Element is null"));
        }
    }

    /**.
     * Test adding two same elements
     */
    @Test
    public void whenAddTwoSameElementThenAddingOneElement() {
        String one = "Test";
        String two = "Test";
        String three = "Bingo";
        set.add(one);
        set.add(two);
        set.add(three);
        set.iterator().next();
        String test = (String) set.iterator().next();
        assertThat(test, is ("Bingo"));
    }

    /**.
     * Test to increase size the set
     */
    @Test
    public void whenAddMoreElement() {
        String one = "One sven";
        String two = "Two sven";
        String tree = "Tree sven";
        String four = "The ser is larger";
        set.add(one);
        set.add(two);
        set.add(tree);
        set.add(four);
        set.iterator().next();
        set.iterator().next();
        set.iterator().next();
        String test = (String) set.iterator().next();
        assertThat(test, is("The ser is larger"));
    }
}