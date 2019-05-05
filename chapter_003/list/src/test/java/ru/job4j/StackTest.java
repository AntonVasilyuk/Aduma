package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
 * Task 5.3.3.
 * Create my realisation for Queue
 *
 * Created by ANTON on 15.06.2017.
 * @version 1.0
 */
public class StackTest {

    /**.
     * Link for instance
     */
    private Stack link;

    /**.
     * Preparing for test
     */
    @Before
    public void preparingForTests() {
        link = new Stack();
    }

    /**.
     * Test method empty
     */
    @Test
    public void whenUseEmptyLinkIsEmptyThenTrue() {
        boolean result = link.empty();
        assertThat(result, is(true));
    }

    /**.
     * Test method push
     */
    @Test
    public void whenPushNewElement() {
        String first = "Bingo";
        link.push(first);
        int sizeStack = link.getSize();
        assertThat(sizeStack, is(1));
    }

    /**.
     * Test method pop
     */
    @Test
    public void whenUsePopThenReturnAndDeleteLastElement() {
        String first = "Test";
        String second = "Bingo";
        link.push(first);
        link.push(second);
        String test = (String) link.pop();
        int sizeStack = link.getSize();
        boolean result = false;
        if (sizeStack == 1 && test.equals(second)) {
            result = true;
        }
        assertThat(result, is(true));
    }

    /**.
     * Test method pop then stack is empty
     */
    @Test(expected = EmptyStackException.class)
    public void whenLinkIsNullThenPopReturnESE() {
        link.pop();
    }

    /**.
     * Test method peek
     */
    @Test
    public void whenUsePushThenReturnLastElement() {
        String first = "Bingo";
        link.push(first);
        String test = (String) link.peek();
        assertThat(test, is(first));
    }

    /**.
     * Test method peek then stack is empty
     */
    @Test(expected = EmptyStackException.class)
    public void whenLinkIsNullThenPeekReturnESE() {
        link.peek();
    }

    /**.
     * Test method getter size
     */
    @Test
    public void whenUseGetSizeThenReturnSizeStack() {
        String first = "Test";
        String second = "Bingo";
        link.push(first);
        link.push(second);
        int result = link.getSize();
        assertThat(result, is(2));
    }
}