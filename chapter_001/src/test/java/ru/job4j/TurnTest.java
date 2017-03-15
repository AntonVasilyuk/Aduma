package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class TurnTest {

	/**.
	* Test method back
	*/
	@Test
	public void whenIsArrayEvenNumberThenIsBackArray() {
		Turn turn = new Turn();
		int[] firstArray = {1, 2, 3, 4};
		int[] expecting = {4, 3, 2, 1};
		int[] twoArray = turn.back(firstArray);
		assertThat(twoArray, is(expecting));

	}

	/**.
	* Test method back
	*/
	@Test
	public void whenIsArrayOddNumberThenIsBackArray() {
		Turn turn = new Turn();
		int[] firstArray = {1, 2, 3, 4, 5};
		int[] expecting = {5, 4, 3, 2, 1};
		int[] twoArray = turn.back(firstArray);
		assertThat(twoArray, is(expecting));
	}
}