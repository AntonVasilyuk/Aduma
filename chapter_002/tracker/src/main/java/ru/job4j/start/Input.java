package ru.job4j.start;

/**.
* Chapter_002
* It's interface for give users enter
* 
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public interface Input {
	
	String ask(String question);
	int ask(String question, int[] ranges);
}