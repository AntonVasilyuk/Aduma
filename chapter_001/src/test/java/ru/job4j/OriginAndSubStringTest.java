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
public class OriginAndSubStringTest {
	/**.
	* Method for checking string
	*/
	@Test
	public void whenSubIsOriginThenTrue() {
		OriginAndSubString ob = new OriginAndSubString();
		String origin = "population";
		String sub = "ion";
		boolean expect = true;
		boolean fact = ob.contains(origin, sub);
		assertThat(fact, is(expect));

	}
}