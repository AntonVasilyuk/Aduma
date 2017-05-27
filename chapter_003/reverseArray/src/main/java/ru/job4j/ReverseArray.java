package ru.job4j;

import java.util.*;
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
     * @param array
     * @return collection from array
     */
    public List<Integer> toList (int[][] array) {
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
     * @param list
     * @param rows
     * @return
     */
    public int[][] toArray (List<Integer> list, int rows) {
        int longList = list.size();
        int longRowArray = (longList / rows) + 1;
        int[][] array = new int[longRowArray][longRowArray];
        Iterator<Integer> iter = list.iterator();

        for (int i = 0; i < longRowArray; i++) {
            for (int j = 0; j < longRowArray; j++) {
                if(iter.hasNext()) {
                    array[i][j] = iter.next();
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}
