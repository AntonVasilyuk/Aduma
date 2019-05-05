package ru.job4j;

import java.util.NoSuchElementException;

/**.
 * Task 5.2.1
 * Create generic
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 * @param <E> generic type for this class
 */
public class SimpleList<E> {

    /**.
     * It's array for objects
     */
    private java.lang.Object[] objects;

    /**.
     * It's index for position
     */
    private int index = 0;

    /**.
     * It's constructor
     * @param size it's size for array
     */
    public SimpleList(int size) {
        this.objects = new java.lang.Object[size];
    }

    /**.
     * Method for adding value to array
     * @param value it's value for adding
     */
    public void add(E value) {
        if (value == null) {
            throw new NullPointerException("Element is null");
        }
        if (validate()) {
            this.objects[index++] = value;
        } else {
            throw new ArrayIndexOutOfBoundsException("Too far");
        }
    }

    /**.
     * Getting the value at this position
     * @param position it's position for getting
     * @return value
     */
    public E get(int position) {
        return (E) this.objects[position];
    }

    /**.
     * Update element in array
     * @param position position odl element
     * @param value value for updating
     */
    public void update(int position, E value) {
        if (value != null) {
            this.objects[position] = value;
        } else {
            throw new NullPointerException("this value is null");
        }
    }

    /**.
     * Deleting element from array at this position
     * @param position it's position for deleting
     */
    public void delete(int position) {

        if (this.objects[position] != null) {
            this.objects[position] = null;
        } else {
            throw new NoSuchElementException("In this no element");
        }
        index--;
    }

    /**.
     * Check index in array bounds
     * @return result
     */
    public boolean validate() {
        return this.objects.length > index;
    }
}