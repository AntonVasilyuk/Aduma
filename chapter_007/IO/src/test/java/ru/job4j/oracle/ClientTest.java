package ru.job4j.oracle;

import com.google.common.base.Joiner;
import org.junit.After;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
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
     * it's delimetr
     */
    private static final String LN = System.getProperty("line.separator");

    /**.
     * It's inner and outer system stream
     */
    private final InputStream sysIn = System.in;
    private final PrintStream sysOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    /**.
     * Change system stream
     * @param text
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
     * @throws IOException
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
     * @param console
     * @param inPhrases
     * @param outPhrases
     * @throws IOException
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
