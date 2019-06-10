package ru.job4j.start;

import ru.job4j.tracker.ITracker;

/**.
* Chapter_002
* Task 2.7.1
* This interface need for creating action for user's
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public interface UserAction {

	/**.
	 * Getting key
	 * @return key
	 */
	int key();

	/**.
	 * It's executing action
	 * @param input instance for input
	 * @param tracker instance for tracker
	 */
	void execute(Input input, ITracker tracker);

	/**.
	 * Info about action
	 * @param nameAction it's name for action
	 * @return info
	 */
	String info(String nameAction);
}