package ru.job4j;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/
public class Factorial {

	/**.
	* Method for calculation factorial
	* @param x number factorial
	* @return result
	*/
	public int multiplFactor(int x) {

		/**.
		* @i value
		*/
		int i = 1;
		int result = 1;
		int z = x + 1;
		for (i = 1; i < z; i++) {
			result = result * i;
		}
		return result;
	}

}