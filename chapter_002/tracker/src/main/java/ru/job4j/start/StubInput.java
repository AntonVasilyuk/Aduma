package ru.job4j.start;

import java.util.List;

/**.
* Chapter_002
* Task 2.6.1
* It's class need for imitation interaction for user
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class StubInput implements Input {

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

	/**.
	* method for write answer in the array answers
	* @param question is question from user
	* @return answer
	*/
	public String ask(String question) {
		return answers[position++];
	}


	/**.
	* Method for output
	* @param question is question from user
	* @param ranges is ranges
	* @return -1
	*/
	public int ask(String question, List<Integer> ranges) {
		Integer key = Integer.valueOf(this.ask(question));
		boolean check = false;
		for (Integer value : ranges) {
			if (value == key) {
				check = true;
				break;
			}
		}
		if (check) {
			return key;
		} else {
			throw new MenuOutException("Out of menu range");
		}
	}
}