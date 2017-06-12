package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task 4.1.2
 * Create Iterator even numbers
 *
 * @author Anton Vasilyuk on 03.06.2017.
 * @version 1.0
 * @since 0.1
 */

public class IteratorEvenNumbers implements Iterator {

    /**.
     * @values is array numbers
     */
    private int[] values;

    /**.
     * @index is index array
     */
    private int index = 0;

    /**.
     * Amount returned even numbers
     */
    private int returnCheckNum = 0;
    /**.
     * Constructor for class IteratorEvenNumber
     * @param values is array numbers
     */
    public IteratorEvenNumbers(int[] values) {
        this.values = values;
    }

    /**.
     * Check latest index
     * @return boolean
     */
    @Override
    public boolean hasNext() {

        if (this.values == null) {
            throw new NoSuchElementException("No element in this array.");
        }
        int checkNum = 0;
        for (int j = 0; j < this.values.length; j++) {
            if ((this.values[j] % 2) == 0) {checkNum++;}
        }
        if (checkNum == 0) {return false;}
        if (returnCheckNum == checkNum) {return false;}
        if (this.values.length > index) {
            return true;
        } else  {return false;}
    }

    /**
     * Realisation iterator for even number
     * @return object on this position
     */
    @Override
    public Object next() {
        if (hasNext()) {
            while ((this.values[index] % 2) != 0) {
                index++;
            }
        }
        returnCheckNum++;
        return this.values[index++];
    }
}

