package ru.job4j;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Turn {
	/**.
	* Method for creating and flipping an array
	* @param array array
	* @return result
	*/
	public int[] back(int[] array) {
		int x = array.length;
		int z = array.length / 2;

		for (int i = 0; i < z; i++) {
			int valueOne = array[i];
			int valueTwo = array[x - i - 1];
			array[i] = valueTwo;
			array[x - i - 1] = valueOne;
		}
		return array;

	}
}