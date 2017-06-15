package ru.job4j;

/**
 * Task 5.3.1
 * Create model for collection
 * @author  Anton Vasilyuk on 12.06.2017.
 * @version 1.0
 */
public interface SimpleContainers<E> extends Iterable<E> {

    void add(E value);

    E get(int index);
}
