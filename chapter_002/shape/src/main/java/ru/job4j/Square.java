package ru.job4j;

/**.
* Chapter_002
* Task 5.4
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Square implements Shape {
	/**.
	* @height height this shape
	*/
	private int height;

	/**.
	* Constructor
	* @param height this square
	*/
	public Square(int height) {
		this.height = height;
	}

	/**.
	* method for build square
	* @param height square
	* @return square to paint
	*/
	public String pic() {
		StringBuilder buildShape = new StringBuilder();

		String result = "";
		String temp = "w ";

		for (int index = 0; index < this.height; index++) {
				result = result + temp;
		}

		result += "\n";

		for (int index = 0; index < this.height; index++) {
			buildShape.append(result);
		}

		return buildShape.toString();
	}
}