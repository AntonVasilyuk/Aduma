package ru.job4j;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by administrator on 08.01.2018.
 */
public class Entry {

    /**.
     * Default Constructor
     */
    public Entry() {
    }

    /**.
     * Constructor
     * @param i is index
     */
    public Entry(int i) {
        this.field = i;
    }

    /**.
     * Getter for field
     * @return field
     */
    @XmlElement
    public int getField() {
        return field;
    }

    /**.
     * Setter for field
     * @param field is field
     */
    public void setField(int field) {
        this.field = field;
    }

    /**.
     * Is main value
     */
    private int field;

}
