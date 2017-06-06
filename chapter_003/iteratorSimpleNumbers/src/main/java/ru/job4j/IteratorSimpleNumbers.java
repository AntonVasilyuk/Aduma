package ru.job4j;

import java.util.*;
/**
 * Task 4.1.3
 * Create iterator for simple numbers
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class IteratorSimpleNumbers implements Iterator{

    /**.
     * @index is index array
     */
    private int index = 0;

    /**.
     * @value is array numbers
     */
    private int[] value;

    /**.
     * Constructor for class Iterator SimpleNumbers
     * @param value is array numbers
     */
    public IteratorSimpleNumbers(int[] value) {
        this.value = value;
    }

    /**.
     * Method for check next member array
     * @return is there a next element
     */
    @Override
    public boolean hasNext() {
        boolean result = true;
        if (this.value == null) {throw new NoSuchElementException("In this array not element");}
        if (this.value.length < index) {result = false;}
        int num = 0;
        for (int i = 0; i < value.length; i++) {
            for(int j = 2; j < value.length; j++) {
                if((value[i] % j) == 0) {num++;}
            }
        }
        if (num > 0) {result = false;}
        return result;
    }

    /**.
     * Method for output next simple number
     * @return simple number
     */
    @Override
    public Object next() {
        int num = 0;
        while (hasNext()) {
            for (int i = 2; i < this.value[index]; i++) {
                if((this.value[index] % i) == 0) {num++;}
            }
            if(num == 0){break;}
            index++;
            num = 0;
        }
    return this.value[index++];
    }
}