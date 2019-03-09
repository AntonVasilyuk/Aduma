package ru.job4j.createZipFile;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test working class CheckArgument.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 06.03.2019
 */
public class CheckArgumentsTest {

    /**.
     * Example for testing
     */
    private final CheckArguments checker = new CheckArguments(new String[] {"-d", "root", "-o", "pack.zip", "-e", "txt"});


    /**.
     * Check method getArgument
     */
    @Test
    public void whenArgumentIsCorrectThenReturnTrue() {
        boolean result = checker.getArgumets();
        assertTrue(result);
    }

    /**.
     * Test getting root
     */
    @Test
    public void whenGetingRootName() {
        checker.getArgumets();
        String rootName = checker.getRootPath();
        String expectation = "root";
        System.out.println(rootName);
        assertTrue(rootName.equals(expectation));
    }

    /**.
     * Test getting zipName
     */
    @Test
    public void whenGetingZipName() {
        checker.getArgumets();
        String zipName = checker.getNameArchive();
        String expectation = "pack.zip";
        assertTrue(zipName.equals(expectation));
    }

    /**.
     * Test getting extense
     */
    @Test
    public void whenGetingListExtense() {
        checker.getArgumets();
        String rootName = checker.getExtense().get(0);
        String expectation = "txt";
        assertTrue(rootName.equals(expectation));
    }
}
