package ru.job4j;

import java.util.*;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Testing Task 3.4.1
 * Create Directory oragnization
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class DirectoryOrganizationTest {

    /**.
     * Testing method check all organization to array
     */
    @Test
    public void whenArrayNameOrganizationThenCheckAllElement() {
        List<String> list = new ArrayList<>();
        List<String> checkList = new ArrayList<>();
        String one = "K1/SK1";
        String two = "K1/SK2";
        String three = "K1/SK1/SSK1";
        String four = "K1/SK1/SSK2";
        String five = "K2";
        String six = "K2/SK1/SSK1";
        String seven = "K2/SK1/SSK2";
        String eight = "K2/SK1";
        String nine = "K1";
        List<String> asLists = Arrays.asList(one, two, three, four, five, six, seven);
        list = new LinkedList<>();
        list.addAll(asLists);
        checkList.addAll(list);
        checkList.add(eight);
        checkList.add(nine);
        DirectoryOrganization dir = new DirectoryOrganization();
        list = dir.checkOrganization(list);

        boolean expect = true;
        boolean fact = false;
        if (list.containsAll(checkList)) {fact = true;}
        assertThat(fact, is(expect));
    }

    /**.
     * Test method natural sorting array organization
     */
    @Test
    public void whenArrayNameOrganizationThenSortArray() {
        int num = 0;
        int i = 0;

        String one = "K1/SK1";
        String two = "K1/SK2";
        String three = "K1/SK1/SSK1";
        String four = "K1/SK1/SSK2";
        String five = "K2";
        String six = "K2/SK1/SSK1";
        String seven = "K2/SK1/SSK2";
        String eight = "K2/SK1";
        String nine = "K1";
        List<String> asLists = Arrays.asList(one, two, three, four, five, six, seven);
        List<String> list = new LinkedList<>();
        list.addAll(asLists);

        String[] checkList = new String[9];
        checkList[0] = nine;
        checkList[1] = one;
        checkList[2] = three;
        checkList[3] = four;
        checkList[4] = two;
        checkList[5] = five;
        checkList[6] = eight;
        checkList[7] = six;
        checkList[8] = seven;

        DirectoryOrganization dir = new DirectoryOrganization();
        list = dir.sortOrganization(list);
        for (String s : list) {
            if (s.equals(checkList[i++])) {
            } else {num++;}
        }
        boolean expect = true;
        boolean fact = false;
        if (num == 0) {fact = true;}

        assertThat(fact, is(expect));
    }

    /**.
     * Testing reverse sort array organization
     */
    @Test
    public void whenArrayNameOrganizationThenReverseSortArray() {
        List<String> list = new LinkedList<>();
        int num = 0;
        int i = 8;
        String one = "K1/SK1";
        String two = "K1/SK2";
        String three = "K1/SK1/SSK1";
        String four = "K1/SK1/SSK2";
        String five = "K2";
        String six = "K2/SK1/SSK1";
        String seven = "K2/SK1/SSK2";
        String eight = "K2/SK1";
        String nine = "K1";

        List<String> asLists= Arrays.asList(one, two, three, four, five, six, seven);
        list.addAll(asLists);
        String[] checkList = new String[9];
        checkList[0] = nine;
        checkList[1] = one;
        checkList[2] = three;
        checkList[3] = four;
        checkList[4] = two;
        checkList[5] = five;
        checkList[6] = eight;
        checkList[7] = six;
        checkList[8] = seven;

        DirectoryOrganization dir = new DirectoryOrganization();
        list = dir.reverseSortOrganization(list);
        for (String s : list) {
            if (s.equals(checkList[i--])) {
            } else {num++;}
        }
        boolean expect = true;
        boolean fact = false;
        if (num == 0) {fact = true;}
        assertThat(fact, is(expect));
    }
}

