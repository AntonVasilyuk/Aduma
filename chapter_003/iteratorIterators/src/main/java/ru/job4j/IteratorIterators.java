package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Task 4.1.4
 * Create iterator for iterators
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class IteratorIterators implements IteratorInterface, Iterator {

    /**.
     * @iter is iterator iterators
     */
    private Iterator<Iterator<Integer>> iter;

    /**.
     * @subIter is value for iterator
     */
    private Iterator<Integer> subIter = null;

    /**.
     * Method for transform iterator iterators to one iterators<Integer>
     * @param it is input iterator
     * @return result iterator
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.iter = it;
        if (this.iter.hasNext()) {
            this.subIter = it.next();
        }
        return this;
    }

    /**.
     * Check is there a next element
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (iter == null) {
            throw new NoSuchElementException("No element in this array.");
        }
        if (subIter.hasNext() || iter.hasNext()) {
            result = true;
        }
        return result;
    }

    /**.
     * Realization method next for input iterators
     * @return number
     */
    @Override
    public Integer next() {
        Integer result = 0;
        if (subIter.hasNext()) {
            result = subIter.next();
        } else if (iter.hasNext()) {
            subIter = iter.next();
            result = subIter.next();
        } else {
            new NoSuchElementException("No number!");
        }
        return result;
    }
}
