package ru.job4j;

/**.
* Program summ even number
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/
public class Counter {


	/**.
	* Method for summ even number
	* @param first argument
	* @param second argument
	* @return summ
	*/
	public int add(int first, int second) {

		/**.
		* @b value
		*/
		int b = first;
		/**.
		* @c value for result
		*/
		int c = 0;

		while (b <= second) {
			if (b % 2 == 0) {
				c = c + b;
				b++;
			} else {
				b++;
				}
			}
		return c;

	}

}