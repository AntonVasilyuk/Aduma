package ru.job4j;

import java.util.*;
/**
 * Task 4.1.1
 * Create Iterator array
 *
 * @author Anton Vasilyuk on 03.06.2017.
 * @version 1.0
 * @since 0.1
 */

public class IteratorArray implements Iterator {

    /**.
     * @value array numbers
     */
    private int[][] value;

    /**.
     * @index this array
     */
    private int index = 0;

    /**.
     * @colon this array
     */
    private int colon = 0;

    /**.
     * Constructor class Iterator array
     * @param value
     */
    public IteratorArray(int[][] value) {
        this.value = value;
    }

    /**.
     * Check latest index
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        if (this.value == null) {throw new NoSuchElementException("No numbers in iterators.");}
        return this.value != null && this.value.length > index;
    }

    /**.
     * Realisation iterator for multidimensional array
     * @return number array
     */
    @Override
    public Object next() {
        if(hasNext()) {
            return this.value[colon][index++];
        } else {
            index = 0;
            colon++;
            return this.value[colon][index++];
        }
    }
}
