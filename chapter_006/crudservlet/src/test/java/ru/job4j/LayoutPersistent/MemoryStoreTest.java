package ru.job4j.LayoutPersistent;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MemoryStoreTest {

    /**.
     * It's test name
     */
    final String testName = "testName";

    /**.
     * It's test login
     */
    final String testLogin = "testLogin";

    /**.
     * It's test email
     */
    final String testEmail = "testEmail@yandex.ru";

    /**.
     * It's instance layout persistment
     */
    final MemoryStore store = MemoryStore.getInstance();

    /**.
     * It's test user
     */
    final User user = new User(store.getId(), testName, testLogin, testEmail);

    /**.
     * It's storage this model
     */
    final List<User> database = store.getStorage();

    /**.
     * Testing getter instance
     */
    @Test
    public void whenCheckingOnSingleton() {
        MemoryStore test = MemoryStore.getInstance();
        Assert.assertEquals(store, test);
    }

    /**.
     * Testing method add
     */
    @Test
    public void whenNeedAddingNewUserToStore() {
        int oldSize = database.size();
        store.add(testName, testLogin, testEmail);
        int newSize = database.size();
        Assert.assertTrue((newSize - oldSize) == 1);
    }

    /**.
     * Testing method update
     */
    @Test
    public void whenNeedUpdateWritesInTheStorage() {
        String name = "newName";
        String login = "newLogin";
        String email = "newEmail";
        database.add(user);
        store.update(user.getId(), name, login, email);
        boolean result = false;
        for (User user : database) {
            if (user.equals(login, email)) {
                result = true;
                database.remove(user);
            }
        }
        Assert.assertTrue(result);
    }

    /**.
     * Testing method remowe
     */
    @Test
    public void whenNeedRemowingUser() {
        database.add(user);
        store.delete(user.getId());
        Assert.assertFalse(database.contains(user));
    }

    /**.
     * Testing method findById
     */
    @Test
    public void whenNeedSearchUserById() {
        database.add(user);
        User ourUser = store.findById(user.getId());
        Assert.assertTrue(user.equals(ourUser));
    }

    /**.
     * Testing method findByAll
     */
    @Test
    public void whenNeedGettingAllUsers() {
        List<User> newList = store.findByAll();
        Assert.assertTrue(database.containsAll(newList));
    }
}