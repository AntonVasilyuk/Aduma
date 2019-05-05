package ru.job4j;

import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Collections;

/**.
 * Testing Task 3.4.1
 * Create Directory oragnization
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class DirectoryOrganization {

    /**.
     * Check organisation directories
     * @param list list words
     * @return result
     */
    public List<String> checkOrganization(List<String> list) {
        Set<String> addString = new LinkedHashSet<>();
        int num = 0;

        String[] tmp;
        String[] tmpOne;
        String checkWord = "";

        for (String s : list) {
            tmp = s.split("/");
            if (tmp.length > 1) {
                tmpOne = Arrays.copyOf(tmp, tmp.length - 1);
                for (int i = 0; i < tmpOne.length; i++) {
                    checkWord += tmpOne[i];
                    if (i != tmpOne.length - 1) {
                        checkWord += "/";
                    }
                }

                ListIterator<String> iter = list.listIterator();

                while (iter.hasNext()) {
                    String p = iter.next();
                    if (p.equals(checkWord)) {
                        num++;
                    }
                }

                if (num == 0) {
                    addString.add(checkWord);
                }
                checkWord = "";
                num = 0;
            }
        }
        list.addAll(addString);
        return list;
    }

    /**.
     * Method for setting organisation
     * @param list is inner data
     * @return result
     */
    public List<String> sortOrganization(List<String> list) {
        List<String> result;
        result = checkOrganization(list);
        Collections.sort(result, (o1, o2) -> o1.compareTo(o2));

        return result;
    }

    /**.
     * Method for reverse sorting
     * @param list inner data
     * @return result
     */
    public List<String> reverseSortOrganization(List<String> list) {
        List<String> result;
        result = checkOrganization(list);
        Collections.sort(result, (o1, o2) -> o2.compareTo(o1));

        return result;
    }
}
