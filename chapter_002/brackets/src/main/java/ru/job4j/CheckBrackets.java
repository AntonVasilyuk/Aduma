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
		int bNum = 0;
	
		for (int index = 0; index < brackets.length; index++) {
			if (brackets[index] == a) {
				aNum++;
			}
			if (aNum < bNum) {
			result = false;
			break;
			}
			if (brackets[index] == b) {
				bNum++;
			}
			if (aNum < bNum) {
			result = false;
			break;
			}
		}
		return result;
	}
}