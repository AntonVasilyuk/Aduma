package ru.job4j.tracker.start;

/**
 * Task 8.4.2.
 * Update tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */


public class MenuOutException extends RuntimeException {

	/**.
	* Comstructor to display the error
	* @param msg is message
	*/
	public MenuOutException(String msg) {
		super(msg);
	}
}