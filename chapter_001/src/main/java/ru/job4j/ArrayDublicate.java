package ru.job4j;

import java.util.Arrays;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class ArrayDublicate {
	/**.
	* method for delete dublicate
	* @param array array
	* @return result
	*/
	public String[] remove(String[] array) {
		int summdublicate = 0;
		for (int i = 0; i < array.length; i++) {
			String wordOne;
			wordOne = array[i];
			for (int y = 0; y < array.length; y++) {
				String wordTwo = array[y];
				if (wordOne == wordTwo & i != y) {
					summdublicate++;
					String b = array[y];
					array[y] = array[array.length - 1];
					array[array.length - 1] = b;
				}
			}
		}
		return Arrays.copyOf(array, array.length - summdublicate + 1);
	}
}