package ru.job4j.tracker.start;

import java.util.List;

/**.
 * Task 8.4.2.
 * Update tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */


public interface Input {

	/**.
	 * Method for asking the user
	 * @param question is question
	 * @return ask
	 */
	String ask(String question);

	/**.
	 * Get number action
	 * @param question question
	 * @param ranges ranges
	 * @return result
	 */
	int ask(String question, List<Integer> ranges);
}