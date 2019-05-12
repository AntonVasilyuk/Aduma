package ru.job4j.persistent;

import java.util.List;

/**.
 * Task 9.2.1.
 * Is interface for manipulation storage in this programm
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */

public interface Store {
    /**.
     * Adding new user
     * @param user is user for action
     */
    void add(User user);

    /**.
     * Update user in storage
     * @param user is new user
     */
    void update(User user);

    /**.
     * Deleting user from storage
     * @param id is id for deleting
     */
    void delete(int id);

    /**.
     * Finding user by id
     * @param id is id for finding
     * @return user
     */
    User findById(int id);

    /**.
     * Find all users
     * @return list users
     */
    List<User> findByAll();

    /**.
     * Getter id
     * @return id
     */
    int getId();

    /**.
     * Check exist id
     * @param id is id for checking
     * @return result boolean
     */
    boolean existID(int id);

    /**.
     * Getter for storage
     * @return storage
     */
    List<User> getStorage();

    /**.
     * Getter for all countries
     * @return list countries
     */
    List<String> getCountries();

    /**.
     * Getter cities by countries
     * @param country is country
     * @return list cities
     */
    List<String> getCity(String country);

    /**.
     * Checker user
     * @param user is user for checking
     * @return result checking
     */
    boolean isCredentional(User user);

    /**.
     * Check on update
     * @param user user for checking
     * @return result
     */
    boolean needUpdate(User user);

    /**.
     * Check on exist
     * @param login is login for checking
     * @param password is password for checking
     * @return result
     */
    boolean isExisting(String login, String password);

    /**.
     * Checking user on role
     * @param login is login for checking
     * @return boolean result
     */
    boolean isAdmin(String login);
}
