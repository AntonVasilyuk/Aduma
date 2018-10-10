package ru.job4j.layoutPersistent;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DBStoreTest {

    private final DBStore dbStore = DBStore.getInstance();
    private final String name = "testName";
    private final String login = "testLogin";
    private final String email = "testEmail";

    @Test
    public void whenNeedGettingExampleClassBDStrore() {
        Assert.assertTrue(DBStore.getInstance() instanceof DBStore);
    }

    @Test
    public void whenNeedAddingOneUserToDBStore() {
        List<User> list = dbStore.getStorage();
        int firstSize = list.size();
        dbStore.add(name, login, email);
        int secondSize = list.size();
        dbStore.delete(dbStore.getId());
        Assert.assertTrue((secondSize - firstSize) == 1);
    }

    @Test
    public void whenNeedUpdatingUser() {
        String newName = "newName";
        String newLogin = "newLogin";
        String newEmail = "newEmail";
        dbStore.add(name, login, email);
        int id = dbStore.getId();
        dbStore.update(id, newName, newLogin, newEmail);
        User user = dbStore.findById(id);
        dbStore.delete(id);
        Assert.assertTrue(user.getName().equals(newName) && user.getLogin().equals(newLogin) &&
                user.getEmail().equals(newEmail));
    }

    @Test
    public void whenNeedDeletingUser() {
        List<User> list = dbStore.getStorage();
        dbStore.add(name, login, email);
        int firstSize = list.size();
        dbStore.delete(dbStore.getId());
        int secondSize = list.size();
        Assert.assertTrue((firstSize - secondSize) == 1);
    }

    @Test
    public void findByAll() {
    }

    @Test
    public void getStorage() {
    }

    @Test
    public void findById() {
    }
}