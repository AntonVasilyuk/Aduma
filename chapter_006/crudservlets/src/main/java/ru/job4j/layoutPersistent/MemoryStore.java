package ru.job4j.layoutPersistent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**.
 * Task 9.2.1.
 * Class for storage info about users
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */

public class MemoryStore implements Store{

    /**.
     * It's logger for this class
     */
    private final Logger logger = LoggerFactory.getLogger(MemoryStore.class);

    /**.
     * Is id for users
     */
    private volatile int id;

    /**.
     * It's link for this singleton class
     */
    private final static MemoryStore memory = new MemoryStore();

    /**.
     * Is storage for this models
     */
    private final List<User> storage = new CopyOnWriteArrayList<User>();

    /**.
     * Private constructor for this class
     */
    private MemoryStore(){
        id = 1;
    }

    /**.
     * Method for getting singleton instance for this class
     * @return instance for this class
     */
    public static MemoryStore getInstance() {
        return memory;
    }

    /**.
     * Method for adding user
     * @param name is name of the user
     * @param login is login of the user
     * @param email is email of the user
     */
    @Override
    public void add(String name, String login, String email) {
        long time = Calendar.getInstance().getTimeInMillis();
        storage.add(new User(id++, name, login, email, time));
    }

    /**.
     * Method for updating user
     * @param id is id of the user
     * @param name is new name of the user
     * @param login is new login of the user
     * @param email is new email of the user
     */
    @Override
    public void update(int id, String name, String login, String email) {
        long timeupdating = Calendar.getInstance().getTimeInMillis();
        storage.set(storage.indexOf(findById(id)), new User(id, name, login, email, timeupdating));
    }

    /**.
     * Method for deleting user
     * @param id is id of the user for deleting
     */
    @Override
    public void delete(int id) {
        storage.remove(findById(id));
    }

    /**.
     * Method for searching user by id
     * @param id is id for searching
     * @return searched user
     */
    @Override
    public User findById(int id) {
        for (User user : storage) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /**.
     * Method for getting all users
     * @return list with all users
     */
    @Override
    public List findByAll() {
        return storage;
    }

    /**.
     * Getter for storage
     * @return storage
     */
    public List<User> getStorage() {
        return storage;
    }

    /**.
     * Getter for id of the user
     * @return id
     */
    public int getId() {
        return id;
    }
}
