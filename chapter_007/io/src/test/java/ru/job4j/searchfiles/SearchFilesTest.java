package ru.job4j.searchfiles;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**.
 * Testing class SearchFiles
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 27.03.2019
 */

public class SearchFilesTest {

    /**.
     * Main path for creating test structure.
     */
    private final String path = System.getProperty("java.io.tmpdir");

    /**.
     * Test working this apps when need search one file
     * @throws IOException may be exception on this testing
     */
    @Test
    public void whenNeedSearchOneFileInDirectories() throws IOException {
        String mainFolder = path + "/zero";
        String levelOneOne = mainFolder + "/one";
        String levelOneTwo = mainFolder + "/two";
        String levelTwoOne = levelOneOne + "/files";
        String fileForAdding = levelTwoOne + "/test.html";
        String fileSecond = levelTwoOne + "/test.txt";

        new File(mainFolder).mkdir();
        new File(levelOneOne).mkdir();
        new File(levelOneTwo).mkdir();
        new File(levelTwoOne).mkdir();
        File file = new File(fileForAdding);
        file.createNewFile();
        new File(fileSecond).createNewFile();
        List<String> exts = new ArrayList<>();
        exts.add("html");

        SearchFiles searchFiles = new SearchFiles();
        List<File> list = searchFiles.files(mainFolder, exts);
        assertTrue(list.get(0).getAbsolutePath().equals(file.getAbsolutePath()));

    }
}
