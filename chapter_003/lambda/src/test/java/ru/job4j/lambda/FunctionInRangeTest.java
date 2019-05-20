package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;


/**.
 * Test working method diapason from class FunctionInRange
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 18.05.2019
 */
public class FunctionInRangeTest {

    /**.
     * Method for calculate linear operation with diapason numbers.
     */
    @Test
    public void whenLianerOneToThreeThenLianerOneToThree() {
        FunctionInRange func = new FunctionInRange();
        List<Double> result = func.diapason(1, 3, x -> x);
        Assert.assertThat(result, is(Arrays.asList(1D, 2D, 3D)));
    }

    /**.
     * Method for calculate square operation with diapason numbers
     */
    @Test
    public void whenSquareOneToThreeThenSquareOneToNine() {
        FunctionInRange func = new FunctionInRange();
        List<Double> result = func.diapason(1, 3, x -> Math.pow(x, 2));
        Assert.assertThat(result, is(Arrays.asList(1D, 4D, 9D)));
    }

    /**.
     * Method for calculate logarithmic operation with diapason numbers
     */
    @Test
    public void whenLogarithmicOneToThreeThenLogarithmicOneToNine() {
        FunctionInRange func = new FunctionInRange();
        List<Double> result = func.diapason(1, 3, Math::log);
        Assert.assertThat(result, is(Arrays.asList(0.0, 0.6931471805599453, 1.0986122886681098)));
    }
}