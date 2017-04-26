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
	* @ADD for method add
	*/
	private final static int ADD = 0;
	/**.
	* @SHOWALL for method show all
	*/
	private final static int SHOWALL = 1;

	/**.
	* @EDIT for method edit
	*/
	private final static int EDIT = 2;

	/**.
	* @DELETE for method delete
	*/
	private final static int DELETE = 3;

	/**.
	* @FINDBYID for method find by id
	*/
	private final static int FINDBYID = 4;

	/**.
	* @FINDBYNAME for method find by name
	*/
	private final static int FINDBYNAME = 5;

	/**.
	* @EXIT for exit
	*/
	private final static int EXIT = 6;

	/**.
	* @input input its object for interaction
	*/
	private Input input;

	/**.
	* @tracker tracker its object for interaction
	*/
	private Tracker tracker;

	/**.
	* It's constructor for this class
	* @param input input parametr object
	* @param tracker parametr object
	*/
	public StartUI(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	/**.
	* method for intaraction with apps tracker
	*/
	public void init() {
		//Tracker tracker = new Tracker();

		String name;
		String desc;
		String id;

		int selection;

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

			if (selection == ADD) {
				Date date = new Date();
				name = input.ask("Enter the name for item:");
				desc = input.ask("Enter the desc for item:");
				Item item = new Item(name, desc, date.getTime());
				tracker.add(item);
				System.out.println("Thanks you! Your wish fulfilled");
			}

			if (selection == SHOWALL) {
				Item[] array = tracker.findAll();
				for (int index = 0; index < array.length; index++) {
					System.out.println(array[index].getName() + ", " + array[index].getDesc());
				}
				System.out.println("Thanks you! Your wish fulfilled");
			}

			if (selection == EDIT) {
				Date date = new Date();
				id = input.ask("Enter the id for item:");
				name = input.ask("Enter the name for item:");
				desc = input.ask("Enter the desk for item:");
				Item item = new Item(name, desc, date.getTime());
				item.setId(id);
				tracker.update(item);
				System.out.println("Thanks you! Your wish fulfilled");
			}

			if (selection == DELETE) {
				id = input.ask("Enter the id for item:");
				tracker.delete(tracker.findById(id));
				System.out.println("Thanks you! Your wish fulfilled");
			}

			if (selection == FINDBYID) {
				id = input.ask("Enter the id for item:");
				Item item = tracker.findById(id);
				System.out.println(item.getName() + ", " + item.getDesc());
				System.out.println("Thanks you! Your wish fulfilled");
			}

			if (selection == FINDBYNAME) {
				name = input.ask("Enter the name for item:");
				Item[] items = tracker.findByName(name);
				for (int index = 0; index < items.length; index++) {
					System.out.println(items[index].getName() + ", " + items[index].getDesc());
				}
				System.out.println("Thanks you! Your wish fulfilled");
			}
		} while (selection != EXIT);
	}

	/**.
	* It's main method
	* @param args args
	*/
	public static void main(String[] args) {
		Input input = new ConsolInput();
		Tracker tracker = new Tracker();
		new StartUI(input, tracker).init();
	}
}