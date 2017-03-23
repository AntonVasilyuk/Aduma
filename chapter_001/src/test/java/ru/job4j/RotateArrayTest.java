package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
*
* @author AntonVasilyuk
* @version
* @since
*/

public class RotateArrayTest {

	/**.
	* method for test rotate array programm
	*/
	@Test
	public void whenArrayTwoOnTwoThenRotateArray() {
		RotateArray rotater = new RotateArray();
		int[][] firstArray = {{1, 2}, {3, 4}};
		int[][] secondArray = rotater.rotate(firstArray);
		int[][] expectArray = {{3, 1}, {4, 2}};
		assertThat(secondArray, is(expectArray));

	}

	/**.
	* method for test rotate array programm
	*/
	@Test
	public void whenArrayThirdOnThirdThenRotateArray() {
		RotateArray rotater = new RotateArray();
		int[][] firstArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] secondArray = rotater.rotate(firstArray);
		int[][] expectArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		assertThat(secondArray, is(expectArray));

	}
}