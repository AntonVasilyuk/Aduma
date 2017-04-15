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
		int val;
		int[] a;
		int[] b;
		int[] readyArray = new int[first.length + second.length];
		if (first.length >= second.length) {
			a = first;
			b = second;
		} else {
			a = second;
			b = first;
		}
        for (int j = readyArray.length - 1, i = 0; j >= 0; j--, i++) {
            if (i < b.length) {
                readyArray[j] = a[i];
                readyArray[j - 1] = b[i];
                for (int x = 0; x < readyArray.length; x++) {
                    for (int y = readyArray.length - 1; y > x; y--) {
                        if (readyArray[y] < readyArray[y - 1]) {
                            val = readyArray[y];
                            readyArray[y] = readyArray[y - 1];
                            readyArray[y - 1] = val;
                        }
                    }
                }
                j--;
            } else {
                readyArray[j] = a[i];
                for (int x = 0; x < readyArray.length; x++) {
                    for (int y = readyArray.length - 1; y > x; y--) {
                        if (readyArray[y] < readyArray[y - 1]) {
                            val = readyArray[y];
                            readyArray[y] = readyArray[y - 1];
                            readyArray[y - 1] = val;
                        }
                    }
                }
            }
        }
        return readyArray;
    }
}