package ru.job4j;

/**
 * Task 5.5.2.
 * Create my map
 *
 * Created by ANTON VASILYUK on 21.06.2017.
 * @version 1.0
 */

public class MyMap<U, E> {

    /**.
     * @size is size array for the map
     */
    public int size;

    /**.
     * @cursor is position cursor
     */
    public int cursor;

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
    public E put(U key, E value) {
        E tempValue = null;
        if (key == null) {throw new NullPointerException("Key is null");}
        if (value == null) {throw new NullPointerException("Element is null");}
        if (cursor == 0) {
            map[0] = new Entry(key, value);
            cursor++;
        } else {
            if(cursor < size) {
                for (int i = 0; i < cursor; i++) {
                    if (map[i].getUser().equals(key)) {
                        tempValue = (E) map[i];
                        map[i].setObject(value);
                    } else {map[cursor++] = new Entry(key, value);}
                }
            } else {
                int newSize = size * 2;
                Entry[] newMap = new Entry[newSize];
                System.arraycopy(map, 0, newMap, 0, size);
                this.map = newMap;
                this.size = newSize;

                for (int i = 0; i < cursor; i++) {
                    if (map[i].getUser().equals(key)) {
                        tempValue = (E) map[i];
                        map[i].setObject(value);
                    } else {map[cursor++] = new Entry(key, value);}
                }
            }
        }
        return tempValue;
    }

    /**.
     * Method for return element by key
     * @param key is key
     * @return element
     */
    public E get(U key) {
        if (key == null) {throw  new NullPointerException("Key is null");}
        E result = null;
        for (int i = 0; i < cursor; i++) {
            if (map[i].getUser().equals(key)) {result = (E) map[i].getObject();}
        }
        return result;
    }

    /**.
     * Method for printing map
     */
    public void print() {
        System.out.print("This map have: ");
        for (int i = 0; i < cursor; i++) {
            System.out.print(map[i].getObject());
        }
    }
 }
