package ru.job4j.start;

import java.util.List;
import java.util.function.Consumer;

/**.
* Chapter_002
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
	 * @output is link to consumer interface
	 */
	private Consumer<String> output;

	/**.
	* It's constructor for this class
	* @param input input parametr object
	* @param tracker parametr object
	 * @param output is example realisation consumer interface
	*/
	public StartUI(Input input, Tracker tracker, Consumer<String> output) {
		this.input = input;
		this.tracker = tracker;
		this.output = output;
	}
	/**.
	* method for intaraction with apps tracker
	*/
	public void init() {
		MenuTracker menu = new MenuTracker(this.input, this.tracker, System.out::print);

		menu.fillActions();
		List<Integer> ranges = menu.getArrayNumber();

		do {
			menu.show();
			int key = Integer.valueOf(input.ask("Select:", ranges));
			menu.select(key);
		} while (!"y".equals(this.input.ask("Exit?(y):")));
	}

	/**.
	* It's main method
	* @param args args
	*/
	public static void main(String[] args) {
		Input input = new ValidateInput();
		Tracker tracker = new Tracker();
		new StartUI(input, tracker, System.out::print).init();
	}
}