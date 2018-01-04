package ru.job4j.Tracker.templates;

import ru.job4j.Tracker.start.Input;
import ru.job4j.Tracker.start.UserAction;
import ru.job4j.Tracker.start.Tracker;

import java.sql.SQLException;

/**
 * Task 8.4.2.
 * Update Tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
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
	* @input link on tool enter user
	* @tracker link on object class Tracker 
	*/ 
	public abstract void execute(Input input, Tracker tracker) throws SQLException;

	/**.
	* Method for get info about action
	* @nameAction info about action
	* @return String
	*/
	public String info(String nameAction) {
		return String.format("%s. %s", this.key(), this.nameAction);
	}
}