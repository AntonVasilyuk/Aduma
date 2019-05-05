package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Task 5.5.2. and Task 5.5.8.
 * Create test for my map
 *
 * Created by ANTON VASILYUK on 21.06.2017.
 * @version 1.0
 */
public class MyMapTest {

    /**.
     * @map is link to the map
     */
    private MyMap map;

    /**.
     * @mapSecond is link to the second map
     */
    private MyMap mapSecond;

    /**.
     * Is prepating for testing
     */
    @Before
    public void preparingFoeTest() {
        map = new MyMap(3);
        mapSecond = new MyMap(3);
    }

    /**.
     * Test working method put when add two time with one the key
     */
    @Test
    public void whenInsertTwoElementWithSemilarKeyThenReturnFalse() {
        User userFirst = new User("Egor", 2, 1985, 5, 25);
        User userSecond = new User("Egor", 2, 1985, 5, 25);
        String testFirst = "First object";
        String testSecond = "Second object";
        map.insert(userFirst, testFirst);
        boolean result = map.insert(userSecond, testSecond);
        map.print();
        assertThat(result, is(false));
    }

    /**.
     * Test working method get
     */
    @Test
    public void whenGetElementByKey() {
        User user = new User("Egor", 2, 1985, 5, 25);
        String testFirst = "Bingo";
        map.insert(user, testFirst);
        String testSecond = (String) map.get(user);
        boolean result = false;
        if (testFirst.equals(testSecond)) {
            result = true;
        }
        assertThat(result, is(true));
    }

    /**.
     * Test working put when key is null
     */
    @Test
    public void whenInsertKeyIsNull() {
        User user = null;
        String test = "Test";
        try {
            map.insert(user, test);
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Key is null"));
        }
    }

    /**.
     * Test working put when value is null
     */
    @Test
    public void whenInsertValueIsNull() {
        User user = new User("Egor", 2, 1985, 5, 25);
        String test = null;
        try {
            map.insert(user, test);
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

    /**.
     * Test method Remove
     */
    @Test
    public void whenRemoveElement() {
        User userOne = new User("Egor", 2, 1985, 5, 25);
        String one = "Test";
        map.insert(userOne, one);
        boolean result = map.remove(userOne);
        assertThat(result, is(true));
    }

    /**.
     * Test working iterator
     */
    @Test
    public void whenMapContainTwhElementAndTwoTimeNextThenHasNextReturnFalse() {
        User userFirst = new User("Ivan", 3, 1981, 5, 21);
        User userSecond = new User("Egor", 2, 1985, 5, 25);
        String testFirst = "First object";
        String testSecond = "Second object";
        map.insert(userFirst, testFirst);
        map.insert(userSecond, testSecond);
        map.iterator().next();
        map.iterator().next();
        boolean result = map.iterator().hasNext();
        assertThat(result, is(false));
    }

    /**.
     * Test
     */
    @Test
    public void whenCheckSpeedWorkingInsert() {
        long timeFirst = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            map.insert(new User(String.format("$s", i), 1, 2000, 1, 31), "Test");
        }
        long timeSecond = System.currentTimeMillis();
        long resultOne = timeSecond - timeFirst;

        timeFirst = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            mapSecond.insert(new User(String.format("$s", i), 1, 2000, 1, 31), "Test");
        }
        timeSecond = System.currentTimeMillis();
        long resultTwo = timeSecond - timeFirst;

        boolean result = false;
        if ((resultOne - resultTwo) < 1000) {
            result = true;
        }
        assertThat(result, is(true));
    }
}