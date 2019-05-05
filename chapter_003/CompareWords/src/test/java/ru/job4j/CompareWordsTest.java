package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**.
 * Task 5.7.3.
 * Test class CompareWords
 *
 * @author Anton Vasilyuk on 15.10.2017
 * @version 1.0.
 */
public class CompareWordsTest {

    /**.
     * @wordOne is first word
     */
    private String wordOne;

    /**.
     * @wordTwo is second word
     */
    private String wordTwo;

    /**.
     * @link is link to the main object
     */
    private CompareWords link;

    /**.
     * Preparing for tests
     */
    @Before
    public void preparingForTest() {
        link = new CompareWords();
    }

    /**.
     * Test one method when checking two words, few recurring characters
     */
    @Test
    public void whenLettersTheWordEqualLettersAnotherThenTrue() {
        wordOne = "QWERTYU";
        wordTwo = "UYTREWQ";

        boolean result = link.compareWordsOne(wordOne, wordTwo);
        assertThat(result, is(true));
    }

    /**.
     * Test one method when checking two words, few different characters
     */
    @Test
    public void whenLettersTheWordNoEqualLettersAnotherThenTrue() {
        String wordOne = "QWEARTYU";
        String twoWord = "UYTRBEWQ";
        boolean result = link.compareWordsOne(wordOne, twoWord);
        assertThat(result, is(false));
    }

    /**.
     * Test one method when checking two words, a lot of recurring characters
     */
    @Test
    public void whenWordsVeryBig() {
        char[] one = new char[1000000];
        char[] two = new char[1000000];
        for (int i = 0; i < 1000000; i++) {
            if ((i % 2) == 0) {
                one[i] = 'A';
                two[i] = 'B';
            }
            if ((i % 2) != 0) {
                one[i] = 'B';
                two[i] = 'A';
            }
        }
        String wordOne = String.copyValueOf(one);
        String twoWord = String.copyValueOf(two);
        boolean result = link.compareWordsOne(wordOne, twoWord);
        assertThat(result, is(true));
    }

    /**.
     * Test second method when 1000000 charecters in words
     */
    @Test
    public void whenWordsVeryBigSecondMethod() {
        char[] one = new char[1000000];
        char[] two = new char[1000000];
        for (int i = 0; i < 1000000; i++) {
            if ((i % 2) == 0) {
                one[i] = 'A';
                two[i] = 'B';
            }
            if ((i % 2) != 0) {
                one[i] = 'B';
                two[i] = 'A';
            }
        }
        String wordOne = String.copyValueOf(one);
        String twoWord = String.copyValueOf(two);
        boolean result = link.compareWordsTwo(wordOne, twoWord);
        assertThat(result, is(true));
    }

    /**.
     * Test second method when 500000 charecters in words
     */
    @Test
    public void whenWordsVeryBigQSecondMethod() {
        char[] one = new char[500000];
        char[] two = new char[500000];
        for (int i = 0; i < 500000; i++) {
            if ((i % 2) == 0) {
                one[i] = 'A';
                two[i] = 'B';
            }
            if ((i % 2) != 0) {
                one[i] = 'B';
                two[i] = 'A';
            }
        }
        String wordOne = String.copyValueOf(one);
        String twoWord = String.copyValueOf(two);
        boolean result = link.compareWordsTwo(wordOne, twoWord);
        assertThat(result, is(true));
    }

    /**.
     * Test second method when 500000 charecters in words
     */
    @Test
    public void whenNeedCompareNumberFirstMethod() {
        String wordOne = "113";
        String twoWord = "133";
        boolean result = link.compareWordsOne(wordOne, twoWord);
        assertThat(result, is(false));
    }

    /**.
     * Test second method when 500000 charecters in words
     */
    @Test
    public void whenNeedCompareNumberSecondMethod() {
        String wordOne = "1131";
        String twoWord = "1331";
        boolean result = link.compareWordsTwo(wordOne, twoWord);
        assertThat(result, is(false));
    }
}