package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Task 7.1.1.
 * Create test for my Thread
 *
 * @author  Anton Vasilyuk on 16.07.2017.
 * @version 1.0
 */
public class CountingSpacesTest {

    /**.
     * Test working method simulataneous search space and word in the text
     * @throws InterruptedException may be exception
     */
    @Test
    public void whenIsTextThenSimultaneousSearchOfWordsAndSpaces() throws InterruptedException {
        CountingSpaces link = new CountingSpaces();
        String line = "World is beautiful World is beautiful World is beautiful World is beautiful";
        String result = link.parseToSpacesAndWords(line);
        assertThat(result, is("11 and 12"));
    }
}