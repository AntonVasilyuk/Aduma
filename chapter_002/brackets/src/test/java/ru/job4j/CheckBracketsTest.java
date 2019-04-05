package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
* Chapter_002
* It's class for testing checkBrackets
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class CheckBracketsTest {

	/**.
	* Test for method checkBrackets
	*/
	@Test
	public void whenIsArrayBracketsThenValidateThisBrackets() {
		CheckBrackets brack = new CheckBrackets();
		char[] brackets = {'(', ')', '(', ')'};
		boolean expected = true;
		boolean fact = brack.checkBreckets(brackets);
		assertThat(fact, is(expected));
	}
}