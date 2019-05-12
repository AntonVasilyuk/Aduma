package ru.job4j.tracker.start;

import java.sql.SQLException;
import java.util.List;

/**.
 * Task 8.4.2.
 * Update tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */

public class StartUI {

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
	* Method for intaraction with apps tracker
	 * @throws SQLException may be exception
	*/
	public void init() throws SQLException {
		MenuTracker menu = new MenuTracker(this.input, this.tracker);

		menu.fillActions();
		List<Integer> ranges = menu.getArrayNumber();
		// UserAction deleteAction = new UserAction() {
			// public int key() {
				// return 3;
			// }
			// public void execute(Input input, tracker tracker) {
			//	tam tam
			// }
			// public String info() {
				// return "3. Delete";
			// }
		//}
		//menu.addAction(deleteAction);

		do {
			menu.show();
			int key = Integer.valueOf(input.ask("Select:", ranges));
			menu.select(key);
		} while (!"y".equals(this.input.ask("Exit?(y):")));
	}

	/**.
	* It's main method
	* @param args args
	 * @throws SQLException may be exception
	*/
	public static void main(String[] args) throws SQLException {
		Input input = new ValidateInput();
		Tracker tracker = new Tracker();
		new StartUI(input, tracker).init();
	}
}