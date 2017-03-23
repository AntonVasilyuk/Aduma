package ru.job4j;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class RotateArray {

	/**.
	* method for rotate array
	* @param array for rotate
	* @return rotate array
	*/
	public int[][] rotate(int[][] array) {
		int x = array.length;
		int[][] antiArray = new int[x][x];
		antiArray[0][x - 1] = array[0][0];
		antiArray[x - 1][x - 1] = array[0][x - 1];
		antiArray[x - 1][0] = array[x - 1][x - 1];
		antiArray[0][0] = array[x - 1][0];
		if (x > 2) {
			antiArray[x - 2][0] = array[x - 1][x - 2];
			antiArray[x - 1][x - 2] = array[x - 2][x - 1];
			antiArray[x - 2][x - 1] = array[0][x - 2];
			antiArray[0][x - 2] = array[x - 2][0];
			antiArray[x - 2][x - 2] = array[x - 2][x - 2];
		}
		return antiArray;
	}
}