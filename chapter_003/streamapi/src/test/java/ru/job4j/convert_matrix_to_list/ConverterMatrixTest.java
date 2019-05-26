package ru.job4j.convert_matrix_to_list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;

/**.
 * Chapter_003
 * Test converting multi-level array to list
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class ConverterMatrixTest {

    /**.
     * Testing working method convert, for conveting multi-level array to list with stream api
     */
    @Test
    public void whenConvertingMultilevelArrayThenGetListNumbers() {
        Integer[][] arrayNumbers = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        List<Integer> result = new ConverterMatrix().convert(arrayNumbers);
        List<Integer> checking = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Assert.assertThat(result, is(checking));
    }
}