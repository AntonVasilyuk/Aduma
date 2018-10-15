package ru.job4j.layoutPersistent;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DBStoreTest {

    /**.
     * Is link to example class DBStore
     */
    private final DBStore dbStore = DBStore.getInstance();

    /**.
     * It's name value for testing
     */
    private final String name = "testName";

    /**.
     * It's login value for testing
     */
    private final String login = "testLogin";

    /**.
     * It's email value for testing
     */
    private final String email = "testEmail";

    /**.
     * It's testing class on singleton
     */
    @Test
    public void whenNeedGettingExampleClassBDStrore() {
        Assert.assertTrue(DBStore.getInstance() instanceof DBStore);
    }

    /**.
     * It's testing method add
     */
    @Test
    public void whenNeedAddingOneUserToDBStore() {
        List<User> list = dbStore.getStorage();
        int firstSize = dbStore.getStorage().size();
        dbStore.add(name, login, email);
        int secondSize = dbStore.getStorage().size();
        dbStore.delete(dbStore.getId() - 1);
        int result = secondSize - firstSize;
        System.out.println(result);
        Assert.assertTrue(result == 1);
    }

    /**.
     * It's testing method update
     */
    @Test
    public void whenNeedUpdatingUser() {
        String newName = "newName";
        String newLogin = "newLogin";
        String newEmail = "newEmail";
        int id = dbStore.getId();
        dbStore.add(name, login, email);
        dbStore.update(id, newName, newLogin, newEmail);
        User user = dbStore.findById(id);
        dbStore.delete(id);
        Assert.assertTrue(user.getName().equals(newName) && user.getLogin().equals(newLogin) &&
                user.getEmail().equals(newEmail));
    }

    /**.
     * It's testing method delete
     */
    @Test
    public void whenNeedDeletingUser() {
        dbStore.add(name, login, email);
        dbStore.delete(dbStore.getId()-1);
        User user = dbStore.findById(dbStore.getId()-1);
        Assert.assertTrue(user == null);
    }

    /**.
     * It's testing method findByAll
     */
    @Test
    public void whenNeedGetListAllUsers() {
        int oldSizeDB = dbStore.getStorage().size();
        dbStore.add(name, login, email);
        int sizeDB = dbStore.getStorage().size();
        dbStore.delete(dbStore.getId()-1);
        int result = sizeDB - oldSizeDB;
        Assert.assertTrue(result == 1);
    }

    /**.
     * It's testing method findById
     */
    @Test
    public void whenNeedFindUserById() {
        int currentId = dbStore.getId();
        dbStore.add(name, login, email);
        boolean result = true;
        User user = dbStore.findById(currentId);
        if (!user.getName().equals(name) || !user.getLogin().equals(login) || !user.getEmail().equals(email)) {
            result = false;
        }
        dbStore.delete(currentId);
        Assert.assertTrue(result);
    }
}