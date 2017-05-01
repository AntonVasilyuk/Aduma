package ru.job4j.start;

/**.
* Chapter_002
* Task 2.7.1
* This class need for creating MenuOutException
* 
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class MenuOutException extends RuntimeException {

	/**.
	* Comstructor to display the error
	* @param msg
	*/
	public MenuOutException(String msg) {
		super(msg);
	}
}