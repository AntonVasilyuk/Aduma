package ru.job4j.searcher;

import java.io.File;
import java.util.function.Predicate;

/**.
 * Chapter_007
 * Function for checking by mask
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class FilterMask implements Predicate<File> {

    /**.
     * @mask is mask for checking
     */
    private final String mask;

    /**.
     * Constructor
     * @param mask is mask for checking
     */
    public FilterMask(String mask) {
        this.mask = mask;
    }

    /**.
     * Method for checking file by mask
     * @param file is file for checking
     * @return result checking
     */
    @Override
    public boolean test(File file) {
        return (file.getName().indexOf(mask) > 0);
    }
}
