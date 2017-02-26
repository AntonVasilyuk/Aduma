package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * MaxTest
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class MaxTest {

	/**.
	* Тест кто больше
	*/
	@Test
	public void testWhenFirstMoreSecondThenFirst() {
		Max maxNumber = new Max();
		maxNumber.max(2, 1);
		final int result = maxNumber.getResult();
		assertThat(result, is(2));

	}

}