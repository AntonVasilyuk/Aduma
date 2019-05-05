package ru.job4j.searchfiles;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class for searching files.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 27.03.2019
 */

public class SearchFiles {

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
     * @param exts it's extension for files
     * @return list searched files
     */
    public List<File> files(String parent, List<String> exts) {
        File sourse = new File(parent);
        if (sourse.isDirectory()) {
            folders.add(sourse);
        } else {
            if (checkFile(sourse, exts)) {
                validedFiles.add(sourse);
            }
            return validedFiles;
        }
        do {
            sourse = folders.poll();
            if (sourse.isDirectory()) {
                toQueue(sourse);
            } else {
                if (checkFile(sourse, exts)) {
                    validedFiles.add(sourse);
                }
            }
        } while (!folders.isEmpty());
        return validedFiles;
    }

    /**.
     * Method for checking files
     * @param file is file for checking
     * @param listEnds is info for checking
     * @return result checking true or false
     */
    public boolean checkFile(File file, List<String> listEnds) {
        return listEnds.stream().anyMatch(s -> file.getName().endsWith(s));
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
