package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 7.3.1.
 * Test working class Count
 *
 * @author Anton Vasilyuk on 26.07.2017.
 * @version 1.0.
 * @simce 0.1.
 */
public class CountTest {

    /**.
     * Test working my class Count
     * @throws Exception may be exception
     */
    @Test
    public void mainAction() throws Exception {
        Count link = new Count();
        int result = link.mainAction(100, 0);
        assertThat(result, is(100));
    }
}