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
public class FactorialTest {

	/**.
	* Test calculate factorial
	*/
	@Test
	public void whenNumberXThenResult() {

		Factorial factorial = new Factorial();
		int result = factorial.multiplFactor(3);
		assertThat(result, is(6));
	}
}