package ru.job4j;

/**.
 * Task 5.2.2
 * Create model for Role
 * @author  Anton Vasilyuk on 10.06.2017.
 * @version 1.0
 * @param <T> element must be extending Base
 */

public class Role<T extends Base> extends Base {

    /**.
     * Constructor for Role
     * @param id is id Role
     */
    public Role(String id) {
        super(id);
    }
}
