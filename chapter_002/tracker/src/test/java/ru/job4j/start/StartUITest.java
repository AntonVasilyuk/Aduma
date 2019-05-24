package ru.job4j.start;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;

/**
 * Testing StartUI.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 */
public class StartUITest {

    /**.
     * @sysIn System input stream
     */
    private final InputStream sysIn = System.in;

    /**.
     * @sysOut System output stream
     */
    private final PrintStream sysOut = System.out;

    /**.
     * @out link for read console
     */
    private ByteArrayOutputStream out;

    /**.
     * Change system stream
     */
    private void setStream() {
        ByteArrayInputStream bis = new ByteArrayInputStream("test".getBytes());
        out = new ByteArrayOutputStream();
        System.setIn(bis);
        System.setOut(new PrintStream(out));
    }

    /**.
     * Setting system streams
     */
    private void rollBack() {
        System.setIn(sysIn);
        System.setOut(sysOut);
    }

    /**.
     * Check loading to console menu the apps
     * @throws IOException may be exception
     */
    @Test
    public void whenStartAppThenOutputMenu() throws IOException {
        setStream();
        new StartUI(new StubInput(new String[]{"1", "y"}), new Tracker(), System.out::print).init();
        rollBack();
        String result = out.toString();
        BufferedReader reader = new BufferedReader(new StringReader(result));
        Assert.assertThat(reader.readLine(), is("0. Add new item"));
    }

    /**.
     * Check working adding new item using console for enter
     * @throws IOException may be exception
     */
    @Test
    public void whenAddOneItemThenShowItWithConsole() throws IOException {
        setStream();
        new StartUI(new StubInput(new String[]{"0", "name", "desc", "n", "1", "y"}), new Tracker(), System.out::print).init();
        rollBack();
        BufferedReader reader = new BufferedReader(new StringReader(out.toString()));
        List<String> text = reader.lines()
                .skip(12)
                .limit(1)
                .collect(Collectors.toList());
        Assert.assertThat(text.get(0), is("name, desc"));
    }
}
