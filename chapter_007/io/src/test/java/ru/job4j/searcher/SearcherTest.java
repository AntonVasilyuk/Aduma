package ru.job4j.searcher;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.is;

/**.
 * Chapter_007
 * Test working class searching
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class SearcherTest {

    /**.
     * @path Main path for creating test structure.
     */
    private final String path = System.getProperty("java.io.tmpdir");

    /**.
     * @file file for testing
     */
    private File file;

    /**.
     * @source is source for main dir
     */
    private String source;

    /**.
     * @sourceFile is source for file
     */
    private String sourceFile;

    /**.
     * Preparing before testing
     * @throws IOException if file not found
     */
    @Before
    public void preparing() throws IOException {
        source = path + "/Dir";
        sourceFile = source + "/Filetest.txt";
        new File(source).mkdir();
        file = new File(sourceFile);
        file.createNewFile();
    }

    /**.
     * Delete test file
     */
    @After
    public void deleteFile() {
        file.deleteOnExit();
    }

    /**.
     * Test working app when searching by fullname
     * @throws IOException may be exception
     */
    @Test
    public void whenSearchByFullName() throws IOException {
        String param = "Filetest";
        Searcher searcher = new Searcher();
        List<File> list = searcher.files(source, new FilterAbsolute(param));
        Assert.assertThat(list.get(0).getName(), is("Filetest.txt"));
    }

    /**.
     * Test working app when searching by maskname
     * @throws IOException may be exception
     */
    @Test
    public void whenSearchByMask() throws IOException {
        String param = "test";
        Searcher searcher = new Searcher();
        List<File> list = searcher.files(source, new FilterMask("test"));
        Assert.assertThat(list.get(0).getName(), is("Filetest.txt"));
    }

    /**.
     * Test working app when searching by maskname
     * @throws IOException may be exception
     */
    @Test
    public void whenSearchByRegex() throws IOException {
        String param = "^[A-Za-z0-9]+$";
        Searcher searcher = new Searcher();
        List<File> list = searcher.files(source, new FilterRegex(param));
        Assert.assertThat(list.get(0).getName(), is("Filetest.txt"));
    }
}