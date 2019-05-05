package ru.job4j;

import java.util.Iterator;

/**.
 * Task 4.1.4
 * Create iterator for iterators
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public interface IteratorInterface {

    /**.
     * Method for convertion interators
     * @param it it's iterator
     * @return result converting
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);

}
