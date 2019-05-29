package ru.job4j.matrixtolist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**.
 * Chapter_003
 * Converting multi-level array to list
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class ConverterMatrix {

    /**.
     * Method for converting
     * @param matrix is array
     * @return list numbers
     */
    public List<Integer> convert(Integer[][] matrix) {
        List<Integer> list = Stream.of(matrix).flatMap(x -> Stream.of(x)).collect(Collectors.toList());
        return list;
    }
}
