package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Task 5.6.3.
 * Create test for my BinaryTree
 *
 * Created by Anton Vasilyuk on 01.07.2017.
 * @version 1.0
 */
public class BinaryTreeTest {

    /**.
     * @link is link to the BinaryTree
     */
    private BinaryTree link;

    /**.
     * Preparing for test Binary Tree
     */
    @Before
    public void preparingForTest() {
        link = new BinaryTree();
    }

    /**.
     * Test method add
     */
    @Test
    public void whenAddElementToTheTreeThenItarateReturnThisElement() {
        String test = "Bingo!";
        link.add(test);
        String result = (String) link.iterator().next();
        assertThat(result, is("Bingo!"));
    }

    /**.
     * Test adding null element to the Tree
     */
    @Test
    public void whenAddNullElement() {
        String test = null;
        try {
            link.add(test);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Value is null"));
        }
    }

    /**.
     * Test work sorting Tree
     */
    @Test
    public void whenAddTreeElementThenReturnSortingElements() {
        String one = "A";
        String two = "B";
        String three = "C";

        link.add(two);
        link.add(one);
        link.add(three);

        String[] array = new String[3];
        String[] test = {one, two, three};

        boolean result = true;
        for (int i = 0; i < 3; i++) {
            array[i] = (String) link.iterator().next();
            if (!array[i].equals(test[i])) {
                result = false;
            }
        }

        assertThat(result, is(true));
    }

    /**.
     * Test method hasNext
     */
    @Test
    public void whenAddElementAndIterateOneTimeThenHasNextReturnNoMoreElement() {
        String test = "Bingo";
        link.add(test);
        link.iterator().next();
        try {
            link.iterator().hasNext();
        } catch (NoSuchElementException nee) {
            assertThat(nee.getMessage(), is("No more elements"));
        }
    }
}