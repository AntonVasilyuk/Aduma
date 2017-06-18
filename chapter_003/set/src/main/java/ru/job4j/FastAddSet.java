package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task 5.4.3.
 * Update method add for set
 *
 * Created by Anton Vasilyuk on 17.06.2017.
 * @version 1.0
 */

public class FastAddSet<E> implements Iterable {

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
    public FastAddSet(int aSize) {
        this.size = aSize;
        container = new Object[aSize];
    }

    /**.
     * Method for add element to the set
     * @param value is element
     */
    public void addFirst(E value) {
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
     * Method faster Add element to the set
     * @param value is element for adding
     */
    public void addSecond(E value) {
        if (value == null) {throw new NullPointerException("Element is null");}
        if (cursor == 0) {
            container[cursor] = value;
            cursor++;
        } else {
            int position = searchValue(value, container, 0, cursor - 1);

            if (position != -1) {
                if (this.cursor < container.length) {
                    for (int i = cursor; i > position; i--) {
                        container[i] = container[i - 1];
                    }
                    container[position] = value;
                    cursor++;
                } else {
                    Object[] newConteiner = new Object[size * 2];
                    System.arraycopy(container, 0, newConteiner, 0, size);
                    container = newConteiner;
                    for (int i = cursor; i > position; i--) {
                        container[i] = container[i - 1];
                    }
                    container[position] = value;
                    cursor++;
                }
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
                return cursorIter < cursor;
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
     * Method for search element in the set, and return index for new element
     * @param value is element for adding
     * @param array is array for set
     * @param start is start index
     * @param end is finish index
     * @return return index for the element or -1
     */
    public int searchValue(E value, Object[] array, int start, int end) {
        int result = -1;
        int low = start;
        int high = end;
        int mid = low + (high - low) / 2;
        if (high == low && !array[0].equals(value)) {
            if (value.hashCode() > array[low].hashCode()) {
                return 1;
            } else {
                return 0;
            }
        }

        if (high == low + 1) {
            if (array[low].equals(value) || array[high].equals(value)) {return -1;}
            if (value.hashCode() < array[low].hashCode()) {return 0;}
            else if (value.hashCode() < array[high].hashCode()) {return 1;}
            else {return 2;}
        }

        if (start > end || value == null || array == null) {return -1;}

        if (value.hashCode() < array[mid].hashCode()) {
            if (((mid - 1) - low) == 1 || ((mid - 1) == low)) {
                if (!array[mid - 1].equals(value) && !array[low].equals(value)) {return mid - 1;}}
            return searchValue(value, array, low, mid - 1 );
        } else if (value.hashCode() > array[mid].hashCode()) {
            if ((high - (mid + 1)) == 1 || high == (mid + 1)) {
                if (!array[mid + 1].equals(value) && !array[high].equals(value)) {return high;}}
            return searchValue(value, array, mid + 1, high);
        } else if (array[mid].equals(value)) {return -1;}
        else {return result;}
    }
}
