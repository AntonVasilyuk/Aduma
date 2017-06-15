package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 5.3.2.
 * Create my realisation for LinkedList
 *
 * Created by ANTON on 14.06.2017.
 * @version 1.0
 */
public class PseodoLinkedListTest {

    /**.
     * @link is link to list
     */
    PseodoLinkedList link;

    /**.
     * Test when link is null
     */
    @Test
    public void whenLinkIsNull() {
        try {
            link.iterator().hasNext();
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("It is empty container"));
        }
    }

    /**.
     * Preparing to other test
     */
    @Before
    public void preparingForTest() {
        link = new PseodoLinkedList();
    }

    /**.
     * Test working method add
     */
    @Test
    public void whenAddOneElementThenSizeIsOne() {
        String testWord = "Bingo";
        link.add(testWord);
        assertThat(link.getSize(), is(1));
    }

    /**.
     * Test working method get
     */
    @Test
    public void whenGetElementThenReturnBingo() {
        String testWord = "Bingo";
        link.add(testWord);
        String test = (String) link.get(0);
        assertThat(test, is("Bingo"));
    }

    /**.
     * Test add more element to list
     */
    @Test
    public void whenAddOneHundredElement() {
        String testWord = "Bong!";
        for (int i = 0; i < 100; i++) {
            link.add(testWord);
        }
        assertThat(link.getSize(), is(100));
    }
}