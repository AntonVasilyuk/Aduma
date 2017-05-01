package ru.job4j.start;

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
	public int key();
	public void execute(Input input, Tracker tracker);
	public String info(String nameAction);
}