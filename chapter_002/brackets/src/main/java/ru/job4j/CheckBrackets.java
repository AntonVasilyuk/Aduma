package ru.job4j;

/**.
* Chapter_002
* Extra task
* Check validate brackets
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class CheckBrackets {

	/**.
	* It's method for check brackets
	* @param brackets is array brackets
	* @return result
	*/
	public boolean checkBreckets(char[] brackets) {
		boolean result = true;

		char a = '(';
		char b = ')';

		int aNum = 0;
		for (int index = 0; index < brackets.length; index++) {
			if (brackets[index] == a) {
				aNum++;
			}
			if (brackets[index] == b) {
				aNum--;
			}
			if (aNum < 0) {
			result = false;
			break;
			}
		}
		if (aNum != 0) {
			result = false;
		}
		return result;
	}
}