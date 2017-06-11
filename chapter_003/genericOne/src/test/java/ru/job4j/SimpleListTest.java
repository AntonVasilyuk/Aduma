package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by ANTON on 08.06.2017.
 */
public class SimpleListTest<String> {

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

    @Test
    public void whenAddNewElementToArray() {
        String obj = (String) "Test";
        sLT.add(obj);
        String test = sLT.get(0);
        assertThat(test, is("Test"));
    }

    @Test
    public void whenUpdateElementArrayOnThisPosition() {
        String newObj = (String) "Test two";
        sLT.update(0, newObj);
        String test = sLT.get(0);
        assertThat(test, is(newObj));
    }

    @Test
    public void whenDeleteElementFromThisPosition() {
        String test = (String) "Test";
        sLT.add(test);
        sLT.delete(0);
        assertNull(sLT.get(0));
    }

    @Test
    public void whenAddNullElement() {
        String test = null;
        try {
            sLT.add(test);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Element is null"));
        }
    }

    @Test
    public void whenUpdateElementNullElement() {
        String test = null;
        try {
            sLT.update(0, test);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("this value is null"));
        }
    }

    @Test
    public void whenDeleteElementWhichIsNot() {
        try {
            sLT.delete(2);
        } catch (NoSuchElementException nee) {
            assertThat(nee.getMessage(), is("In this no element"));
        }
    }

    @Test
    public void whenAddToManyItems() {
        String one = (String) "Test";
        String two = (String) "Test";
        String tree = (String) "Test";
        String four = (String) "Test";
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