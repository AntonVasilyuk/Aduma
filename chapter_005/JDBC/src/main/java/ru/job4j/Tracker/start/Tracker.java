package ru.job4j.Tracker.start;

import ru.job4j.Tracker.JDBCStorage.JDBCStorage;
import ru.job4j.Tracker.models.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Task 8.4.2.
 * Update Tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */


public class Tracker {

	private final JDBCStorage storage = new JDBCStorage();
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
	*/
	public Item add(Item item) throws SQLException {
		storage.add(item);
		return item;
	}

	/**.
	* method for update items
	* @param item item for update
	*/
	public void update(Item item) throws SQLException {
		items = storage.getAll();
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
	*/
	public void delete(Item item) throws SQLException {
		storage.delete(item.getId());
	}

	/**.
	* method for find all items
	* @return result
	*/
	public List<Item> findAll() throws SQLException {
		items = storage.getAll();
		return this.items;
	}

	/**.
	* method for find items
	* @param key name
	* @return array with dublicate name
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