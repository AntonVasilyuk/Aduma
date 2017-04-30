package ru.job4j.start;

/**.
* This class need for interaction for user
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