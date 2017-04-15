package ru.job4j;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class SortMyNumber {
	/**.
	* Method for sort Two array
	* @param first array
	* @param second array
	* @return result sorting
	*/
	public int[] sortMyArrays(int[] first, int[] second) {
		int i = 0;
		int j = 0;
		int[] readyArray = new int[first.length + second.length];
		while (i < first.length || j < second.length) {
			if (i < first.length && j < second.length) {
				readyArray[i + j] = first[i] < second[j] ? first[i++] : second[j++];
			} else if (i == first.length) {
				readyArray[i + j] = second[j++];
			} else {
				readyArray[i + j] = first[i++];
			}
		}
        return readyArray;
    }
}