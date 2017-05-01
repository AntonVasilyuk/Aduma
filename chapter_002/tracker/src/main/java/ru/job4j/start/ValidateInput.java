package ru.job4j.start;

import java.util.*;

/**.
* Chapter_002
* Task 2.7.1
* This class need for interaction for user
* 
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class ValidateInput extends ConsolInput {

	/**.
	* method for checking answers user, and output error
	* @param question
	* @param ranges
	* @return value
	*/
	public int ask(String question, int[] ranges) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = super.ask(question, ranges);
				invalid = false;
			} catch(MenuOutException moe) {
				System.out.println("Please select key from menu.");
			} catch(NumberFormatException nfe) {
				System.out.println("Please enter validate data again.");
			}
		} while(invalid);
		return value;
	}
}