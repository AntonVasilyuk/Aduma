package ru.job4j.start;

import ru.job4j.models.*;

/**.
* chapter_002
* It's class for testing behavior users
* 
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class StubInput implements Input {

	/**.
	* @tracker tracker is object for inspection
	*/
	private Tracker tracker = new Tracker();

	/**.
	* @answers answers is array for parametr testing
	*/
	private String[] answers;

	/**.
	* @position index for array
	*/
	private int position = 0;

	/**.
	* Constructor
	* @param answers array for data 
	*/
	public StubInput(String[] answers) {
		this.answers = answers;
	}

	public String ask(String question) {
		return answers[position++];
	}
	
}