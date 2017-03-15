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

public class BubbleSortTest {
	/**.
	* Method for test bubble sort
	*/
	@Test
	public void thenIsArraySortBubbleWhenSeeResult() {
		BubbleSort bubble = new BubbleSort();
		int[] firstArray = {1, 3, 2, 4};
		int[] secondArray = {1, 2, 3, 4};
		int[] expectArray = bubble.sort(firstArray);
		assertThat(expectArray, is(secondArray));
	}
}