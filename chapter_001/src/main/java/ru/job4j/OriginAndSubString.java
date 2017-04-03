package ru.job4j;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class OriginAndSubString {
	/**.
	* Method for cheking string
	* @param origin string
	* @param sub string
	* @return result
	*/
	public boolean contains(String origin, String sub) {
		char[] originChar = origin.toCharArray();
		char[] subChar = sub.toCharArray();
		int n = 0;
		boolean result = false;
		for (int i = 0; i < originChar.length; i++) {
			if (originChar[i] == subChar[0]) {
				for (int j = 0; j < subChar.length; j++) {
					if (originChar[i + j] == subChar[j]) {
						n = n + 1;
					} else {
						n = 0;
						break;
					}
				}
			}
		}
		if (n == subChar.length) {
			result = true;
		}
		return result;
	}
}