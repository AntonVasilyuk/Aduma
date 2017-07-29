package ru.job4j;

import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Task 7.3.2.
 * Create User Storage
 *
 * @author Anton Vasilyuk on 27.07.2017.
 * @version 1.0.
 */
@ThreadSafe
public class UserStorage {

    /**.
     * @storage is structure for data about the users
     */
    private Map<Integer, User> storage;

    /**.
     * Constructor for this class
     */
    public UserStorage() {
        storage = new HashMap<>();
    }

    /**.
     * Method for add this user to the structure
     * @param user is user for adding
     */
    public void add(User user) {
        synchronized (this) {
            if (user != null && !storage.containsKey(user.getId())) {
                storage.put(user.getId(), user);
            } else {
                return;
            }
        }
    }

    /**.
     * Method for update data about the user
     * @param id user to update
     * @param amount is change amount the user
     */
    public void update(Integer id, int amount) {
        synchronized (this) {
            if (storage.get(id) != null && amount != 0 && storage.containsKey(id)) {
                if (!storage.containsKey(id)) {new NoSuchElementException("This id no registered");}
                int newAmount = storage.get(id).getAmount() + amount;
                User user = storage.get(id);
                user.setAmount(newAmount);
                storage.put(id, user);
            } else {
                return;
            }
        }
    }

    /**.
     * Method for delete user from this structure
     * @param id is id from search this user
     */
    public void delete(Integer id) {
        synchronized (this) {
            if (id != null && storage.containsKey(id)) {
                storage.remove(id);
            } else {
                return;
            }
        }
    }

    /**.
     * Method for transfer money from first user account to second user account
     * @param fromId the user who transfer
     * @param toId the user which trahsfer
     * @param amount is the amount of money
     */
    public void transfer(Integer fromId, Integer toId, int amount) {
        if (storage.get(fromId).getAmount() < amount) {
            System.out.printf("The user has insufficient funds");
            return;
        }

        if (!storage.containsKey(fromId) || !storage.containsKey(toId)) {
            new NoSuchElementException("This id no registered");
        }

        int amountForFromUser = 0 - amount;
        int amountForToUser = amount;

        update(fromId, amountForFromUser);
        update(toId,amountForToUser);

        if (storage.get(fromId).getAmount() == 0) {delete(fromId);}
    }

    /**.
     * The method for checking change in this the data structure
     * @return storage
     */
    public synchronized Map<Integer, User> getStorage() {return this.storage;}

}
