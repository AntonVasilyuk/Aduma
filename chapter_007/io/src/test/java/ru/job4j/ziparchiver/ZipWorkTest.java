package ru.job4j.ziparchiver;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import java.io.IOException;
import java.io.File;
import java.io.Writer;
import java.io.FileWriter;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.junit.Assert.assertTrue;

/**
 * Test working class ZipWork.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 08.03.2019
 */

public class ZipWorkTest {

    /**.
     * Testing method doZip()
     * @throws IOException it's may be exception
     */
    @Test
    public void whenZipFileAndUnzipItThanTrue() throws IOException {
        String testPath = System.getProperty("user.dir") + File.separator;
        File inner = new File(String.format("%s%s", testPath, "Test.txt"));
        inner.createNewFile();

        try (Writer out = new FileWriter(inner)) {
            out.write("String for test");
            out.flush();
        }
        ZipWork zip = new ZipWork(testPath, "test.zip", List.of("txt"));
        zip.doZip();
        try (ZipFile zipFile = new ZipFile(testPath + "test.zip")
        ) {
            ZipEntry entry = zipFile.getEntry("Test.txt");
            try (InputStream is = zipFile.getInputStream(entry)) {
                Files.copy(is, Paths.get(testPath + "firstunpacked.ziptest"));
            }
            new File(zipFile.getName()).deleteOnExit();
        }
        File file = new File(testPath + "firstunpacked.ziptest");
        assertTrue(FileUtils.contentEquals(inner, file));

        inner.deleteOnExit();
        file.deleteOnExit();
    }
}
