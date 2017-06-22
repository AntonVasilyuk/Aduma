package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 5.5.2.
 * Create test for my map
 *
 * Created by ANTON VASILYUK on 21.06.2017.
 * @version 1.0
 */
public class MyMapTest {

    /**.
     * @map is link to the map
     */
    MyMap map;

    /**.
     * Is prepating for testing
     */
    @Before
    public void preparingFoeTest() {
        map = new MyMap(3);
    }

    /**.
     * Test working method put when add two time with one the key
     */
    @Test
    public void whenPutTwoElementWithSemilarKey() {
        User userFirst = new User("Egor", 2, 1985, 5, 25);
        User userSecond = new User("Egor", 2, 1985, 5, 25);
        String testFirst = "First object";
        String testSecond = "Second object";
        map.put(userFirst, testFirst);
        map.put(userSecond, testSecond);
        map.print();
    }

    /**.
     * Test working method get
     */
    @Test
    public void whenGetElementByKey() {
        User user = new User("Egor", 2, 1985, 5, 25);
        String testFirst = "Bingo";
        map.put(user, testFirst);
        String testSecond = (String) map.get(user);
        boolean result = false;
        if (testFirst.equals(testSecond)) {result = true;}
        assertThat(result, is(true));
    }

    /**.
     * Test working put when key is null
     */
    @Test
    public void whenPutKeyIsNull() {
        User user = null;
        String test = "Test";
        try {
            map.put(user, test);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Key is null"));
        }
    }

    /**.
     * Test working put when value is null
     */
    @Test
    public void whenPutValueIsNull() {
        User user = new User("Egor", 2, 1985, 5, 25);
        String test = null;
        try {
            map.put(user, test);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Element is null"));
        }
    }

    /**.
     * Test working get when key is null
     */
    @Test
    public void whenGetKeyIsNull() {
        User user = null;
        try {
            map.get(user);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Key is null"));
        }
    }
}