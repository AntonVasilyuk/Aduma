package ru.job4j;

import java.util.Random;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Tracker {
	/**.
	* @items Array items
	*/
	private Item[] items = new Item[10];

	/**.
	* @position for array
	*/
	private int position = 0;

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
		this.items[position++] = item;
		return item;
	}

	/**.
	* method for update items
	* @param item item for update
	*/
	public void update(Item item) {
		for (int index = 0; index != position; index++) {
			if (item != null && item.getId().equals(items[index].getId())) {
				items[index] = item;
				break;
			}
		}
	}

	/**.
	* method for delete items
	* @param item item for delete
	*/
	public void delete(Item item) {
		Item[] result = new Item[this.position];
		for (int index = 0, i = 0; index != this.position; index++, i++) {
			if (items[index].equals(item)) {
				index++;
			}
			result[i] = items[index];
			this.items = result;
		}
	}

	/**.
	* method for find all items
	* @return result
	*/
	public Item[] findAll() {
		Item[] result = new Item[this.position];
		for (int index = 0; index != this.position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}

	/**.
	* method for find items
	* @param key name
	* @return array with dublicate name
	*/
	public Item[] findByName(String key) {
		int i = 0;
		int num = 0;
		for (int index = 0; index != position; index++) {
			if (items[index] != null && items[index].getName().equals(key)) {
				num++;
			}
		}
		Item[] result = new Item[num];
		for (int index = 0; index != position; index++) {
			if (items[index] != null && items[index].getName().equals(key)) {
				result[i++] = items[index];
			}
		}
		return result;
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