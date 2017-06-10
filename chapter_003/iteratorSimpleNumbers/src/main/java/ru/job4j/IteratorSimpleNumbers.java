package ru.job4j;

import java.util.*;
/**
 * Task 4.1.3
 * Create iterator for simple numbers
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class IteratorSimpleNumbers implements Iterator {

    /**
     * .
     *
     * @index is index array
     */
    private int index = 0;

    /**
     * .
     * Colon array
     */
    int colon = 0;

    /**
     * .
     *
     * @value is array numbers
     */
    private int[][] values;

    /**
     * .
     * Constructor for class Iterator SimpleNumbers
     *
     * @param value is array numbers
     */
    public IteratorSimpleNumbers(int[][] value) {
        this.values = value;
    }

    /**
     * .
     * Method for check next member array
     *
     * @return is there a next element
     */
    @Override
    public boolean hasNext() {

        if (this.values == null) {
            throw new NoSuchElementException("In this array not element");
        }
        int checkNum = 0;
        for (int i = 0; i < this.values.length; i++) {
            for (int j = 0; j < this.values[i].length; j++) {
                int checkSimple = 1;
                for (int x = 2; x < this.values[i][j]; x++) {
                    if ((this.values[i][j] % x) == 0) {
                        checkSimple = 0;
                    }
                }
                if (checkSimple == 1) {
                    checkNum++;
                }
            }
        }
        if (checkNum == 0) {
            return false;
        }
        if (!(this.values.length > colon)) {
            return false;
        }
        if (this.values[colon].length > index) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * .
     * Method for output next simple number
     *
     * @return simple number
     */
    @Override
    public Object next() {
        int num;
        if (hasNext()) {
            do {
                num = 1;
                for (int i = 2; i < this.values[colon][index]; i++) {
                    if ((this.values[colon][index] % i) == 0) {
                        num = 0;
                    }
                }
                if (num > 0) {break;}
                index++;
            } while (num > 0);
        } else {
            colon++;
            index = 0;
            if (hasNext()) {
                do {
                    num = 1;
                    for (int i = 2; i < this.values[colon][index]; i++) {
                        if ((this.values[colon][index] % i) == 0) {
                            num = 0;
                        }
                    }
                    if (num > 0) {break;}
                    index++;
                } while (num > 0);
            }
        }
        return this.values[colon][index++];
    }
}