package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
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
     * @param value is array
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
        boolean result = false;
        if (this.value == null) {
            throw new NoSuchElementException("No numbers in iterators.");
        }
        if (this.value[colon].length > index) {
            result = true;
        }
        return result;
    }

    /**.
     * Realisation iterator for multidimensional array
     * @return number array
     */
    @Override
    public Object next() {
        if (hasNext()) {
            return this.value[colon][index++];
        } else {
            index = 0;
            colon++;
            if (hasNext()) {
                return this.value[colon][index++];
            } else {
                throw new ArrayIndexOutOfBoundsException("The number were over");
            }
        }
    }
}
