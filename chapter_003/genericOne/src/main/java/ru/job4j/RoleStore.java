package ru.job4j;

/**
 * Task 5.2.2
 * Create container which will hold only Role
 * @author  Anton Vasilyuk on 10.06.2017.
 * @version 1.0
 */
public class RoleStore<T extends Base> extends BaseStore<T> {

    public RoleStore() {
        super();
    }
}
