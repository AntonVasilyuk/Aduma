package ru.job4j.start;

import java.util.*;

/**.
* This class need for interaction for user
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
}