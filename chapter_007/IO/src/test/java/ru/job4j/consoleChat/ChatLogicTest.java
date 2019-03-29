package ru.job4j.consoleChat;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class ChatLogicTest {

    private final String LN = System.getProperty("line.separator");


    @Test
    public void whenClienSendStopThenAppIsStop() {
        InputStream sysIn = System.in;
        OutputStream sysOut = System.out;
        ByteArrayInputStream inputStream = new ByteArrayInputStream("stop".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));
        ChatLogic logic = ChatLogic.getInstance();
        logic.startChat();
        String[] textAll = outputStream.toString().split("\n");
        String lastLine = textAll[textAll.length - 1];
        assertTrue(lastLine.equals("Chat is stoped"));
        System.setOut(new PrintStream(sysOut));
        System.setIn(sysIn);
    }

    @Test
    public void whenClienSendPauseAndResumeThenAppIsPauseAndResume() {
        InputStream sysIn = System.in;
        OutputStream sysOut = System.out;
        String text = Joiner.on(LN).join("pause", "resume", "stop");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));
        ChatLogic logic = ChatLogic.getInstance();
        logic.startChat();
        String[] textAll = outputStream.toString().split(LN);
        boolean paused = false;
        boolean resumed = false;
        for (String s : textAll) {
            if (s.equals("Chat paused")) paused = true;
            if (s.equals("Chat resumed, i am at your service")) resumed = true;
        }
        assertTrue(paused && resumed);
        System.setOut(new PrintStream(sysOut));
        System.setIn(sysIn);
    }

    @Test
    public void whenClientAskedSecondThenAnswerMustBeAnouther() {
        InputStream sysIn = System.in;
        OutputStream sysOut = System.out;
        String text = Joiner.on(LN).join("questionFirst", "questionSecond", "stop");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));
        ChatLogic logic = ChatLogic.getInstance();
        logic.startChat();
        String[] textAll = outputStream.toString().split(LN);
        boolean result = !textAll[3].equals(textAll[4]);
        assertTrue(result);
        System.setOut(new PrintStream(sysOut));
        System.setIn(sysIn);
    }
}
