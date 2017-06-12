package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task 5.3.1
 * Create model for PseodoArrayList
 * @author  Anton Vasilyuk on 12.06.2017.
 * @version 1.0
 */
public class PseodoArrayList<E> implements Iterable<E> {

    /**.
     * @size is size array
     */
    private int size;

    /**.
     * @cursor is a place cursor
     */
    private int cursor = 0;

    /**.
     * @container is array objects
     */
    private Object[] container;

    /**.
     * @numElement is amount objects
     */
    private int numElement = 0;

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
        if (iterator().hasNext()) {
            this.container[cursor++] = (Object) value;
        } else {
            int sizeTemp = size + 10;
            Object[] newContainer = new Object[sizeTemp];
            for (int i = 0; i < size; i++) {
                newContainer[i] = container[i];
            }
            container = newContainer;
            size = sizeTemp;
            if (iterator().hasNext()) {
                this.container[cursor++] = (Object) value;
            }
        }
    }

    /**.
     * Method for return object from index position
     * @param index
     * @return
     */
    public Object get(int index) {
        cursor = 0;
        for (int i = 0; i < index; i++) {
            if (iterator().hasNext()) {
                iterator().next();
                cursor++;
            } else {
                throw new NoSuchElementException("There is not such index");
            }
        }
        return container[cursor];
    }

    /**.
     * Realisation iterable
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = (Iterator<E>) new Iterator<Object>() {

            private int cursorIter = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public Object next() {
                if (hasNext()) {return container[cursor];}
                else {throw new NoSuchElementException("Need add cell in this array");}
            }

            @Override
            public void remove() {
                container[cursor] = null;
                cursor--;
            }
        };
        return it;
    }

    /**.
     * Method for checking size container
     * @return
     */
    public int sizeObjects() {
        for (int i = 0; i < container.length; i++) {
            if (container[i] != null) {numElement++;}
        }
        return numElement;
    }
}
