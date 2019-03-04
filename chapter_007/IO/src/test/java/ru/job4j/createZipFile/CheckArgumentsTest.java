package ru.job4j.createZipFile;

import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void whenGetingRootName() {
        checker.getArgumets();
        String rootName = checker.getRootPath();
        String expectation = "root";
        System.out.println(rootName);
        assertTrue(rootName.equals(expectation));
    }

    @Test
    public void whenGetingZipName() {
        checker.getArgumets();
        String zipName = checker.getNameArchive();
        String expectation = "pack.zip";
        assertTrue(zipName.equals(expectation));
    }

    @Test
    public void whenGetingListExtense() {
        checker.getArgumets();
        String rootName = checker.getExtense().get(0);
        String expectation = "txt";
        assertTrue(rootName.equals(expectation));
    }
}
