package ru.job4j.layoutLogic;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.layoutPersistent.MemoryStore;
import ru.job4j.layoutPersistent.Store;
import ru.job4j.layoutPersistent.User;

import java.util.List;

public class ValidateServiceTest {

    /**.
     * Is link for instance layout logic
     */
    final ValidateService service = ValidateService.getInstance();

    /**.
     * Is link for instance layout persistment
     */
    final Store store = MemoryStore.getInstance();

    /**.
     * Is test name
     */
    final String name = "testName";

    /**.
     * Is test login
     */
    final String login = "testLogin";

    /**.
     * Is test email
     */
    final String email = "testEmail";

    /**.
     * Is test instance user
     */
    final User user = new User(store.getId(), name, login, email);

    /**.
     * Is storage from layout persistment
     */
    final List<User> storage = store.getStorage();

    /**.
     * Testing method getInstance
     */
    @Test
    public void whenNeedGetInstanceThisSingletonClass() {
        Assert.assertEquals(service, ValidateService.getInstance());

    }

    /**.
     * Testing method add when need adding user
     */
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

    /**.
     * Testing method add when adding two equality users
     */
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

    /**.
     * Testing method update
     */
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

    /**.
     * Testing method delete
     */
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

    /**.
     * Testing getter for storage
     */
    @Test
    public void getListStorage() {
        List<User> list = service.getListStorage();
        Assert.assertNotNull(list);
    }
}