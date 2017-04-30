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
		MenuTracker menu = new MenuTracker(this.input, this.tracker);

		int[] ranges = menu.getArrayNumber();
 		menu.fillActions();

		do {
			menu.show();
			int key = Integer.valueOf(input.ask("Select:", ranges));
			menu.select(key);
			
		} while(!"y".equals(this.input.ask("Exit?(y):")));
	}

	/**.
	* It's main method
	* @param args args
	*/
	public static void main(String[] args) {
		Input input = new ValidateInput();
		Tracker tracker = new Tracker();
		new StartUI(input, tracker).init();
	}
}