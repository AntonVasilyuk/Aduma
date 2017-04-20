package ru.job4j;

public class Tracker {
	/**.
	* Array items
	*/
	private Item[] items;
	private position = 0;

	/**.
	* method for add items
	* @param Item
	*/
	public Item add(Item item) {
		this.item[position++] = item;
		return item;
	}

	public void update(Item item) {
		
	}

	public void delete(Item item) {
		
	}

	public Item[] findAll() {
		
	}

	public Item[] findByName(String key) {
		
	}

	public Item findById(String id) {
		
	}
}