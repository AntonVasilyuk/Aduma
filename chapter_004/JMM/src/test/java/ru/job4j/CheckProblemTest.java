package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
 * Task 7.2.1.
 * Test working class CheckProblem
 * @author Anton Vasilyuk on 19.07.2017.
 * @version 1.0.
 * @since 0.1.
 */
public class CheckProblemTest {

    /**.
     * Test working method summ when many threads do it many times
     */
    @Test
    public void whenSummNumberManyThreadsThenOutherResult() {
        CheckProblem link = new CheckProblem();
        int one = link.checkProblem(10000);
        int two = link.checkProblem(10000);
        int three = link.checkProblem(10000);
        boolean result = true;
        if (one == two && two == three) {
            result = false;
        }
        assertThat(result, is(true));
    }
}