package ru.job4j;

/**.
 * Task 5.2.2
 * Create model for User
 * @author  Anton Vasilyuk on 10.06.2017.
 * @version 1.0
 * @param <T> is extend by Base
 */
public class User<T extends Base> extends Base {

    /**.
     * Conteiner for model User
     * @param id is id user
     */
    public User(String id) {
        super(id);
    }
}
