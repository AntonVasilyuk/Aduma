package ru.job4j.start;

import ru.job4j.models.*;
import java.util.Date;


/**.
* It programm for ready apps tracker
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class StartUI {

	/**.
	* @input input its object for interaction
	*/
	private Input input;

	/**.
	* It's constructor for this class
	* @param input input parametr object
	*/
	public StartUI(Input input) {
		this.input = input;
	}

	/**.
	* @date date for get time
	*/
	private Date date = new Date();

	/**.
	* method for intaraction with apps tracker
	*/
	public void init() {
		Tracker tracker = new Tracker();
		String name;
		String desc;
		String id;
		int selection;
		public final int ADD = 0;
		public final int SHOWALL = 1;
		public final int EDIT = 2;
		public final int DELETE = 3;
		public final int FINDBYID = 4;
		public final int FINDBYNAME = 5;
		public final int EXIT = 6;
		do {
			do {
				System.out.println("Menu tracker:");
				System.out.println("0. Add new item");
				System.out.println("1. Show all item");
				System.out.println("2. Edit item");
				System.out.println("3. Delete item");
				System.out.println("4. Find item by id");
				System.out.println("5. Find items by name");
				System.out.println("6. Exit program");
				selection = Integer.valueOf(input.ask("Enter the action number:"));
			} while (selection < 0 && selection > 6);

			if (selection == 0) {
				name = input.ask("Enter the name for item:");
				desc = input.ask("Enter the desc for item:");
				Item item = new Item(name, desc, date.getTime());
				tracker.add(item);
				System.out.println("Thanks you! Your wish fulfilled");
			}

			if (selection == 1) {
				Item[] array = tracker.findAll();
				for (int index = 0; index < array.length; index++) {
					System.out.println(array[index].getName() + ", " + array[index].getDesc());
				}
				System.out.println("Thanks you! Your wish fulfilled");
			}

			if (selection == 2) {
				id = input.ask("Enter the id for item:");
				name = input.ask("Enter the name for item:");
				desc = input.ask("Enter the desk for item:");
				Item item = new Item(name, desc, date.getTime());
				item.setId(id);
				tracker.update(item);
				System.out.println("Thanks you! Your wish fulfilled");
			}

			if (selection == 3) {
				id = input.ask("Enter the id for item:");
				tracker.delete(tracker.findById(id));
				System.out.println("Thanks you! Your wish fulfilled");
			}

			if (selection == 4) {
				id = input.ask("Enter the id for item:");
				Item item = tracker.findById(id);
				System.out.println(item.getName() + ", " + item.getDesc());
				System.out.println("Thanks you! Your wish fulfilled");
			}

			if (selection == 5) {
				name = input.ask("Enter the name for item:");
				Item[] items = tracker.findByName(name);
				for (int index = 0; index < items.length; index++) {
					System.out.println(items[index].getName() + ", " + items[index].getDesc());
				}
				System.out.println("Thanks you! Your wish fulfilled");
			}
		} while (selection != 6);
	}

	/**.
	* It's main method
	* @param args args
	*/
	public static void main(String[] args) {
		Input input = new ConsolInput();
		new StartUI(input).init();
	}
}