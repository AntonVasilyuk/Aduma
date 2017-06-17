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
public class SimpleSetArray<E> implements Iterable {

    /**.
     * @Cursor is cursor in the set
     */
    private int cursor = 0;

    /**.
     * @cursorIter is location iterator
     */
    private int cursorIter = 0;

    /**.
     * @size is size array for set
     */
    private int size;

    /**.
     * @container is link for set
     */
    private Object[] container;

    /**.
     * Constructor for SimpleSetArray
     * @param aSize
     */
    public SimpleSetArray(int aSize) {
        this.size = aSize;
        container = new Object[aSize];
    }

    /**.
     * Method for add element to the set
     * @param value is element
     */
    public void add(E value) {
        if (value == null) {throw new NullPointerException("Element is null");}
        boolean check = true;
        for (int i = 0; i < cursor; i++) {
            E temp = (E) container[i];
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
