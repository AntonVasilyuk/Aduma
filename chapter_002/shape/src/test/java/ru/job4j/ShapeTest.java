package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

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
	* method for write print
	* @param fileName name file
	* @return string from file
	*/
	private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        return data;
	}
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

	/**.
	* Test method draw for square
	*/
	@Test
	public void whenNeedPrintingSquareThenWePrintSquare() throws Exception {
		int height = 3;
		Paint paint = new Paint();
		Square square = new Square(height);
		FileOutputStream f = new FileOutputStream("file.txt") ;
		System.setOut(new PrintStream(f));
		paint.draw(square);
		String fact = readUsingScanner("file.txt");
		String expect = "w w w \nw w w \nw w w \n\r\n";
		assertThat(fact, is(expect));
	}

	/**.
	* Test method draw for Triangle
	*/
	@Test
	public void whenNeedPrintingTriangleThenWePrintTriangle() throws Exception {
		int height = 3;
		Paint paint = new Paint();
		Triangle triangle = new Triangle(height);
		FileOutputStream f = new FileOutputStream("file.txt") ;
		System.setOut(new PrintStream(f));
		paint.draw(triangle);
		String expect = "w \nw w \nw w w \n\r\n";
		String fact = readUsingScanner("file.txt");
		assertThat(fact, is(expect));
	}
}