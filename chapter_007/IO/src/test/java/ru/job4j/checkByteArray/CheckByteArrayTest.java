package ru.job4j.checkByteArray;

import org.junit.Test;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CheckByteArrayTest {

    private CheckByteArray checkByteArray = new CheckByteArray();

    @Test
    public void whenEnteringNumberIsEven() {
        try(ByteArrayInputStream is = new ByteArrayInputStream("12".getBytes())) {
            assertTrue(checkByteArray.isNumber(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenEnteringNumberIsNotEver() {
        try(ByteArrayInputStream is = new ByteArrayInputStream("13".getBytes())) {
            assertFalse(checkByteArray.isNumber(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenEnteringNumberIsNotNumber() {
        try (ByteArrayInputStream is = new ByteArrayInputStream("qq".getBytes())) {
            assertFalse(checkByteArray.isNumber(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
