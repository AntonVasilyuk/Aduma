package ru.job4j.searcher;

import java.io.File;
import java.util.function.Predicate;

/**.
 * Chapter_007
 * Function for checking by absolute name
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class FilterAbsolute implements Predicate<File> {

    /**.
     * @absoluteName is absolute name for checking the file
     */
    private final String absoluteName;

    /**.
     * Constructor
     * @param absoluteName is absolute name
     */
    public FilterAbsolute(String absoluteName) {
        this.absoluteName = absoluteName;
    }

    /**.
     * Checking file by absolute name
     * @param file is file for checking
     * @return result checking
     */
    @Override
    public boolean test(File file) {
        String name = file.getName();
        return name.substring(0, name.indexOf('.')).equals(absoluteName);
    }
}
