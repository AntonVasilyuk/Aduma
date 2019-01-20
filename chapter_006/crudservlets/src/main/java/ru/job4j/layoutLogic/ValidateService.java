package ru.job4j.layoutLogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.layoutPersistent.DBStore;
import ru.job4j.layoutPersistent.Store;
import ru.job4j.layoutPersistent.User;

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
    private final Store store = DBStore.getInstance();

    /**.
     * Hidden constructor
     */
    private ValidateService() {
    }

    /**.
     * Method for getting instance single example for this class
     * @return instance
     */
    public static ValidateService getInstance() {
        return link;
    }

    /**.
     * Method for adding new user
     * @param user is new user
     * @return result operation
     */
    public boolean add(User user) {
        if (!isCredentional(user)) {
            store.add(user);
            return true;
        }
        return false;
    }

    /**.
     * Method for update user in storage
     * @param user is new user
     * @return result operation
     */
    public boolean update(User user) {
        if (store.needUpdate(user)) {
            store.update(user);
        }
        return false;
    }

    /**.
     * Method for delete user from storage
     * @param id is id user for deleting
     * @return result operation
     */
    public boolean delete(int id) {
        if (store.existID(id)) {
            store.delete(id);
            return true;
        } else {
            return false;
        }
    }

    /**.
     * Getter for storage
     * @return storage
     */
    public synchronized List<User> getListStorage() {
        return store.findByAll();
    }

    /**.
     * Method for checking authorisation
     * @param user for checking
     * @return result
     */
    public boolean isCredentional(User user) {
        if (store.isCredentional(user)) {
            return true;
        }
        return false;
    }

    /**.
     * Method for checking role the user
     * @param login
     * @return true if user is admin
     */
    public boolean isAdmin(String login) {
        return store.isAdmin(login);
    }

    /**.
     * Getter for list of the countries
     * @return list countries
     */
    public List<String> getCountries() {
        return store.getCountries();
    }

    /**.
     * Getter for list of the cies for this country
     * @param country
     * @return list of the cities
     */
    public List<String> getCity(String country) {
        return store.getCity(country);
    }

    /**.
     * Method for checking user for existing
     * @param login for user
     * @param password for user
     * @return true if exist
     */
    public boolean isExisting(String login, String password) {
        return (store.isExisting(login, password));
    }
}
