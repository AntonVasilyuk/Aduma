package ru.job4j;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
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
        String one = "K1/SK1";
        String two = "K1/SK2";
        String three = "K1/SK1/SSK1";
        String four = "K1/SK1/SSK2";
        String five = "K2";
        String six = "K2/SK1/SSK1";
        String seven = "K2/SK1/SSK2";
        String eight = "K2/SK1";
        String nine = "K1";
        List<String> asLists = List.of(one, two, three, four, five, six, seven);
        List<String> list = new LinkedList<>();
        list.addAll(asLists);
        List<String> checkList = List.of(one, two, three, four, five, six, seven, eight, nine);
        DirectoryOrganization dir = new DirectoryOrganization();
        list = dir.checkOrganization(list);
        boolean expect = true;
        boolean fact = false;
        if (list.containsAll(checkList)) {
            fact = true;
        }
        assertThat(fact, is(expect));
    }

    /**.
     * Test method natural sorting array organization
     */
    @Test
    public void whenArrayNameOrganizationThenSortArray() {
        int num = 0;
        String one = "K1/SK1";
        String two = "K1/SK2";
        String three = "K1/SK1/SSK1";
        String four = "K1/SK1/SSK2";
        String five = "K2";
        String six = "K2/SK1/SSK1";
        String seven = "K2/SK1/SSK2";
        List<String> asLists = List.of(one, two, three, four, five, six, seven);
        List<String> list = new LinkedList<>();
        list.addAll(asLists);

        List<String> checkListOne = List.of("K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2",
                "K1/SK2", "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2");
        DirectoryOrganization dir = new DirectoryOrganization();
        Iterator<String> checkIt = checkListOne.iterator();
        list = dir.sortOrganization(list);
        for (String s : list) {
            if (!s.equals(checkIt.next())) {
                num++;
            }
        }
        boolean expect = true;
        boolean fact = false;
        if (num == 0) {
            fact = true;
        }

        assertThat(fact, is(expect));
    }

    /**.
     * Testing reverse sort array organization
     */
    @Test
    public void whenArrayNameOrganizationThenReverseSortArray() {
        List<String> list = new LinkedList<>();
        int num = 0;
        String one = "K1/SK1";
        String two = "K1/SK2";
        String three = "K1/SK1/SSK1";
        String four = "K1/SK1/SSK2";
        String five = "K2";
        String six = "K2/SK1/SSK1";
        String seven = "K2/SK1/SSK2";

        List<String> asLists = List.of(one, two, three, four, five, six, seven);
        list.addAll(asLists);
        List<String> checkListOne = List.of("K2/SK1/SSK2", "K2/SK1/SSK1", "K2/SK1", "K2",
                "K1/SK2", "K1/SK1/SSK2", "K1/SK1/SSK1", "K1/SK1", "K1");
        Iterator<String> checkIt = checkListOne.iterator();
        DirectoryOrganization dir = new DirectoryOrganization();
        list = dir.reverseSortOrganization(list);
        for (String s : list) {
            if (!s.equals(checkIt.next())) {
                num++;
            }
        }
        boolean expect = true;
        boolean fact = false;
        if (num == 0) {
            fact = true;
        }
        assertThat(fact, is(expect));
    }
}

