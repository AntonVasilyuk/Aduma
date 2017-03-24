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

public class ArrayDublicateTest {
	/**.
	* method for test
	*/
	@Test
	public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
		ArrayDublicate nemo = new ArrayDublicate();
		String[] wordDubl = {"world", "light", "water", "light"};
		String[] wordExpect = {"world", "light", "water"};
		String[] word = nemo.remove(wordDubl);
		assertThat(word, is(wordExpect));
	}
}