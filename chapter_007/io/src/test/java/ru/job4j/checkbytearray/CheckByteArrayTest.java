package ru.job4j.checkbytearray;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.io.ByteArrayInputStream;

/**.
 * Testing working class CheckByteArray
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 04.03.2019
 */

public class CheckByteArrayTest {

    /**.
     * Link to example class
     */
    private CheckByteArray checkByteArray = new CheckByteArray();

    /**.
     * Test working when entering even number
     */
    @Test
    public void whenEnteringNumberIsEven() {
        ByteArrayInputStream is = new ByteArrayInputStream("12".getBytes());
        boolean result = checkByteArray.isNumber(is);
        assertTrue(result);
    }

    /**.
     * Test working when entering not even number
     */
    @Test
    public void whenEnteringNumberIsNotEven() {
        ByteArrayInputStream is = new ByteArrayInputStream("13".getBytes());
        assertFalse(checkByteArray.isNumber(is));
    }

    /**.
     * Test working when text is not number
     */
    @Test
    public void whenEnteringNumberIsNotNumber() {
        ByteArrayInputStream is = new ByteArrayInputStream("qq".getBytes());
        assertFalse(checkByteArray.isNumber(is));
    }
}
