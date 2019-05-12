package ru.job4j.tracker.templates;

import ru.job4j.tracker.start.Input;
import ru.job4j.tracker.start.UserAction;
import ru.job4j.tracker.start.Tracker;

import java.sql.SQLException;

/**
 * Task 8.4.2.
 * Update tracker from part 2
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
	 * @param key is key for action
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
	* @param input link on tool enter user
	* @param tracker link on object class tracker
	 * @throws SQLException is may be exception
	*/
	public abstract void execute(Input input, Tracker tracker) throws SQLException;

	/**.
	* Method for get info about action
	* @param nameAction info about action
	* @return String
	*/
	public String info(String nameAction) {
		return String.format("%s. %s", this.key(), this.nameAction);
	}
}