package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**.
 * PointTest
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class PointTest {

	/**.
	* Тест нахождения расстояния
	*/
	@Test
	public void whenDistanceATOBThenOne() {
	Point a = new Point(1, 2);
	Point b = new Point(2, 2);

	double ab = a.distanceTo(b);

	assertThat(ab, closeTo(1d, 0.01));
	}
}