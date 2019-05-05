package ru.job4j;

/**.
 * Task 5.2.2. Create servise for User and Role
 * Interface for
 * Created by ANTON on 10.06.2017.
 * @param <T> must be extending by Base
 */
public interface  Store<T extends Base> {

    /**.
     * Adding element
     * @param t is element
     */
    void add(T t);

    /**.
     * Update element
     * @param id is id for update
     * @param t is element
     */
    void update(String id, T t);

    /**.
     * Removing element
     * @param id is id elements for remove
     */
    void remove(String id);
}