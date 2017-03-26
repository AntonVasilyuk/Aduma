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
		int l = array.length;
		int var;
		for (int x = 0; x < l / 2; x++) {
			for (int i = x; i < (l - x - 1); i++) {
				int j = l - 1;
				var = array[i][x];
				array[i][x] = array[j - x][i];
				array[j - x][i] = array[j - i][j - x];
				array[j - i][j - x] = array[x][j - i];
				array[x][j - i] = var;
			}
		}

		return array;
	}
}