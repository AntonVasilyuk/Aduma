package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task 5.5.2. and Task 5.5.8.
 * Create my map
 *
 * Created by ANTON VASILYUK on 21.06.2017.
 * @version 1.0
 */

public class MyMap<U, E> implements Iterable<Entry>{

    /**.
     * @size is size array for the map
     */
    public int size;

    /**.
     * @cursor is position cursor
     */
    public int cursor = 0;

    /**.
     * @cursor for iterator
     */
    public int cursorIter = 0;

    /**.
     * @map is container for items
     */
    Entry[] map;

    /**.
     * Constrictor for mymap
     * @param size
     */
    public MyMap(int size) {
        map = new Entry[size];
        this.size = size;
    }

    /**.
     * Method for adding key and value to the map
     * @param key is key for map
     * @param value is element for adding
     * @return old element with this key
     */
    public boolean insert(U key, E value) {
        boolean result = false;

        if (key == null) {throw new NullPointerException("Key is null");}
        if (value == null) {throw new NullPointerException("Element is null");}
        if (cursor == 0) {
            map[0] = new Entry(key, value);
            cursor++;
            return true;
        } else {
            int position = searchInsert(key, map, 0, cursor - 1);
            if (position != -1) {
                if(this.cursor < this.size / 100 * 75) {
                    for (int i = this.cursor; i > position; i--) {
                        this.map[i] = this.map[i - 1];
                    }
                    this.map[position] = new Entry(key, value);
                    this.cursor++;
                    result = true;
                } else {
                    int newSize = size * 2;
                    Entry[] newMap = new Entry[newSize];
                    System.arraycopy(map, 0, newMap, 0, size);
                    this.map = newMap;
                    this.size = newSize;

                    for (int i = this.cursor; i > position; i--) {
                        this.map[i] = this.map[i - 1];
                    }
                    this.map[position] = new Entry(key, value);
                    this.cursor++;
                    result = true;
                }
            } else {
                return false;
            }
        }
        return result;
    }

    /**.
     * Method for return element by key
     * @param key is key
     * @return element
     */
    public E get(U key) {
        if (key == null) {throw  new NullPointerException("Key is null");}
        int position = searchGetByKey(key, map, 0, cursor - 1);
        if (position == -1) {throw new NoSuchElementException("The map does not contain this key");}
        return (E) this.map[position].getObject();
    }

    /**.
     * Method for delete element from the map
     * @param key is key of the element
     * @return boolean
     */
    public boolean remove(U key) {
        int position = searchGetByKey(key, map, 0, cursor);
        if (position != -1) {
            for (int i = position; i < cursor; i++) {
                this.map[i] = this.map[i + 1];
            }
            this.cursor--;
            return true;
        } else {return false;}
    }

    /**.
     * Method for printing map
     */
    public void print() {
        System.out.print("This map have: ");
        for (int i = 0; i < cursor; i++) {
            System.out.print(map[i].getObject() + " ,");
        }
    }
    public int searchInsert(U value, Entry[] array, int start, int end) {
        int result = -1;
        int low = start;
        int high = end;
        int mid = low + (high - low) / 2;
        if (high == low && !array[0].getUser().equals(value)) {
            if (value.hashCode() > array[low].getUser().hashCode()) {
                return 1;
            } else {
                return 0;
            }
        }

        if (high == low + 1) {
            if (array[low].getUser().equals(value) || array[high].getUser().equals(value)) {return -1;}
            if (value.hashCode() < array[low].getUser().hashCode()) {return 0;}
            else if (value.hashCode() < array[high].getUser().hashCode()) {return 1;}
            else {return 2;}
        }

        if (start > end || value == null || array == null) {return -1;}

        if (value.hashCode() < array[mid].getUser().hashCode()) {
            if (((mid - 1) - low) == 1 || ((mid - 1) == low)) {
                if (!array[mid - 1].getUser().equals(value) && !array[low].getUser().equals(value)) {return mid - 1;}}
            return searchInsert(value, array, low, mid - 1 );
        } else if (value.hashCode() > array[mid].getUser().hashCode()) {
            if ((high - (mid + 1)) == 1 || high == (mid + 1)) {
                if (!array[mid + 1].getUser().equals(value) && !array[high].getUser().equals(value)) {return high;}}
            return searchInsert(value, array, mid + 1, high);
        } else if (array[mid].hashCode() ==value.hashCode()) {return -1;}
        else {return result;}
    }

    public int searchGetByKey(U value, Entry[] array, int start, int end) {
        if (start > end || value == null || array == null) {
            return -1;
        }
        int result = -1;
        int low = start;
        int high = end;
        int mid = low + (high - low) / 2;
        if (high == low) {
            if (value.hashCode() > array[low].getUser().hashCode()) {
                return 1;
            } else {
                return 0;
            }
        }

        if (high == low + 1) {
            if (value.hashCode() == array[low].getUser().hashCode()) {
                return low;
            } else if (value.hashCode() == array[high].getUser().hashCode()) {
                return high;
            } else {
                return -1;
            }
        }

        if (value.hashCode() < array[mid].getUser().hashCode()) {
            if (((mid - 1) - low) == 1 || ((mid - 1) == low)) {
                if (array[mid - 1].getUser().hashCode() == value.hashCode()) {
                    return mid - 1;
                }
                if (array[low].getUser().hashCode() == value.hashCode()) {
                    return low;
                }
                return searchGetByKey(value, array, low, mid - 1);
            }
        } else if (value.hashCode() > array[mid].getUser().hashCode()) {
            if ((high - (mid + 1)) == 1 || high == (mid + 1)) {
                if (array[mid + 1].getUser().hashCode() == value.hashCode()) {
                    return mid + 1;
                }
                if (array[high].getUser().hashCode() == value.hashCode()) {
                    return high;
                }
                return searchGetByKey(value, array, mid + 1, high);
            }
        } else if (array[mid].hashCode() == value.hashCode()) {
            return mid;
        }
    return result;
    }
    /**.
     * Realisation iterator
     * @return iterator
     */
    @Override
    public Iterator<Entry> iterator() {
        Iterator<Entry> it = new Iterator<Entry>() {

            @Override
            public boolean hasNext() {
                return cursorIter < cursor;
            }

            @Override
            public Entry next() {
                if (hasNext()) {return map[cursorIter++];}
                else {throw new NoSuchElementException("Need add cell in this array");}
            }

            @Override
            public void remove() {
                map[cursorIter] = null;
                cursorIter--;
            }
        };
        return it;
    }
 }
