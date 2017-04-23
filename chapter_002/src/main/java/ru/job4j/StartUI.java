package ru.job4j;

public class StartUI {
	private Input input;

	public StartUI(Input input) {
		this.input = input;
	}

	public void init() {
		Tracker tracker = new Tracker();
		String name;
		String desc;
		String selection;
		String id;
		for(;;) {
			do {
				System.out.println("Menu tracker:");
				System.out.println("0. Add new item");
				System.out.println("1. Show all item");
				System.out.println("2. Edit item");
				System.out.println("3. Delete item");
				System.out.println("4. Find item by id");
				System.out.println("5. Find items by name");
				System.out.println("6. Exit program");
				selection = input.ask("Enter the action number:")
			} while (Integer.parseInt(name) < 0 && Integer.parseInt(name) > 6);
			if (Integer.parseInt(selection) == 6) {
				break;
			}
			if (Integer.parseInt(selection) == 0) {
				name = input.ask("Enter the name for item:");
				desc = input.ask("Enter the desc for item:");
				Item Item = new Item(name, desc, getTime());
				tracker.add(item);
				System.out.println("Thanks you! Your wish fulfilled");
			}
			if (Integer.parseInt(selection) == 1) {
				Item array = tracker.findAll();
				for (int index = 0; index < array.length; index++) {
					System.out.println(array[index].getName + ", " + array[index].getDesc);
				}
				System.out.println("Thanks you! Your wish fulfilled");
			}
			if (Integer.parseInt(selection) == 2) {
				id = input.ask("Enter the id for item:");
				name = input.ask("Enter the name for item:");
				desk = input.ask("Enter the desk for item:");
				Item item = new Item(name, desc, getTime);
				item.setId(id);
				tracker.update(item);
				System.out.println("Thanks you! Your wish fulfilled");
			}
			if (Integer.parseInt(selection) == 3) {
				id = input.ask("Enter the id for item:");
				tracker.delete(id);
				System.out.println("Thanks you! Your wish fulfilled");
			}
			if (Integer.parseInt(selection) == 4) {
				id = input.ask("Enter the id for item:");
				Item item = tracker.findById(id);
				System.out.println(item.getName() + ", " + item.getDesc());
				System.out.println("Thanks you! Your wish fulfilled");
			}
			if (Integer.parseInt(selection) == 5) {
				name = input.ask("Enter the name for item:");
				Item item = tracker.findByName(name);
				System.out.println(item.getName() + ", " + item.getDesc());
				System.out.println("Thanks you! Your wish fulfilled");
			}
		}
	}
	public static void main(String[] args) {
		Input input = new ConsoleInput();
		new StartUI(input).init();
	}
}