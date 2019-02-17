package ru.job4j.checkByteArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CheckByteArray {

    /**.
     * Constructor
     */
    public CheckByteArray() {
    }

    /**.
     * Checking enterring text
     * @param in entering stream
     * @return true if it's even number
     */
    boolean isNumber(InputStream in) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))){
            String line = br.readLine();
            if (!isDigit(line)) {
                return false;
            }
            if(Integer.parseInt(line)%2 == 0) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**.
     * Checking text is digit
     * @param s is text
     * @return
     * @throws NumberFormatException
     */
    private static boolean isDigit(String s) {
        if (s.matches("[-+]?\\\\d+")) {
            return true;
        } else {
            return false;
        }
    }
}
