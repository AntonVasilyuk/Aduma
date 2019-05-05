package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * Created by ANTON on 08.06.2017.
 */
public class SimpleListTest {

    /**.
     * Create link for object class SimpleList
     */
    private SimpleList<String> sLT;

    /**.
     * Preparing for Test
     */
    @Before
    public void preparingForTests() {
        sLT = new SimpleList(3);
    }

    /**.
     * Test when need add new element to our storage
     */
    @Test
    public void whenAddNewElementToArray() {
        String obj = new String("Test");
        sLT.add(obj);
        String test = sLT.get(0);
        assertThat(test, is("Test"));
    }

    /**.
     * Test when need update element to our storage
     */
    @Test
    public void whenUpdateElementArrayOnThisPosition() {
        String newObj = (String) "Test two";
        sLT.update(0, newObj);
        String test = sLT.get(0);
        assertThat(test, is("Test two"));
    }

    /**.
     * Test when need deleting element from our storage
     */
    @Test
    public void whenDeleteElementFromThisPosition() {
        String test = (String) "Test";
        sLT.add(test);
        sLT.delete(0);
        assertNull(sLT.get(0));
    }

    /**.
     * Testing when need add null element
     */
    @Test
    public void whenAddNullElement() {
        String test = null;
        try {
            sLT.add(test);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Element is null"));
        }
    }

    /**.
     * Testing when need updating null element
     */
    @Test
    public void whenUpdateElementNullElement() {
        String test = null;
        try {
            sLT.update(0, test);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("this value is null"));
        }
    }

    /**.
     * Test when need deleting a non-existent element
     */
    @Test
    public void whenDeleteElementWhichIsNot() {
        try {
            sLT.delete(2);
        } catch (NoSuchElementException nee) {
            assertThat(nee.getMessage(), is("In this no element"));
        }
    }

    /**.
     * Test when need add many elements
     */
    @Test
    public void whenAddToManyItems() {
        String one = "Test";
        String two = "Test";
        String tree = "Test";
        String four = "Test";
        sLT.add(one);
        sLT.add(two);
        sLT.add(tree);
        try {
            sLT.add(four);
        } catch (ArrayIndexOutOfBoundsException aio) {
            assertThat(aio.getMessage(), is("Too far"));
        }
    }
}