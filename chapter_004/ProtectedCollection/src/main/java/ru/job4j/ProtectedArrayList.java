package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task 7.3.3.
 * Modification ArrayList from task 5.3.1.
 *
 * @author Anton Vasilyuk on 30.07.2017.
 * @version 1.0.
 */
@ThreadSafe
public class ProtectedArrayList<E> implements Iterable<E> {

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

    private final Object lock = new Object();

    /**.
     * @container is array objects
     */
    @GuardedBy("lock")
    private Object[] container;

    /**.
     * Constructor fot this class
     * @param size
     */
    public ProtectedArrayList(int size) {
        this.container = new Object[size];
        this.size = size;
    }

    /**.
     * Method for add object to array
     * @param value
     */
    public void add(E value) {
        synchronized (lock) {
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
    }

    /**.
     * Method for return object from index position
     * @param index
     * @return
     */
    public E get(int index) {
        synchronized (lock) {
            E result = null;
            if (index < cursor) {
                result = (E) container[index];
            } else {
                throw new IndexOutOfBoundsException("On this position no element");
            }
            return result;
        }
    }

    /**.
     * Realisation iterable
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        synchronized (lock) {
            Iterator<E> it = (Iterator<E>) new Iterator<Object>() {

                @Override
                public boolean hasNext() {
                    return cursorIter < size;
                }

                @Override
                public Object next() {
                    if (hasNext()) {
                        return container[cursorIter++];
                    } else {
                        throw new NoSuchElementException("Need add cell in this array");
                    }
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

    /**.
     * Method for checking size container
     * @return
     */
    public int sizeObjects() {
        synchronized (lock) {
            int numElement = 0;
            for (int i = 0; i < container.length; i++) {
                if (container[i] != null) {
                    numElement++;
                }
            }
            return numElement;
        }
    }
}

