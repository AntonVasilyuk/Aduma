package ru.job4j;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Task 5.3.4.
 * Test check for cyclicity
 *
 * Created by ANTON VASILYUK on 16.06.2017.
 * @version 1.0
 */
public class CycleListTest {

    /**.
     * Test check on cyclicity
     */
    @Test
    public void whenCheckOnCyclicityList() {

        CycleList list = new CycleList();
        Integer one = 1;
        Integer two = 2;
        Integer tree = 3;
        Integer four = 4;
        list.add(one);
        list.add(two);
        list.add(tree);
        list.add(four);

        list.makeCycle();
        boolean result = list.hasCycle();

        assertThat(result, is(true));
    }

    /**.
     * Test if no element
     */
    @Test
    public void whenListIsEmpty() {
        CycleList list = new CycleList();
        try {
            list.hasCycle();
        } catch (NoSuchElementException nee) {
            assertThat(nee.getMessage(), is("It list is empty"));
        }
    }

    /**.
     * Test if only one element
     */
    @Test
    public void whenOnlyOneElement() {
        CycleList list = new CycleList();
        Integer one = 99;
        list.add(one);
        try {
            list.hasCycle();
        } catch (NoSuchElementException nee) {
            assertThat(nee.getMessage(), is("Add more element!"));
        }
    }
}