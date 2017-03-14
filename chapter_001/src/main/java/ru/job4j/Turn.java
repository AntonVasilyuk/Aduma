package ru.job4j;

import org.apache.commons.lang3.ArrayUtils;

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

		ArrayUtils.reverse(array);
		return array;

	}
}