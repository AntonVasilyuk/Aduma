package ru.job4j;

/**
 * Task 5.6.1.
 * Create my Tree
 *
 * Created by Anton Vasilyuk on 24.06.2017.
 * @version 1.0
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return
     */
    boolean add(E parent, E child);
}