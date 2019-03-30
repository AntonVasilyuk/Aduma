package ru.job4j.consoleChat;

import com.google.common.base.Joiner;
import org.junit.After;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Testing class ChatLogic.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 27.03.2019
 */

public class ChatLogicTest {

    /**.
     * It's system separator
     */
    private final String LN = System.getProperty("line.separator");

    /**.
     * It's saving system input strem
     */
    private final InputStream sysIn = System.in;

    /**.
     * It's saving system output strem
     */
    private final PrintStream sysOut = System.out;

    /**.
     * It's stream input for testing
     */
    private ByteArrayInputStream in;

    /**.
     * It's stream output for testing
     */
    private ByteArrayOutputStream out;

    /**.
     * Set system stream on testing streams
     * @param text text for send to console
     */
    public void setStream(String text) {
        in = new ByteArrayInputStream(text.getBytes());
        out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
    }

    public void rollBackSystemStream() {
        System.setIn(sysIn);
        System.setOut(sysOut);
    }

    @Test
    public void whenClienSendStopThenAppIsStop() {
        setStream("stop");
        ChatLogic logic = new ChatLogic();
        logic.startChat();
        String[] textAll = out.toString().split("\n");
        String lastLine = textAll[textAll.length - 1];
        assertTrue(lastLine.equals("Chat is stoped"));
        rollBackSystemStream();
    }

    @Test
    public void whenClienSendPauseAndResumeThenAppIsPauseAndResume() {
        String text = Joiner.on(LN).join("pause", "resume", "stop");
        setStream(text);
        ChatLogic logic = new ChatLogic();
        logic.startChat();
        String[] textAll = out.toString().split(LN);
        boolean paused = false;
        boolean resumed = false;
        for (String s : textAll) {
            if (s.equals("Chat paused")) paused = true;
            if (s.equals("Chat resumed, i am at your service")) resumed = true;
        }
        assertTrue(paused && resumed);
        rollBackSystemStream();
    }

    @Test
    public void whenClientAskedSecondThenAnswerMustBeAnouther() {
        String text = Joiner.on(LN).join("questionFirst", "questionSecond", "stop");
        setStream(text);
        ChatLogic logic = new ChatLogic();
        logic.startChat();
        String[] textAll = out.toString().split(LN);
        boolean result = !textAll[3].equals(textAll[4]);
        assertTrue(result);
        rollBackSystemStream();
    }
}
