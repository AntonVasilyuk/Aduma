package ru.job4j.searcher;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;

/**.
 * Chapter_007
 * Searching all files by mask
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class Searcher {

    /**.
     * It's list for keeping files for result
     */
    private List<File> validedFiles = new LinkedList<>();

    /**.
     * It's queue for keeping checking files
     */
    private Queue<File> folders = new LinkedList<>();

    /**.
     * Method for searching need files
     * @param parent it's root path
     * @param checker function for checking
     * @return list searched files
     */
    public List<File> files(String parent, Predicate<File> checker) {
        File sourse = new File(parent);
        if (sourse.isDirectory()) {
            folders.add(sourse);
        } else {
            if (checker.test(sourse)) {
                validedFiles.add(sourse);
            }
            return validedFiles;
        }
        do {
            sourse = folders.poll();
            if (sourse.isDirectory()) {
                toQueue(sourse);
            } else {
                if (checker.test(sourse)) {
                    validedFiles.add(sourse);
                }
            }
        } while (!folders.isEmpty());
        return validedFiles;
    }

    /**.
     * It's method for adding inner folder to queue for checking
     * @param sourse is sourse
     */
    public void toQueue(File sourse) {
        for (File file : sourse.listFiles()) {
            folders.add(file);
        }
    }
}
