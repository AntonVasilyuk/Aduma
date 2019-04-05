package ru.job4j.start;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ru.job4j.models.Item;

/**.
* Chapter_002
* Create action
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Tracker {
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
	public Item add(Item item) {
		item.setId(String.valueOf(RN.nextInt()));
		this.items.add(item);
		return item;
	}

	/**.
	* method for update items
	* @param item item for update
	*/
	public void update(Item item) {
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
	public void delete(Item item) {
		items.remove(item);
	}

	/**.
	* method for find all items
	* @return result
	*/
	public List<Item> findAll() {
		return this.items;
	}

	/**.
	* method for find items
	* @param key name
	* @return array with dublicate name
	*/
	public List<Item> findByName(String key) {
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
	public Item findById(String id) {
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