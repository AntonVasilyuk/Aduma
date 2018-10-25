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

    void add(String name, String login, String email);
    void update(int id, String name, String login, String email);
    void delete(int id);
    User findById(int id);
    List<User> findByAll();
    int getId();
    List<User> getStorage();
}
