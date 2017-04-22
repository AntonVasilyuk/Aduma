package ru.job4j;

import java.util.Random;
import java.util.Arrays;

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
			if (items[index].getId().equals(item.getId())) {
				items[index] = null;
			}
		}
	}

	/**.
	* method for find all items
	* @return result
	*/
	public Item[] findAll() {
		int num = 0;
		Item[] result = new Item[this.position];
		for (int index = 0, j = 0; index != this.position; index++, j++) {
			if (this.items[index] != null) {
				result[j] = this.items[index];
				num++;
			} else if (this.items[index] == null && index != this.position - 2) {
				result[j] = this.items[++index];
			} else {
				break;
			}
		}
		return Arrays.copyOf(result, num);
	}

	/**.
	* method for find items
	* @param key name
	* @return array with dublicate name
	*/
	public Item[] findByName(String key) {
		int i = 0;
		int num = 0;
		Item[] result = new Item[this.position];
		for (int index = 0; index != position; index++) {
			if (items[index] != null && items[index].getName().equals(key)) {
				result[i++] = items[index];
				num++;
			}
		}
		return Arrays.copyOf(result, num);
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