package ru.job4j;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Item {
	/**.
	* @id String
	*/
	private String id;

	/**.
	* @name String
	*/
	private String name;

	/**.
	* @desc String
	*/
	private String desc;

	/**.
	* @created long
	*/
	private long created;

	/**.
	* @comments int[];
	*/
	private String[] comments;

	/**.
	* getter for id
	* @return id
	*/
	public String getId() {
		return this.id;
	}

	/**.
	* setter for id
	* @param id
	*/
	public void setId(String id) {
		this.id = id;
	}

	/**.
	* getter for name
	* @return name
	*/
	public String getName() {
		return this.name;
	}

	/**.
	* setter for name
	* @param name
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**.
	* getter for desc
	* @return desc
	*/
	public String getDesc() {
		return this.desc;
	}

	/**.
	* setter for desc
	* @param desc
	*/
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**.
	* getter for created
	* @return created
	*/
	public long getCreated() {
		return this.created;
	}

	/**.
	* setter for created
	* @param created
	*/
	public void setCreated(long created) {
		this.created = created;
	}

	/**.
	* getter for comments
	* @return comments
	*/
	public String[] getComments() {
		return this.comments;
	}

	/**.
	* setter for comments
	* @param comments
	*/
	public void setComments(String[] comments) {
		this.comments = comments;
	}
}