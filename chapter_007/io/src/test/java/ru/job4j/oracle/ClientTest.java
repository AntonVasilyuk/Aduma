package ru.job4j.oracle;

import com.google.common.base.Joiner;
import org.junit.After;
import org.junit.Test;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Testing class client for class client.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 27.03.2019
 */

public class ClientTest {

    /**.
     * it's delimetr.
     */
    private static final String LN = System.getProperty("line.separator");

    /**.
     * It's inner system stream.
     */
    private final InputStream sysIn = System.in;

    /**.
     * It's outer system stream.
     */
    private final PrintStream sysOut = System.out;

    /**.
     * It's inner stream for testing
     */
    private ByteArrayInputStream testIn;

    /**.
     * It's outer stream for testing
     */
    private ByteArrayOutputStream testOut;

    /**.
     * Change system stream
     * @param text it's text for send to console
     */
    private void setStream(String text) {
        testIn = new ByteArrayInputStream(text.getBytes());
        System.setIn(testIn);
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    /**.
     * Rollback system stream inner and outer
     */
    @After
    public void rollBackStream() {
        System.setIn(sysIn);
        System.setOut(sysOut);
    }

    /**.
     * Check working client
     * @throws IOException may be exception
     */
    @Test
    public void whenEnterExitThenStopedServer() throws IOException {
        testing(
                String.format("exit%s", LN),
                Joiner.on(LN).join("message", "", ""),
                Joiner.on(LN).join("message", "Server is stoped", ""));
    }

    /**.
     * Method for testing
     * @param console it's text for console
     * @param inPhrases inner phrases
     * @param outPhrases outer phrases
     * @throws IOException may be exception
     */
    private void testing(String console, String inPhrases, String outPhrases) throws IOException {
        Socket socket = mock(Socket.class);
        setStream(console);
        ByteArrayInputStream in = new ByteArrayInputStream(inPhrases.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.start();
        assertThat(testOut.toString(), is(outPhrases));
    }
}
