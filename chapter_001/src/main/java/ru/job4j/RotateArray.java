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
		int[][] antiArray = new int[l][l];
		for (int x = 0; x < l / 2; x++) {
			for (int i = x; i < (l - x - 1); i++) {
				int j = l - 1;
				antiArray[i][x] = array[j - x][i];
				antiArray[j - x][i] = array[j - i][j - x];
				antiArray[j - i][j - x] = array[x][j - i];
				antiArray[x][j - i] = array[i][x];
			}
		}
		if ((l % 2) != 0) {
			antiArray[l / 2][l / 2] = array[l / 2][l / 2];
			}
		return antiArray;
	}
}