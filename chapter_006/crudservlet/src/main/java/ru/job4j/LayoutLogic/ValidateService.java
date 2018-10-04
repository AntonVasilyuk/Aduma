package ru.job4j.LayoutLogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.LayoutPersistent.MemoryStore;
import ru.job4j.LayoutPersistent.Store;
import ru.job4j.LayoutPersistent.User;

import java.util.List;

/**.
 * Task 9.2.1.
 * Class for realisation logic for this web api
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */

public class ValidateService {

    /**.
     * Is logger for this class
     */
    private final Logger logger = LoggerFactory.getLogger(ValidateService.class);

    /**.
     * Instance for singleton ValidateService class
     */
    private final static ValidateService link = new ValidateService();

    /**.
     * Link for instance Store interface
     */
    private final Store store = MemoryStore.getInstance();

    /**.
     * Constructor
     */
    private ValidateService() {
    }

    /**.
     * Method for getting instance of this class
     * @return instance
     */
    public static ValidateService getInstance() {
        return link;
    }

    /**.
     * Method for adding new user
     * @param name is name new user
     * @param login is login new user
     * @param email is email new user
     * @return result operation
     */
    public boolean add(String name, String login, String email) {
        if (!checkOnDublicate(login, email)) {
            store.add(name, login, email);
            return true;
        }
        return false;
    }

    /**.
     * Method for update user in storage
     * @param id is id user
     * @param name is name user
     * @param login is login user
     * @param email is email user
     * @return result operation
     */
    public boolean update(int id, String name, String login, String email) {
        int index = searchUser(id);
        if (index == -1) {
            return false;
        }
        store.update(id, name, login, email);
        return true;
    }

    /**.
     * Method for delete user from storage
     * @param id is id user for deleting
     * @return result operation
     */
    public boolean delete(int id) {
        int index = searchUser(id);
        if (index != -1) {
            store.delete(id);
            return true;
        } else {
            return false;
        }
    }

    /**.
     * Method for check adding user on dublicate in the storage
     * @param login is login of the user
     * @param email is email of the user
     * @return result checking
     */
    private boolean checkOnDublicate(String login, String email) {
        for (User temp : store.findByAll()) {
            if (temp.equals(login, email)) {
                return true;
            }
        }
        return false;
    }

    /**.
     * Method for searching user in the storage
     * @param id is id user
     * @return position user in the storage
     */
    private int searchUser(int id) {
        List<User> allUsers = store.findByAll();
        for (User user : allUsers) {
            if (user.getId() == id) {
                return allUsers.indexOf(user);
            }
        }
        return -1;
    }

    /**.
     * Getter for storage
     * @return storage
     */
    public List<User> getListStorage() {
        return store.findByAll();
    }

    /**.
     * Getter for link to the store
     * @return link to the store
     */
    public Store getStore() {
        return store;
    }
}
