package ru.job4j.start;

import java.util.*;
import ru.job4j.models.Item;
import ru.job4j.templates.BaseAction;

/**.
* Chapter_002
* Main action
* task 2.6.1
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
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
	private UserAction[] actions = new UserAction[6];

	private int position = 0;

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
		this.actions[0] = this.new AddItem(0, "Add new item");
		this.actions[1] = this.new FindAll(1, "Show info about all item");
		this.actions[2] = this.new EditItem(2, "Edit item by id");
		this.actions[3] = this.new DeleteItem(3, "Delete item");
		this.actions[4] = this.new FindById(4, "Find item by id");
		this.actions[5] = this.new FindByName(5, "Find item by name");
	}

/* 	public void addActions(UserAction action) {
		this.actions[position++] = action;
	} */
	/**.
	* method for select action
	* @param key number action
	*/
	public void select(int key) {
		this.actions[key].execute(this.input, this.tracker);
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
	public int[] getArrayNumber() {
		int[] ranges = new int[actions.length];
		for (int i = 0; i < actions.length; i++) {
			ranges[i] = i;
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
		public void execute(Input input, Tracker tracker) {
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
		public void execute(Input input, Tracker tracker) {
			Item[] array = tracker.findAll();
			for (int index = 0; index < array.length; index++) {
				System.out.println(array[index].getName() + ", " + array[index].getDesc());
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
		public void execute(Input input, Tracker tracker) {
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
		public void execute(Input input, Tracker tracker) {
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
		public void execute(Input input, Tracker tracker) {
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
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Enter the name for item:");
			Item[] items = tracker.findByName(name);
			for (int index = 0; index < items.length; index++) {
				System.out.println(items[index].getName() + ", " + items[index].getDesc());
			}
			System.out.println("Thanks you! Your wish fulfilled");
		}
	}
}