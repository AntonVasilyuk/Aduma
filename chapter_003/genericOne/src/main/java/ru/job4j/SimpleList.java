package ru.job4j;

import java.lang.reflect.ParameterizedType;
import java.util.NoSuchElementException;

/**
 * Task 5.2.1
 * Create generic
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class SimpleList<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleList(int size) {
        this.objects = new Object[size];
     }

    public void add(T value) {
        if (value == null) {throw new NullPointerException("Element is null");}
        if (validate()) {
            this.objects[index++] = value;
        } else {
            throw new ArrayIndexOutOfBoundsException("Too far");
        }
    }

    public T get (int position) {
        return (T) this.objects[position];
    }

    public void update(int position, T value) {
        if (value != null) {
            this.objects[position] = value;
        } else {throw new NullPointerException("this value is null");}
    }

    public void delete(int position) {

        if (this.objects[position] != null) {
            this.objects[position] = null;
        } else {
            throw new NoSuchElementException("In this no element");
        }
        index--;
    }

    public boolean validate() {
        return this.objects.length > index;
    }
}