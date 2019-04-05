package ru.job4j.start;

import ru.job4j.models.Item;
import ru.job4j.templates.BaseAction;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

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
	private List<UserAction> actions = new ArrayList<>();

	/**.
	 * It's name for action
	 */
	private String nameAction;

	/**.
	* Constructor.
	* @param input instance for input.
	* @param tracker instance for tracker.
	*/
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**.
	* Method for write in array action.
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
	public void select(int key) {
		for (UserAction u : actions) {
			if (u.key() == key) {
				u.execute(this.input, this.tracker);
			}
		}
	}

	/**.
	* Method for show all menu
	*/
	public void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
			System.out.println(action.info(nameAction));
			}
		}
	}

	/**.
	* Method for array corect number
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

		/**.
		 * Constructor
		 * @param key key for action
		 * @param nameAction name for action
		 */
		private AddItem(int key, String nameAction) {
			super(key, nameAction);
		}

		/**.
		 * Execute logic this class
		 * @param input instance for input
		 * @param tracker instance for tracker
		 */
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

		/**.
		 * Constructor
		 * @param key key for action
		 * @param nameAction name for action
		 */
		private FindAll(int key, String nameAction) {
			super(key, nameAction);
		}

		/**.
		 * Execute logic this class
		 * @param input instance for input
		 * @param tracker instance for tracker
		 */
		@Override
		public void execute(Input input, Tracker tracker) {
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

		/**.
		 * Constructor
		 * @param key key for action
		 * @param nameAction name for action
		 */
		private EditItem(int key, String nameAction) {
			super(key, nameAction);
		}

		/**.
		 * Execute logic this class
		 * @param input instance for input
		 * @param tracker instance for tracker
		 */
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

		/**.
		 * Constructor
		 * @param key it's key for action
		 * @param nameAction it's name for action
		 */
		private DeleteItem(int key, String nameAction) {
			super(key, nameAction);
		}

		/**.
		 * Execute logic this class
		 * @param input instance for input
		 * @param tracker instance for tracker
		 */
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

		/**.
		 * Constructor
		 * @param key key for action
		 * @param nameAction name for action
		 */
		private FindById(int key, String nameAction) {
			super(key, nameAction);
		}

		/**.
		 * Execute logic this class
		 * @param input instance for input
		 * @param tracker instance for tracker
		 */
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

		/**.
		 * Constructor
		 * @param key key for action
		 * @param nameAction name for action
		 */
		private FindByName(int key, String nameAction) {
			super(key, nameAction);
		}

		/**.
		 * Execute logic this class
		 * @param input instance for input
		 * @param tracker instance for tracker
		 */
		@Override
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Enter the name for item:");
			List<Item> arrayElement = tracker.findByName(name);
			for (Item element : arrayElement) {
				System.out.println(element.getName() + ", " + element.getDesc());
			}
			System.out.println("Thanks you! Your wish fulfilled");
		}
	}
}