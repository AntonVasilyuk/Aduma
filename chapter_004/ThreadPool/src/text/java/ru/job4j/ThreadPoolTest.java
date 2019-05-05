package ru.job4j;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Task 7.4.2.
 * Test my realisation ThreadPool
 *
 * @author Anton Vasilyuk 11.08.2017.
 * @version 1.0.
 */
public class ThreadPoolTest {

    /**.
     * Test working my ThreadPool
     * @throws Exception may be exception
     */
    @Test
    public void whenNeedToPerformTaskConcurrency() throws Exception {
        ThreadPool link = new ThreadPool();
        for (int i = 0; i < 77; i++) {
            link.add(new Work(i));
        }
        link.shutdown();
        link.printCountProcessor();
    }
}