package ru.job4j.start;

import java.util.*;
import ru.job4j.models.Item;

/**.
* chapter_002
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
		this.actions[0] = this.new AddItem();
		this.actions[1] = this.new FindAll();
		this.actions[2] = this.new EditItem();
		this.actions[3] = this.new DeleteItem();
		this.actions[4] = this.new FindById();
		this.actions[5] = this.new FindByName();
	}

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
			System.out.println(action.info());
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
	private class AddItem implements UserAction {
		public int key() {
			return 0;
		}
		public void execute(Input input, Tracker tracker) {
			Date date = new Date();
			String name = input.ask("Enter the name for item:");
			String desc = input.ask("Enter the desc for item:");
			Item item = new Item(name, desc, date.getTime());
			tracker.add(item);
			System.out.println("Thanks you! Your wish fulfilled");
		}
		public String info() {
			return String.format("%s. %s", this.key(), "add the new item");
		}
	}

	/**.
	* Class for action FindAll
	*/
	private class FindAll implements UserAction {
		public int key() {
			return 1;
		}
		public void execute(Input input, Tracker tracker) {
			Item[] array = tracker.findAll();
			for (int index = 0; index < array.length; index++) {
				System.out.println(array[index].getName() + ", " + array[index].getDesc());
			}
			System.out.println("Thanks you! Your wish fulfilled");
		}
		public String info() {
			return String.format("%s. %s", this.key(), "show all item");
		}
	}
	/**.
	* Class for action EDIT
	*/
	private class EditItem implements UserAction {
		public int key() {
			return 2;
		}
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
		public String info() {
			return String.format("%s. %s", this.key(), "edit the new item");
		}
	}

	/**.
	* Class for action DELETE
	*/
	private class DeleteItem implements UserAction {
		public int key() {
			return 3;
		}
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Enter the id for item:");
			tracker.delete(tracker.findById(id));
			System.out.println("Thanks you! Your wish fulfilled");
		}
		public String info() {
			return String.format("%s. %s", this.key(), "delete the new item");
		}
	}

	/**.
	* Class for action FINDBYID
	*/
	private class FindById implements UserAction {
		public int key() {
			return 4;
		}
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Enter the id for item:");
			Item item = tracker.findById(id);
			System.out.println(item.getName() + ", " + item.getDesc());
			System.out.println("Thanks you! Your wish fulfilled");
		}
		public String info() {
			return String.format("%s. %s", this.key(), "Find item by id");
		}
	}

	/**.
	* Class for action FINDBYNAME
	*/
	private class FindByName implements UserAction {
		public int key() {
			return 5;
		}
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Enter the name for item:");
			Item[] items = tracker.findByName(name);
			for (int index = 0; index < items.length; index++) {
				System.out.println(items[index].getName() + ", " + items[index].getDesc());
			}
			System.out.println("Thanks you! Your wish fulfilled");
		}
		public String info() {
			return String.format("%s. %s", this.key(), "Find item by name");
		}
	}
}