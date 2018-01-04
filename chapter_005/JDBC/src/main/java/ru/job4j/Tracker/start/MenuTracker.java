package ru.job4j.Tracker.start;

import ru.job4j.Tracker.models.Item;
import ru.job4j.Tracker.templates.BaseAction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Task 8.4.2.
 * Update Tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */

public class MenuTracker {

	/**.
	* @input value for parametr
	*/
	private Input input;

	/**.
	* @tracker value for parametr
	*/
	private Tracker tracker;

	/**.
	* @actions Array for actions
	*/
	private List<UserAction> actions = new ArrayList<>();

	private String nameAction;
	/**.
	* Constructor
	* @param input
	* @param tracker
	*/
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**.
	* method for write in array action
	*/
	public void fillActions() {
		this.actions.add(this.new AddItem(0, "Add new item"));
		this.actions.add(this.new FindAll(1, "Show info about all item"));
		this.actions.add(this.new EditItem(2, "Edit item by id"));
		this.actions.add(this.new DeleteItem(3, "Delete item"));
		this.actions.add(this.new FindById(4, "Find item by id"));
		this.actions.add(this.new FindByName(5, "Find item by name"));
	}

/* 	public void addActions(UserAction action) {
		this.actions[position++] = action;
	} */
	/**.
	* method for select action
	* @param key number action
	*/
	public void select(int key) throws SQLException {
		for(UserAction u : actions) {
			if (u.key() == key) {u.execute(this.input, this.tracker);}
		}
	}

	/**.
	* method for show all menu
	*/
	public void show() {
		for (UserAction action : this.actions) {
			if(action != null) {
			System.out.println(action.info(nameAction));
			}
		}
	}

	/**.
	* method for array corect number
	* @return array
	*/
	public List<Integer> getArrayNumber() {
		List<Integer> ranges = new ArrayList<>();
		for (UserAction u : actions) {
			ranges.add(u.key());
		}
		return ranges;
	}
	/**.
	* Class for action ADD
	*/
	private class AddItem extends BaseAction {
		private AddItem(int key, String nameAction) {
			super(key, nameAction);
		}

		@Override
		public void execute(Input input, Tracker tracker) throws SQLException {
			Date date = new Date();
			String name = input.ask("Enter the name for item:");
			String desc = input.ask("Enter the desc for item:");
			Item item = new Item(name, desc, date.getTime());
			tracker.add(item);
			System.out.println("Thanks you! Your wish fulfilled");
		}
	}

	/**.
	* Class for action FindAll
	*/
	private class FindAll extends BaseAction {
		private FindAll(int key, String nameAction) {
			super(key, nameAction);
		}

		@Override
		public void execute(Input input, Tracker tracker) throws SQLException {
			List<Item> arrayElement = tracker.findAll();
			for (Item element : arrayElement) {
				System.out.println(element.getName() + ", " + element.getDesc());
			}
			System.out.println("Thanks you! Your wish fulfilled");
		}
	}

	/**.
	* Class for action EDIT
	*/
	private class EditItem extends BaseAction {
		private EditItem(int key, String nameAction) {
			super(key, nameAction);
		}

		@Override
		public void execute(Input input, Tracker tracker) throws SQLException {
			Date date = new Date();
			String id = input.ask("Enter the id for item:");
			String name = input.ask("Enter the name for item:");
			String desc = input.ask("Enter the desk for item:");
			Item item = new Item(name, desc, date.getTime());
			item.setId(id);
			tracker.update(item);
			System.out.println("Thanks you! Your wish fulfilled");
		}
	}

	/**.
	* Class for action DELETE
	*/
	private class DeleteItem extends BaseAction {

		private DeleteItem(int key, String nameAction) {
			super(key, nameAction);
		}

		@Override
		public void execute(Input input, Tracker tracker) throws SQLException {
			String id = input.ask("Enter the id for item:");
			tracker.delete(tracker.findById(id));
			System.out.println("Thanks you! Your wish fulfilled");
		}
	}

	/**.
	* Class for action FINDBYID
	*/
	private class FindById extends BaseAction {

		private FindById(int key, String nameAction) {
			super(key, nameAction);
		}

		@Override
		public void execute(Input input, Tracker tracker) throws SQLException {
			String id = input.ask("Enter the id for item:");
			Item item = tracker.findById(id);
			System.out.println(item.getName() + ", " + item.getDesc());
			System.out.println("Thanks you! Your wish fulfilled");
		}
	}

	/**.
	* Class for action FINDBYNAME
	*/
	private class FindByName extends BaseAction {

		private FindByName(int key, String nameAction) {
			super(key, nameAction);
		}

		@Override
		public void execute(Input input, Tracker tracker) throws SQLException {
			String name = input.ask("Enter the name for item:");
			List<Item> arrayElement = tracker.findByName(name);
			for (Item element : arrayElement) {
				System.out.println(element.getName() + ", " + element.getDesc());
			}
			System.out.println("Thanks you! Your wish fulfilled");
		}
	}
}