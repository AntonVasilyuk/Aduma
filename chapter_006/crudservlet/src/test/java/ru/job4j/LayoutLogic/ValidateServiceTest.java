package ru.job4j.LayoutLogic;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.LayoutPersistent.MemoryStore;
import ru.job4j.LayoutPersistent.Store;
import ru.job4j.LayoutPersistent.User;

import java.util.List;

public class ValidateServiceTest {

    final ValidateService service = ValidateService.getInstance();

    final Store store = MemoryStore.getInstance();

    final String name = "testName";

    final String login = "testLogin";

    final String email = "testEmail";

    final User user = new User(store.getId(), name, login, email);

    final List<User> storage = store.getStorage();

    @Test
    public void whenNeedGetInstanceThisSingletonClass() {
        Assert.assertEquals(service, ValidateService.getInstance());

    }

    @Test
    public void whenNeedAddingOneUser() {
        boolean result = service.add(name, login, email);
        for (User user : storage) {
            if (user.equals(login, email)) {
                storage.remove(user);
            }
        }
        Assert.assertTrue(result);
    }

    @Test
    public void whenNeedAddingOneUserAndCheckingHis() {
        service.add(name, login, email);
        boolean result = service.add(name, login, email);
        for (User user : storage) {
            if (user.equals(login, email)) {
                storage.remove(user);
            }
        }
        Assert.assertFalse(result);
    }

    @Test
    public void whenNeedUpdatingListing() {
        int id = store.getId();
        String newName = "newUser";
        String newLogin = "newUser";
        String newEmail = "newEmail";
        service.add(name, login, email);
        service.update(id, newName, newLogin, newEmail);
        User newUser = store.findById(id);
        boolean result = false;
        if (newUser.equals(newLogin, newEmail)) {
            result = true;
        }
        for (User user : storage) {
            if (user.equals(newLogin, newEmail)) {
                storage.remove(user);
            }
        }
        Assert.assertTrue(result);
    }

    @Test
    public void whenNeedDeletingUser() {
        int id = store.getId();
        service.add(name, name, email);
        service.delete(id);

        boolean result = true;
        for (User tempUser : storage) {
            if (tempUser.equals(login, email)) {
                result = false;
            }
        }
        Assert.assertTrue(result);
    }

    @Test
    public void getListStorage() {
        List<User> list = service.getListStorage();
        Assert.assertNotNull(list);
    }
}