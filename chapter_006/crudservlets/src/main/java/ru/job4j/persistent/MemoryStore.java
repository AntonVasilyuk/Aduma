package ru.job4j.persistent;

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

public class MemoryStore implements Store {

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
    private static final MemoryStore MEMORY = new MemoryStore();

    /**.
     * Is storage for this models
     */
    private final List<User> storage = new CopyOnWriteArrayList<User>();

    /**.
     * Private constructor for this class
     */
    private MemoryStore() {
        id = 1;
    }

    /**.
     * Method for getting singleton instance for this class
     * @return instance for this class
     */
    public static MemoryStore getInstance() {
        return MEMORY;
    }

    /**.
     * Method for adding user
     * @param user is new user
     */
    @Override
    public void add(User user) {
        long time = Calendar.getInstance().getTimeInMillis();
        storage.add(new User(id++, user.getName(), user.getLogin(), user.getPassword(), user.getPassword(), time,
                user.getRole(), user.getCountry(), user.getCity()));
    }

    /**.
     * Method for updating user
     * @param user is new user
     */
    @Override
    public void update(User user) {
        long timeupdating = Calendar.getInstance().getTimeInMillis();
        storage.set(storage.indexOf(findById(user.getId())), user);
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

    @Override
    public List<String> getCountries() {
        //TODO
        return null;
    }

    @Override
    public List<String> getCity(String country) {
        //TODO
        return null;
    }

    /**.
     * Getter for id of the user
     * @return id
     */
    public int getId() {
        return id;
    }

    /**.
     *
     * @param user
     * @return
     */
    @Override
    public boolean isCredentional(User user) {
        return false;
    }

    /**.
     *
     * @param login
     * @param password
     * @return
     */
    @Override
    public boolean isExisting(String login, String password) {
        //TODO
        return false;
    }

    /**.
     *
     * @param login
     * @return
     */
    @Override
    public boolean isAdmin(String login) {
        //TODO
        return false;
    }

    @Override
    public boolean existID(int id) {
        //TODO
        return false;
    }

    @Override
    public boolean needUpdate(User user) {
        //TODO
        return false;
    }
}
