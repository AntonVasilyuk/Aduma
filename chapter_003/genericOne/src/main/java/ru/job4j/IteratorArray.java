package ru.job4j;

import java.lang.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task 5.2.1
 * Create generic
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class IteratorArray implements Iterator {
    private final int[] values;
    private int index = 0;

    public IteratorArray(final int[] values) {
        this.values = values;
    }

    public boolean hasNext() {return this.values.length > index;}
    public Object next() {return this.values[index++];}

    @Override
    public void remove() {

    }
}
