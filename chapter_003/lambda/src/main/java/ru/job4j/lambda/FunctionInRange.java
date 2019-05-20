package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**.
 * A simple function is computed in a range.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 18.05.2019
 */
public class FunctionInRange {

    /**.
     * Functial method for operation with diapason numbers
     * @param start is start number
     * @param finish is finish number
     * @param op is function
     * @return list results
     */
    public List<Double> diapason(int start, int finish, Function<Double, Double> op) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index <= finish; index++) {
            result.add(
                    op.apply((double) index)
            );
        }
        return result;
    }

}
