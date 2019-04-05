package ru.job4j.start;

import java.util.List;

/**.
* Chapter_002
* It's interface for give users enter
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public interface Input {

	/**.
	 * Method for getting info from user
	 * @param question it's question
	 * @return answer
	 */
	String ask(String question);

	/**.
	 * Method for getting number action
	 * @param question it's question
	 * @param ranges it's ranges for action
	 * @return number action
	 */
	int ask(String question, List<Integer> ranges);
}