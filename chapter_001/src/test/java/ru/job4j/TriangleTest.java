package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**.
* Тест подсчет площади треугольника
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class TriangleTest {

	/**.
	* Тест определения площади треугольника
	*/
	@Test
	public void whenABTreeBCFourACFiveThenSSix() {

		Point a = new Point(1, 2);
		Point b = new Point(2, 2);
		Point c = new Point(3, 4);
		Triangle triangle = new Triangle();
		double s = triangle.area(a, b, c);
		assertThat(s, closeTo(1.1755705045849454d, 0.01));

	}
}