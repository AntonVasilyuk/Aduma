package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
* Test programm Counter
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class CounterTest {

	/**.
	* Test body
	*/
	@Test
	public void whenIsMoreNumberThenSummEvenNumber() {
		Counter counter = new Counter();
		int summ = counter.add(1, 10);
		assertThat(summ, is(30));

	}
}