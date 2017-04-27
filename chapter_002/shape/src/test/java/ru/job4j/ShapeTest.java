package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
* Chapter_002
* Test for task 5.4
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class ShapeTest {

	/**.
	* Test method pic for square
	*/
	@Test
	public void whenNeedBuildSquareThenWeBuildSquare() {
		int height = 3;
		Square square = new Square(height);
		String fact = square.pic();
		String expect = "w w w \nw w w \nw w w \n";
		assertThat(fact, is(expect));
	}

	/**.
	* Test method pic for triangle
	*/
	@Test
	public void whenNeedBuildTriangleThenWeBuildTriangle() {
		int height = 3;
		Triangle triangle = new Triangle(height);
		String fact = triangle.pic();
		String expect = "w \nw w \nw w w \n";
		assertThat(fact, is(expect));
	} 
}