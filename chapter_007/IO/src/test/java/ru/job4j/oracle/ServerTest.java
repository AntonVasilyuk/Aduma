package ru.job4j.oracle;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.when;

public class ServerTest {

    /**.
     * It's delimetr
     */
    private static final String LN = System.lineSeparator();

    /**.
     * Test exiting
     * @throws IOException
     */
    @Test
    public void whenEnterExitThenStopedServer() throws IOException {
        testing("exit", LN);
    }

    /**.
     * Test greating
     * @throws IOException
     */
    @Test
    public void whenHelloThenServerGreeting() throws IOException {
        String input = Joiner.on(LN).join("Hello", "exit");
        String expected = String.format("Hello, dear friend, I'm a oracle.%s%s%s", LN, LN, LN);
        testing(input, expected);
    }

    /**.
     * Test working
     * @throws IOException
     */
    @Test
    public void whenAskThenServerAnswer() throws IOException {
        String text = "Another phrases...";
        String input = Joiner.on(LN).join("Hello", "Say the word Phrase","exit");
        String expected = String.format("Hello, dear friend, I'm a oracle.%s%s%s%s%s%s", LN, LN,text, LN, LN, LN);
        testing(input, expected);
    }

    /**.
     * Method for testing
     * @param inPhrases it's inner phrases
     * @param expected it's expected phrases
     * @throws IOException
     */
    private void testing(String inPhrases, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(inPhrases.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(expected));
    }
}
