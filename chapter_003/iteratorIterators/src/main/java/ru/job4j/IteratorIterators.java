package ru.job4j;

import java.util.*;
/**
 * Task 4.1.4
 * Create iterator for iterators
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class IteratorIterators implements Iterator{
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
