package ru.job4j;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class BubbleSort {
	/**.
	* Method sort array
	* @param array array
	* @return sort array
	*/
	public int[] sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int x = array.length - 1; x > i; x--) {
				if (array[x] < array[x - 1]) {
					int value = array[x];
					array[x] = array[x - 1];
					array[x - 1] = value;
				}
			}
		}
	return array;
	}
}