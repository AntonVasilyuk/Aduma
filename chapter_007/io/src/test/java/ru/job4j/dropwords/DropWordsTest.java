package ru.job4j.dropwords;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertTrue;

/**
 * Testing class DropWords.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 27.03.2019
 */

public class DropWordsTest {

    /**.
     * It's example testing class for test this work
     */
    private final DropWords exampleTestClass = new DropWords();

    /**.
     * Test working apps when need deleting word
     */
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

    /**.
     * Test working apps when need deleting word with stream api
     */
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
