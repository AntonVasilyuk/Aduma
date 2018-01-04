package ru.job4j.Tracker.models;

/**
 * Task 8.4.2.
 * Update Tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */

public class Item {
	/**.
	* @id id item
	*/
	private String id;

	/**.
	* @name name item
	*/
	private String name;

	/**.
	* @desc desc item
	*/
	private String desc;

	/**.
	* @created created item
	*/
	private long created;

	/**.
	* @comments String[] ;
	*/
	private String[] comments;

	/**.
	* Constructor for class Item
	* @param name name new item
	* @param desc desc new item
	* @param created created new item
	*/
	public Item(String name, String desc, long created) {
		this.name = name;
		this.desc = desc;
		this.created = created;
	}

	/**.
	* getter for id
	* @return id
	*/
	public String getId() {
		return this.id;
	}

	/**.
	* setter for id
	* @param id id item
	*/
	public void setId(String id) {
		this.id = id;
	}

	/**.
	* getter for name
	* @return name item
	*/
	public String getName() {
		return this.name;
	}

	/**.
	* setter for name
	* @param name item
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**.
	* getter for desc
	* @return desc item
	*/
	public String getDesc() {
		return this.desc;
	}

	/**.
	* setter for desc
	* @param desc item
	*/
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**.
	* getter for created
	* @return created item
	*/
	public long getCreated() {
		return this.created;
	}

	/**.
	* setter for created
	* @param created item
	*/
	public void setCreated(long created) {
		this.created = created;
	}

	/**.
	* getter for comments
	* @return comments item
	*/
	public String[] getComments() {
		return this.comments;
	}

	/**.
	* setter for comments
	* @param comments item
	*/
	public void setComments(String[] comments) {
		this.comments = comments;
	}
}