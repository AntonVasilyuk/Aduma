package ru.job4j;

import java.util.*;
/**
 * Task 4.1.1
 * Create Iterator
 *
 * @author Anton Vasilyuk on 03.06.2017.
 * @version 1.0
 * @since 0.1
 */

public class IteratorArray implements Iterator {

    private int[][] value;
    private int index = 0;
    private int colon = 0;

    @Override
    public boolean hasNext() {
        return this.value.length > index;
    }

    @Override
    public Object next() {
        if(hasNext()) {
            
        }
        return null;
    }
}
