package ru.job4j.tracker;

import ru.job4j.models.Item;

import java.util.List;

/**.
 * Chapter_002
 * Interface for tracker
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public interface ITracker {

    /**.
     * Adding new item
     * @param item is item for adding
     * @return result
     */
    Item add(Item item);

    /**.
     * Replace item in storage
     * @param id is id for replace
     * @param item is item for raplace
     */
    void replace(String id, Item item);

    /**.
     * Delete item from storage
     * @param id is id for deleting
     */
    void delete(String id);

    /**.
     * Getter all items from storage
     * @return all items
     */
    List<Item> findAll();

    /**.
     * Search item by name
     * @param key is key for search
     * @return item
     */
    List<Item> findByName(String key);

    /**.
     * Find item by id
     * @param id is id for searching
     * @return item
     */
    Item findById(String id);
}
