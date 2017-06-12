package ru.job4j;

/**
 * Task 5.2.2. Create servise for User and Role
 * Interface for
 * Created by ANTON on 10.06.2017.
 */
public interface  Store<T extends Base> {

    void add(T t);

    void update(String id, T t);

    void remove(int position);
}
