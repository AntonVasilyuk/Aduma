package ru.job4j.layoutPersistent;

import java.util.concurrent.CopyOnWriteArrayList;

public class PersonManager {

    private CopyOnWriteArrayList<Person> list = new CopyOnWriteArrayList<>();

    private static PersonManager manager = new PersonManager();

    private PersonManager() {
    }

    public static PersonManager getInstance() {
        return manager;
    }

    public boolean add(Person person) {
        for (Person checkPerson : list) {
            if (checkPerson.equals(person)) {
                return false;
            }
        }
        list.add(person);
        return true;
    }

    public boolean delete(int id) {
        boolean result = false;
        for (Person checkPerson : list) {
            if (checkPerson.checkID(id)) {
                list.remove(checkPerson);
                return true;
            }
        }
        return result;
    }
}
