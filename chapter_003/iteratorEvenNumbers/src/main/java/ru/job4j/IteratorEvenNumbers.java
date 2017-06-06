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
        return this.values.length > index;
    }

    /**
     * Realisation iterator for even number
     * @return object on this position
     */
    @Override
    public Object next() {
        if(hasNext()) {
            while ((this.values[index] % 2) != 0) {
                index++;
                }
            }
        return this.values[index++];
    }
}

