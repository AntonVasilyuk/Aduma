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
    private PseodoArrayList link;

    /**.
     * Constructor for SimpleSetArray
     * @param aSize
     */
    public SimpleSetArray(int aSize) {
        this.size = aSize;
        link = new PseodoArrayList(aSize);
    }

    /**.
     * Method for add element to the set
     * @param value is element
     */
    public void add(E value) {
        if (value == null) {throw new NullPointerException("Element is null");}
        boolean check = true;
        for (int i = 0; i < cursor; i++) {
            E temp = (E) link.get(i);
            if (temp.equals(value)) {check = false;}
        }
        if (check) {
            link.add(value);
            cursor++;
        }
    }

    /**.
     * Realisation iterator for set
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = (Iterator<E>) new Iterator<Object>() {

            @Override
            public boolean hasNext() {
                return cursorIter < link.sizeObjects();
            }

            @Override
            public Object next() {
                if (hasNext()) {return link.get(cursorIter++);}
                else {throw new NoSuchElementException("Need add cell in this array");}
            }

            @Override
            public void remove() {
                link.iterator().remove();
                cursorIter--;
            }
        };
        return it;
    }

    public int getSize() {return this.cursor;}
}
