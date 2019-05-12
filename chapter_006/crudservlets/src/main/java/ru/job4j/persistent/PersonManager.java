package ru.job4j.persistent;

import java.util.concurrent.CopyOnWriteArrayList;

/**.
 * Task 9.2.1.
 * Person MANAGER
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class PersonManager {

    /**.
     * It's storage for perons
     */
    private final CopyOnWriteArrayList<Person> storage = new CopyOnWriteArrayList<>();

    /**.
     * It's link for this class
     */
    private static final PersonManager MANAGER = new PersonManager();

    /**.
     * It's constructor for this class
     */
    private PersonManager() {
    }

    /**.
     * It's method for getting link to example for this class
     * @return instance
     */
    public static PersonManager getInstance() {
        return MANAGER;
    }

    /**.
     * Method for adding new person
     * @param person person for adding
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
