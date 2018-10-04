package ru.job4j.LayoutPersistent;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MemoryStoreTest {

    final String testName = "testName";

    final String testLogin = "testLogin";

    final String testEmail = "testEmail@yandex.ru";

    final MemoryStore store = MemoryStore.getInstance();

    final User user = new User(store.getId(), testName, testLogin, testEmail);

    final List<User> database = store.getStorage();

    @Test
    public void whenCheckingOnSingleton() {
        MemoryStore test = MemoryStore.getInstance();
        Assert.assertEquals(store, test);
    }

    @Test
    public void whenNeedAddingNewUserToStore() {
        int oldSize = database.size();
        store.add(testName, testLogin, testEmail);
        int newSize = database.size();
        Assert.assertTrue((newSize - oldSize) == 1);
    }

    @Test
    public void whenNeedUpdateWritesInTheStorage() {
        String name = "newName";
        String email = "newEmail";
        int idUser = store.getId();
        database.add(user);
        store.update(idUser, name, name, email);
        User newUser = database.get(idUser);
        database.remove(newUser);
        Assert.assertTrue(newUser.equals(name, email));
    }

    @Test
    public void whenNeedRemowingUser() {
        database.add(user);
        store.delete(user.getId());
        Assert.assertFalse(database.contains(user));
    }

    @Test
    public void whenNeedSearchUserById() {
        database.add(user);
        User ourUser = store.findById(user.getId());
        Assert.assertTrue(user.equals(ourUser));
    }

    @Test
    public void findByAll() {
        List<User> newList = store.findByAll();
        Assert.assertTrue(database.containsAll(newList));
    }
}