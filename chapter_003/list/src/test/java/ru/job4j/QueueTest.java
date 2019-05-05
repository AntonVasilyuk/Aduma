package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**.
 * Task 5.3.3.
 * Create my realisation for Queue
 *
 * Created by ANTON on 15.06.2017.
 * @version 1.0
 */
public class QueueTest {

    /**.
     * @link is link for object Queue
     */
    private Queue link;

    /**.
     * Preparing for test
     */
    @Before
    public void preparing() {
        link = new Queue();
    }

    /**.
     * Test method for return first element from queue
     */
    @Test
    public void whenUseElementThenReturnFirstElement() {
        String first = "Bingo";
        String second = "Test";
        link.offer(first);
        link.offer(second);
        assertThat(link.element(), is("Bingo"));
    }

    /**.
     * Test method return first element and delete first node
     */
    @Test
    public void whenUseOfferThenReturnFirstElementAndDelFirstNode() {
        String first = "Bingo";
        boolean result = link.offer(first);
        assertThat(result, is(true));
    }

    /**.
     * Test method return first element from queue
     */
    @Test
    public void whenUsePeekThenReturnFirstElementFromQueue() {
        String first = "Bingo";
        String second = "Test";
        link.offer(first);
        link.offer(second);
        assertThat(link.peek(), is("Bingo"));
    }

    /**.
     * Test method return first element and delete first node from queue
     */
    @Test
    public void whenUsePollThenreturnFirstElemenrDeleteFirstNode() {
        String first = "Bingo";
        String second = "Test";
        link.offer(first);
        link.offer(second);

        int firstSize = link.getSize();
        String result = (String) link.poll();
        int secondSize = link.getSize();

        boolean fact = false;
        if (secondSize < firstSize && result.equals(first)) {
            fact = true;
        }
        assertThat(fact, is(true));
    }

    /**.
     * Test method for return first element and delete first node from queue
     */
    @Test
    public void whenUseRemoveThenReturnFirstElementDeleteFirstNode() {
        String first = "Bingo";
        String second = "Test";
        link.offer(first);
        link.offer(second);

        int firstSize = link.getSize();
        String result = (String) link.remove();
        int secondSize = link.getSize();

        boolean fact = false;
        if (secondSize < firstSize && result.equals(first)) {
            fact = true;
        }
        assertThat(fact, is(true));
    }

    /**.
     * Test call remove with empty queue
     */
    @Test
    public void whenRemoveElementFromEmptyQueue() {
        try {
            link.remove();
        } catch (NoSuchElementException nee) {
            assertThat(nee.getMessage(), is("The queue is empty"));
        }
    }

    /**.
     * Test method check size queue
     */
    @Test
    public void whenUseGetSizeThenReturnSizeQueue() {
        int firstSize = link.getSize();
        link.offer("Test");
        int secongSize = link.getSize();
        boolean fact = false;
        if (secongSize > firstSize) {
            fact = true;
        }
        assertThat(fact, is(true));
    }
}