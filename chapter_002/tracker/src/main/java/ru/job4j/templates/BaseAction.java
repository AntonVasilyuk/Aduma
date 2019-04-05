package ru.job4j.templates;

import ru.job4j.start.UserAction;
import ru.job4j.start.Input;
import ru.job4j.start.Tracker;

/**.
* Chapter_002
* Task 2.8.1
* Used Interface and abstract class
*
* @author Anton Vasilyuk
* @version 1.0
* @since
*/

public abstract class BaseAction implements UserAction {

	/**.
	* @key number action
	*/
	private int keyAction;

	/**.
	* @nameAction it's value for information about action
	*/
	private String nameAction;

	/**.
	* Constructor for class BaseAction
	* @param name it's value for information about action
	 * @param key it's key for action
	*/
	public BaseAction(int key, String name) {
		this.keyAction = key;
		this.nameAction = name;
	}

	/**.
	* Abstract method for key action
	* @return keyAction
	*/
	public int key() {
		return this.keyAction;
	}

	/**.
	* Abstract method for implemetion main action
	* @param input link on tool enter user
	* @param tracker link on object class Tracker
	*/
	public abstract void execute(Input input, Tracker tracker);

	/**.
	* Method for get info about action
	* @param nameAction info about action
	* @return String
	*/
	public String info(String nameAction) {
		return String.format("%s. %s", this.key(), this.nameAction);
	}
}