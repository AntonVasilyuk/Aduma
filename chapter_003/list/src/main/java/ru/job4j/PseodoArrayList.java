package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task 5.3.1
 * Create model for PseodoArrayList
 * @author  Anton Vasilyuk on 12.06.2017.
 * @version 1.0
 */
public class PseodoArrayList<E> implements SimpleContainers<E> {

    /**.
     * @size is size array
     */
    private int size;

    /**.
     * @cursor is a place cursor
     */
    private int cursor = 0;

    /**
     * @cursorIter is position for iterator
      */
    private int cursorIter = 0;
    /**.
     * @container is array objects
     */
    private Object[] container;

    /**.
     * Constructor fot this class
     * @param size
     */
    public PseodoArrayList(int size) {
        this.container = new Object[size];
        this.size = size;
    }

    /**.
     * Method for add object to array
     * @param value
     */
    public void add(E value) {
        if (cursor < size) {
            this.container[cursor] = value;
            cursor++;
        } else {
            int sizeTemp = size * 2;
            Object[] newContainer = new Object[sizeTemp];
            System.arraycopy(container, 0, newContainer, 0, size);
            container = newContainer;
            size = sizeTemp;
            this.container[cursor] = value;
            cursor++;
        }
    }

    /**.
     * Method for return object from index position
     * @param index
     * @return
     */
    public E get(int index) {
        E result = null;
        if (index < cursor) {result = (E) container[index];}
        else {throw new IndexOutOfBoundsException("On this position no element");}
        return result;
    }

    /**.
     * Realisation iterable
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = (Iterator<E>) new Iterator<Object>() {

            @Override
            public boolean hasNext() {
                return cursorIter < size;
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

    /**.
     * Method for checking size container
     * @return
     */
    public int sizeObjects() {
        int numElement = 0;
        for (int i = 0; i < container.length; i++) {
            if (container[i] != null) {numElement++;}
        }
        return numElement;
    }
}
