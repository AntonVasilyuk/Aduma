package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**.
 * Task 7.3.4.
 * Test working class Search file
 * @author Anton Vasilyuk 30.07.2017.
 * @version 1.0.
 */
public class SearchFileTest {

    /**.
     * Testing working class SearchFile.
     * @throws InterruptedException may be Exception
     */
    @Test
    public void whenNeedSearchTextInDirectory() throws InterruptedException {
        List<String> exts = new LinkedList<>();
        exts.add("txt");
        exts.add("java");

        SearchFile link = new SearchFile("src", "Test", exts);
        link.startApp();
        Assert.assertNotNull(link.result());
    }
}