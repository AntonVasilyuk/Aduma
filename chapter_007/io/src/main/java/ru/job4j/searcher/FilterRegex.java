package ru.job4j.searcher;

import java.io.File;
import java.util.function.Predicate;

/**.
 * Chapter_007
 * Function for checking by regex
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class FilterRegex implements Predicate<File> {

    /**.
     * @regex is regex
     */
    private final String regex;

    /**.
     * Constructor for class FilterRegex
     * @param regex is regex
     */
    public FilterRegex(String regex) {
        this.regex = regex;
    }

    /**.
     * Method for checking
     * @param file is file for checking
     * @return result checking
     */
    @Override
    public boolean test(File file) {
        return file.getName().substring(0, file.getName().indexOf(".")).matches(regex);
    }
}