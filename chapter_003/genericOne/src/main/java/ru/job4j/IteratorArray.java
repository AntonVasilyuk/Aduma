package ru.job4j;


import java.util.Iterator;

/**.
 * Task 5.2.1
 * Create generic
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class IteratorArray implements Iterator {

    /**.
     * Array for storing elemetns
     */
    private final int[] values;

    /**.
     * Index
     */
    private int index = 0;

    /**.
     * Constructor
     * @param values array for storing elemetns
     */
    public IteratorArray(final int[] values) {
        this.values = values;
    }

    /**.
     * Check next element
     * @return result checking
     */
    public boolean hasNext() {
        return this.values.length > index;
    }

    /**.
     * Get next element
     * @return next element
     */
    public java.lang.Object next() {
        return this.values[index++];
    }

    /**.
     * Method for deleting element
     */
    @Override
    public void remove() {

    }
}
