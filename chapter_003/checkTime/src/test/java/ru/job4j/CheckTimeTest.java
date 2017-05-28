package ru.job4j;

import java.util.*;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
* Chapter_003
* Task 3.1.2
* Test check time for other collection
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/
public class CheckTimeTest {

	/**.
	* Test time for add element
	*/
	@Test
	public void whenNeedCheckTimeAddElementThenLookTime() {

		CheckTime checkTime = new CheckTime();

		List<String> wordsLink = new LinkedList<>();
		List<String> wordsArray = new ArrayList<>();
		Set<String> wordsTree = new TreeSet<>();

		String line = "Ship";
		int amount = 1000000;

		long timeOperationLink = checkTime.add(wordsLink, line, amount);
		long timeOperationArray = checkTime.add(wordsArray, line, amount);
		long timeOperationTree = checkTime.add(wordsTree, line, amount);

		System.out.println(timeOperationLink);
		System.out.println(timeOperationArray);
		System.out.println(timeOperationTree);

		boolean fact = false;
		if (timeOperationLink > 0 && timeOperationArray > 0 && timeOperationTree > 0) {fact = true;}
		boolean expected = true;

		assertThat(fact, is(expected));
	}

	/**.
	 * Test time for add element
	 */
	@Test
	public void whenNeedCheckTimeDeleteElementThenLookTime() {

		CheckTime checkTime = new CheckTime();

		List<String> wordsLink = new LinkedList<>();
		List<String> wordsArray = new ArrayList<>();
		Set<String> wordsTree = new TreeSet<>();

		String line = "Ship";
		int amount = 1000000;

		checkTime.add(wordsLink, line, amount);
		long timeOperationLink = checkTime.delete(wordsLink, 500000);
		checkTime.add(wordsArray, line, amount);
		long timeOperationArray = checkTime.delete(wordsArray, 500000);
		checkTime.add(wordsTree, line, amount);
		long timeOperationTree = checkTime.delete(wordsTree, 500000);

		System.out.println(timeOperationLink);
		System.out.println(timeOperationArray);
		System.out.println(timeOperationTree);

		boolean fact = false;
		if (timeOperationLink > 0) {fact = true;}
		boolean expected = true;

		assertThat(fact, is(expected));
	}
}