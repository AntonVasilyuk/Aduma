package ru.job4j.dropWords;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class DropWordsTest {

    /**.
     * It's example testing class for test this work
     */
    DropWords exampleTestClass = new DropWords();

    @Test
    public void whenNeedDeletingWord() {
        String text = "It's line for test";
        String textForResult = "It's line for ";
        String[] arrayWords = new String[1];
        arrayWords[0] = "test";

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        exampleTestClass.dropAbuses(arrayInputStream, arrayOutputStream, arrayWords);
        String result = arrayOutputStream.toString();
        assertTrue(result.equals(textForResult));
    }

    @Test
    public void whenNeedDropWordsUsesSreamApi() {
        String text = "It's line for test";
        String textForResult = "It's line for ";
        String[] arrayWords = new String[1];
        arrayWords[0] = "test";

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        exampleTestClass.dropAbusesStreamAPI(arrayInputStream, arrayOutputStream, arrayWords);
        String result = arrayOutputStream.toString();
        assertTrue(result.equals(textForResult));
    }
}
