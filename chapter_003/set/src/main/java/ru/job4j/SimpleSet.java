package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task 5.4.1.
 * Create my set
 *
 * Created by ANTON on 16.06.2017.
 * @version 1.0
 */
public class SimpleSet<E> implements Iterable {

    private int cursor = 0;

    private int cursorIter = 0;

    private int size;

    private Object[] container;

    public SimpleSet(int aSize) {
        this.size = aSize;
        container = new Object[aSize];
    }

    public void add(E value) {
        if (value == null) {throw new NullPointerException("Element is null");}
        boolean check = true;
        for (int i = 0; i < cursor; i++) {
            String temp = (String) container[i];
            if (temp.equals(value)) {check = false;}
        }
        if (check) {
            if(this.cursor < container.length) {
                container[cursor] = value;
                cursor++;
            } else {
                Object[] newConteiner = new Object[size * 2];
                System.arraycopy(container, 0, newConteiner, 0, size);
                container = newConteiner;
                container[size] = value;
                cursor++;
            }
        }

    }
    /**.
     * Realisation iterator
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = (Iterator<E>) new Iterator<Object>() {

            @Override
            public boolean hasNext() {
                return cursorIter < container.length;
            }

            @Override
            public Object next() {
                if (hasNext()) {return container[cursorIter++];}
                else {throw new NoSuchElementException("Need add cell in this array");}
            }

            @Override
            public void remove() {
                container[cursorIter] = null;
                cursorIter--;
            }
        };
        return it;
    }

}
