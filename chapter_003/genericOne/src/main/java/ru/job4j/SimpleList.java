package ru.job4j;

import java.util.NoSuchElementException;

/**
 * Task 5.2.1
 * Create generic
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class SimpleList<E> {

    private Object[] objects;
    private int index = 0;

    public SimpleList(int size) {
        this.objects = new Object[size];
    }

    public <K> K print(K value) {
        System.out.println(value);
        return value;
    }

    public void add(E value) {
        this.objects[index++] = value;
    }

    public E get (int position) {
        return (E) this.objects[position];
    }

    public void update(int position, E value) {
        if (value != null) {
            this.objects[position] = value;
        } else {throw new NullPointerException("this value is null");}
    }

    public void delete(int position) {
        this.objects[position] = null;
    }
}
