package ru.job4j.start;

import java.util.List;
import java.util.Scanner;

/**.
* Chapter_002
* It's class need for interaction for user
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class ConsolInput implements Input {

	/**.
	* @scanner scanner users enter
	*/
	private Scanner scanner = new Scanner(System.in);

	/**.
	* Method for interaction with user
	* @param question for user
	* @return enter user selection or information
	*/
	public String ask(String question) {

		System.out.print(question);
		return scanner.nextLine();
	}

	/**.
	* Method for check method ask
	* @param question from user
	* @param ranges array for correct number
	* @return enter user
	*/
	public int ask(String question, List<Integer> ranges) {
		int key = Integer.valueOf(this.ask(question));
		boolean check = false;
		for (int value : ranges) {
			if (value == key) {
				check = true;
				break;
			}
		}
		if (check) {
			return key;
		} else {
			throw new MenuOutException("Bingo! Out of menu range.");
		}
	}
}