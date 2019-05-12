package ru.job4j.tracker.start;

import ru.job4j.tracker.storage.JDBCStorage;
import ru.job4j.tracker.models.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**.
 * Task 8.4.2.
 * Update tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */


public class Tracker {

	/**.
	 * It's link to storage
	 */
	private final JDBCStorage jdbcStorage = new JDBCStorage();

	/**.
	* @items Array items
	*/
	private List<Item> items = new ArrayList<>();

	/**.
	* @RN git id
	*/
	private static final Random RN = new Random();

	/**.
	* method for add items
	* @param item item object
	* @return result
	 * @throws SQLException may be exception
	*/
	public Item add(Item item) throws SQLException {
		jdbcStorage.add(item);
		return item;
	}

	/**.
	* method for update items
	* @param item item for update
	 * @throws SQLException may be exception
	*/
	public void update(Item item) throws SQLException {
		items = jdbcStorage.getAll();
		for (Item a : items) {
			if (item != null && item.getId().equals(a.getId())) {
				items.set(items.indexOf(a), item);
				break;
			}
		}
	}

	/**.
	* method for delete items
	* @param item item for delete
	 * @throws SQLException may be exception
	*/
	public void delete(Item item) throws SQLException {
		jdbcStorage.delete(item.getId());
	}

	/**.
	* method for find all items
	* @return result
	 * @throws SQLException may be exception
	*/
	public List<Item> findAll() throws SQLException {
		items = jdbcStorage.getAll();
		return this.items;
	}

	/**.
	* method for find items
	* @param key name
	* @return array with dublicate name
	 * @throws SQLException may be exception
	*/
	public List<Item> findByName(String key) throws SQLException {
		findAll();
		List<Item> nameList = new ArrayList<>();
		for (Item a : items) {
			if (a != null && a.getName().equals(key)) {
				nameList.add(a);
			}
		}
		return nameList;
	}

	/**.
	* method for show all items
	* @param id id for item
	* @return item
	 * @throws SQLException may be exception
	*/
	public Item findById(String id) throws SQLException {
		findAll();
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
	return result;
	}
}