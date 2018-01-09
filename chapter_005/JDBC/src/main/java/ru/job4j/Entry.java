package ru.job4j;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by administrator on 08.01.2018.
 */
public class Entry {

    /**.
     * Default Constructor
     */
    public Entry() {}

    /**.
     * Constructor
     * @param i
     */
    public Entry(int i) {
        this.field = i;
    }

    /**.
     * Getter for field
     * @return
     */
    @XmlElement
    public int getField() {
        return field;
    }

    /**.
     * Setter for field
     * @param field
     */
    public void setField(int field) {
        this.field = field;
    }

    /**.
     * Is main value
     */
    private int field;

}
