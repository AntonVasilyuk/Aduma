package ru.job4j;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**.
 * Chapter_003
 * Task 3.1.3
 * Transform collection to array and back
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class ReverseArray {
    /**.
     * Method for modification array to collection
     * @param array it's array for reverse
     * @return collection from array
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

    /**.
     * Method for modification collection to array
     * @param list it's storage
     * @param rows it's count rows
     * @return result
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int longList = list.size();
        int longRowArray;
        if ((longList % rows) != 0) {
            longRowArray = (longList / rows) + 1;
        } else {
            longRowArray = longList / rows;
        }
        int[][] array = new int[rows][longRowArray];
        Iterator<Integer> iter = list.iterator();

        for (int i = 0; i < longRowArray; i++) {
            for (int j = 0; j < longRowArray; j++) {
                if (iter.hasNext()) {
                    array[i][j] = iter.next();
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }

    /**.
     * Method for create List<Integer> from a bunch of array int
     * @param list it's list for converting
     * @return List
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new LinkedList<>();
        for (int[] array: list) {
            for (int a : array) {
                result.add(a);
            }
        }
        return result;
    }
}
