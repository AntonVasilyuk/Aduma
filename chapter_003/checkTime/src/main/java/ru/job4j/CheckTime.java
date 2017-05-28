package ru.job4j;

import java.util.*;

/**.
* Chapter_003
* Task 3.1.2
* Check time for other collection
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class CheckTime {

	/**.
	* Method for check time for operation add
	* @param collection
	* @param line is added word
	* @param amount is number element
	* @return time
	*/
	public long add(Collection<String> collection, String line, int amount) {

		String word;
		int num = 0;
		long firstTime = System.currentTimeMillis();

		for (int i = 0; i < amount; i++) {
			num++;
			word = line + num;
			collection.add(word);
		}
		long secondTime = System.currentTimeMillis();
		return secondTime - firstTime;
	}
	public long delete(Collection<String> collection, int amount) {

		Iterator<String> iter = collection.iterator();
		int i = 0;
		long firstTime = System.currentTimeMillis();

		while (iter.hasNext() && i < amount) {
			iter.next();
			iter.remove();
			i++;
		}

		long secondTime = System.currentTimeMillis();
		return secondTime - firstTime;
	}
}