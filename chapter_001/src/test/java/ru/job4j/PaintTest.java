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
public class PaintTest {

	/**.
	* Build piramid
	*/
	@Test
	public void testBuildPiramid() {

		Paint paint = new Paint();
		String result = paint.piramid(2);
		String fact = " ^ \n^ ^ \n";
		assertThat(result, is(fact));

	}

}