package ru.job4j.checkbytearray;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Class for checking byte array.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 04.03.2019
 */
public class CheckByteArray {

    /**.
     * Logger
     */
    private static final Logger LOG = Logger.getLogger(CheckByteArray.class);

    /**.
     * Checking entered text is it even number
     * @param in entering stream
     * @return true if it's even number
     */
    public boolean isNumber(InputStream in) {
        String check = "[-+]?\\d+";
        boolean result = false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line = br.readLine();
            if (line.matches(check)) {
                if (Integer.parseInt(line) % 2 == 0) {
                    result = true;
                }
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
}
