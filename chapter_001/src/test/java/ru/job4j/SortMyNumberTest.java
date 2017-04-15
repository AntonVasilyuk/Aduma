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
public class SortMyNumberTest {
	/**.
	* Test my sorting
	*/
	@Test
	public void whenIsTwoArrayThenSortArray() {
		SortMyNumber ob = new SortMyNumber();
		int[] first = {1, 2, 3};
		int[] second = {4, 5, 6, 7};
		int[] exept = {1, 2, 3, 4, 5, 6, 7};
		int[] fact = ob.sortMyArrays(first, second);
		assertThat(fact, is(exept));
	}
}