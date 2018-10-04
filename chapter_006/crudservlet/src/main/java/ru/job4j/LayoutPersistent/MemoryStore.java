package ru.job4j.LayoutPersistent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private int id;

    /**.
     * It's link for this singleton class
     */
    private final static MemoryStore memory = new MemoryStore();

    /**.
     * Is storage for this models
     */
    private final List<User> storage = new CopyOnWriteArrayList<User>();

    private MemoryStore(){
        id = 1;
    }

    public static MemoryStore getInstance() {
        return memory;
    }

    @Override
    public void add(String name, String login, String email) {
        storage.add(new User(id++, name, login, email));
    }

    @Override
    public void update(int id, String name, String login, String email) {
        storage.set(storage.indexOf(findById(id)), new User(id, name, login, email));
    }

    @Override
    public void delete(int id) {
        storage.remove(findById(id));
    }

    @Override
    public User findById(int id) {
        for (User user : storage) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List findByAll() {
        return storage;
    }

    public List<User> getStorage() {
        return storage;
    }

    public int getId() {
        return id;
    }
}
