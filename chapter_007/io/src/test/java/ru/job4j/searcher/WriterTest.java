package ru.job4j.searcher;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;

/**.
 * Chapter_007
 * Test working class writer
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class WriterTest {

    /**.
     * Test method write when writed three file and then read third record.
     */
    @Test
    public void whenWriteThreeFileThenReadThreeFile() throws IOException {
        File fileOne = new File("fileOne");
        File fileTwo = new File("fileTwo");
        File fileThree = new File("fileThree");
        List<File> list = List.of(fileOne, fileTwo, fileThree);
        Writer writer = new Writer("fileOut.txt");
        writer.write(list);
        BufferedReader reader = new BufferedReader(new FileReader(new File("fileOut.txt")));
        Optional text = reader.lines().skip(2).limit(1).findFirst();
        Assert.assertThat(text.get(), is("fileThree"));
    }
}