package ru.job4j;

import ru.job4j.Entry;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by administrator on 08.01.2018.
 */
@XmlRootElement
public class Entries {

    /**.
     * Getter for list with Entry
     * @return list
     */
    @XmlElement(name = "entry")
    public List<Entry> getList() {
        return list;
    }

    /**.
     * Setter for list with Entry
     * @param list set list
     */
    public void setList(List<Entry> list) {
        this.list = list;
    }

    /**.
     * List for storage values entry
     */
    private List<Entry> list;

    /**.
     * Default Constructor
     */
    public Entries() {}

    /**.
     * Constructor
     * @param list is lust for storage values
     */
    public Entries(List<Entry> list) {
        super();
        this.list = list;
    }
}
