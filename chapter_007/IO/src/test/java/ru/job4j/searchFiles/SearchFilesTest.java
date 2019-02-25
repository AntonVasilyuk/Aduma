package ru.job4j.searchFiles;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchFilesTest {

    /**.
     * Main path for creating test structure
     */
    String path = System.getProperty("java.io.tmpdir");

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
