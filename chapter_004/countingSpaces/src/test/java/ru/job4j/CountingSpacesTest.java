package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 7.1.1.
 * Create test for my Thread
 *
 * @author  Anton Vasilyuk on 16.07.2017.
 * @version 1.0
 */
public class CountingSpacesTest {

    /**.
     * Test working method simulataneous search space and word in text
     */
    @Test
    public void whenIsTextThenSimultaneousSearchOfWordsAndSpaces() throws InterruptedException {
        CountingSpaces link = new CountingSpaces();
        String line = "World is beautiful World is beautiful World is beautiful World is beautiful";
        String result = link.parseToSpacesAndWords(line);
        System.out.println(result);
        assertThat(result, is("11 and 12"));
    }
}