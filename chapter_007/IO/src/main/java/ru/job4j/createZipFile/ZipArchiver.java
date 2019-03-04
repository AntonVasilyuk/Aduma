package ru.job4j.createZipFile;

import org.apache.log4j.Logger;

/**
 * Main class for start app.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 04.03.2019
 */

public class ZipArchiver {

    /**.
     * Logger for this class
     */
    public static final Logger LOG = Logger.getLogger(ZipArchiver.class.getName());

    /**.
     * Start app
     * @param args
     */
    public static void main(String[] args) {
        CheckArguments checker = new CheckArguments(args);
        if (checker.getArgumets()) {
            ZipWork zip = new ZipWork(checker.getRootPath(), checker.getNameArchive(), checker.getExtense());
            zip.doZip();
        }
    }
}
