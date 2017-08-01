package ru.job4j;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Task 7.3.4.
 * Test working class Search file
 * @author Anton Vasilyuk 30.07.2017.
 * @version 1.0.
 */
public class SearchFileTest {

    @Test
    public void whenNeedSearchTextInDirectory() throws InterruptedException {
        List<String> exts = new LinkedList<>();
        exts.add("txt");
        exts.add("java");
        SearchFile link = new SearchFile("src", "Test", exts);
        link.startApp();
        link.result();
    }
}