package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
 * Task 5.4.3.
 * Test working my FastAddSet
 *
 * Created by ANTON on 17.06.2017.
 * @version 1.0
 */
public class FastAddSetTest {

    /**.
     * Link for first set
     */
    private FastAddSet linkOne;

    /**.
     * Link for second set
     */
    private FastAddSet linkTwo;

    /**.
     * Preparing for test
     */
    @Before
    public void preparingForTest() {
        linkOne = new FastAddSet(100000);
        linkTwo = new FastAddSet(100000);

    }

    /**.
     * Test for improving the method of adding
     */
    @Test
    public void whenNeewFasteraddElementToTheSet() {

        long firstTimeOne = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkOne.addFirst(String.format("%s", i));
        }
        long secondTimeOne = System.currentTimeMillis();
        long resultOne = secondTimeOne - firstTimeOne;
        System.out.println("Old method adding " + linkOne.getSize() + " element for the " + resultOne + " milisec.");

        long firstTimeTwo = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkTwo.addSecond(String.format("%s", i));
        }
        long secondTimeTwo = System.currentTimeMillis();
        long resultTwo = secondTimeTwo - firstTimeTwo;
        System.out.println("New method adding " + linkTwo.getSize() + " element for the " + resultTwo + " milisec.");

        boolean result = false;
        if (resultOne > resultTwo) {
            result = true;
        }
        assertThat(result, is(true));
    }

    /**.
     * Test Add when element is null
     */
    @Test
    public void whenAddElementIsNull() {
        String value = null;
        try {
            linkTwo.addSecond(value);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Element is null"));
        }
    }

    /**.
     * Test Add when add word to the set more time
     */
    @Test
    public void whenAddOneElementTwoTimeThenAddOnlyOne() {
        String oneWord = "Bingo!";
        String twoWord = "Test!";
        linkTwo.addSecond(oneWord);
        linkTwo.addSecond(twoWord);
        linkTwo.addSecond(oneWord);
        linkTwo.addSecond(oneWord);
        linkTwo.addSecond(twoWord);

        linkTwo.iterator().next();
        linkTwo.iterator().next();
        boolean result = linkTwo.iterator().hasNext();

        assertThat(result, is(false));
    }
}