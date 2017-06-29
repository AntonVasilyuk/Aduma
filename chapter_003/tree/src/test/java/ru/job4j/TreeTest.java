package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 5.6.1.
 * Create test for my tree
 *
 * Created by Anton Vasilyuk on 25.06.2017.
 * @version 1.0
 */
public class TreeTest {
    /**.
     * @link is link on the Tree
     */
    Tree link;

    /**.
     * Preparing for tests
     */
    @Before
    public void preparingForTest() {
        link = new Tree();
    }

    /**.
     * Test method add
     */
    @Test
    public void whenAddParantAndChildThenReturnTrue() {
       String parent = "Parent";
       String child = "Child";
       link.add(parent, parent);
       boolean result = link.add(parent, child);
       assertThat(result, is(true));
    }

    /**.
     * Test method add when element is null
     */
    @Test
    public void whenAddChildNullThenReturnException() {
        try {
            link.add(null,null);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Child is null"));
        }
    }

    /**.
     * Test working iterator in the tree
     */
    @Test
    public void whenIterateThenReturnElement() {
        String parent = "Parent";
        String child = "Child";
        link.add(parent, parent);
        link.add(parent, child);
        link.iterator().next();
        String test = (String) link.iterator().next();
        assertThat(test, is("Child"));
    }

    /**.
     * Test working method hasNext in the tree
     */
    @Test
    public void whenAddTwoElementAndIterateTwoTimeThenHasNextReturnFalse() {
        String parent = "Parent";
        String child = "Child";
        link.add(parent, parent);
        link.add(parent, child);
        link.iterator().next();
        link.iterator().next();
        boolean result = link.iterator().hasNext();
        assertThat(result, is(false));
    }
}