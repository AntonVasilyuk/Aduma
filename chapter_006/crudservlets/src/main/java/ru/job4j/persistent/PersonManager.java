package ru.job4j.persistent;

import java.util.concurrent.CopyOnWriteArrayList;

public class PersonManager {

    /**.
     * It's storage for perons
     */
    private final CopyOnWriteArrayList<Person> storage = new CopyOnWriteArrayList<>();

    /**.
     * It's link for this class
     */
    private static final PersonManager manager = new PersonManager();

    /**.
     * It's constructor for this class
     */
    private PersonManager() {
    }

    /**.
     * It's method for getting link to example for this class
     * @return
     */
    public static PersonManager getInstance() {
        return manager;
    }

    /**.
     * Method for adding new person
     * @param person
     */
    public void add(Person person) {
        storage.add(person);
    }

    /**.
     * Getter for this storage
     * @return storage
     */
    public CopyOnWriteArrayList<Person> getStorage() {
        return this.storage;
    }
}
