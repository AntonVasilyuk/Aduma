package ru.job4j;

/**.
* Chapter_002
* Task 5.4
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Triangle implements Shape {
	/**.
	* @height this shape
	*/
	private int height;
	/**.
	* Constructor
	* @param height this shape
	*/
	public Triangle(int height) {
		this.height = height;
	}

	/**.
	* Method for build triangle
	* @param height triangle
	* @return shape to paint
	*/
	public String pic() {
		StringBuilder buildShape = new StringBuilder();

		String result = "";
		String temp = "w ";
		String nextLine = "\n";

		for (int index = 0; index < this.height; index++) {
				result = result + temp;
				buildShape.append(result).append(nextLine);
		}

		return buildShape.toString();
	}
}