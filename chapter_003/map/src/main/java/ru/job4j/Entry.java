package ru.job4j;

/**
 * Task 5.5.2.
 * Create create item for my map
 *
 * Created by ANTON VASILYUK on 21.06.2017.
 * @version 1.0
 * @param <U> it's param for generic
 * @param <E> it's param for generic
 */
public class Entry<U, E> {

    /**.
     * Link to the User
     */
    private U user;

    /**.
     * Link to the object
     */
    private E object;

    /**.
     * Constructor for Entry
     * @param user is key
     * @param object is element
     */
    public Entry(U user, E object) {
        this.user = user;
        this.object = object;
    }

    /**.
     * Getter for this user
     * @return user
     */
    public U getUser() {
        return this.user;
    }

    /**.
     * Setter for this user
     * @param user this user
     */
    public void setUser(U user) {
        this.user = user;
    }

    /**.
     * Getter for this object
     * @return this object
     */
    public E getObject() {
        return this.object;
    }

    /**.
     * Setter for this object
     * @param object is new object
     */
    public void setObject(E object) {
        this.object = object;
    }
}
