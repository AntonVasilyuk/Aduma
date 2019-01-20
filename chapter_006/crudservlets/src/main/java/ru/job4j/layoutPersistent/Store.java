package ru.job4j.layoutPersistent;

import java.util.List;

/**.
 * Task 9.2.1.
 * Is interface for manipulation storage in this programm
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */

public interface Store{
    void add(User user);
    void update(User user);
    void delete(int id);
    User findById(int id);
    List<User> findByAll();
    int getId();
    boolean existID(int id);
    List<User> getStorage();
    List<String> getCountries();
    List<String> getCity(String country);
    boolean isCredentional(User user);
    boolean isExisting(String login, String password);
    boolean isAdmin(String login);
}
