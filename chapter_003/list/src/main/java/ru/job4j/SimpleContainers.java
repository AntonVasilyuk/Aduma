package ru.job4j;

/**.
 * Task 5.3.1
 * Create model for collection
 * @author  Anton Vasilyuk on 12.06.2017.
 * @version 1.0
 * @param <E> generic type
 */
public interface SimpleContainers<E> extends Iterable<E> {

    /**.
     * Add element
     * @param value is value for adding
     */
    void add(E value);

    /**.
     * Get element
     * @param index is index position for getting
     * @return element
     */
    E get(int index);
}
