package ru.job4j;

/**
 * Task 5.2.2
 * This is basis for outher models
 * @author  Anton Vasilyuk on 10.06.2017.
 * @version 1.0
 */
public abstract class  Base {

    /**.
     * id for other models
     */
    private String id;

    /**.
     * Constructor basis
     * @param id is id for other models
     */
    public Base(String id) {
        this.id = id;
    }

    /**.
     * Method show id for this model
     * @return
     */
    public String getId() {
        return this.id;
    }

    /**.
     * Method instal id for this model
     * @param id is new id
     */
    public void setId(String id) {
        this.id = id;
    }
}
