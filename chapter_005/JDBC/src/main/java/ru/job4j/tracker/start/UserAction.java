package ru.job4j.tracker.start;

import java.sql.SQLException;

/**
 * Task 8.4.2.
 * Update tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */

public interface UserAction {

	/**.
	 * Getter for key
	 * @return key
	 */
	int key();

	/**.
	 * Main mehtod for action
	 * @param input is link to the input
	 * @param tracker is link to the tracker
	 * @throws SQLException may be exception
	 */
	void execute(Input input, Tracker tracker) throws SQLException;

	/**.
	 * Get info
	 * @param nameAction name action
	 * @return info
	 */
	String info(String nameAction);
}