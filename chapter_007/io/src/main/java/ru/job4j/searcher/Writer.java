package ru.job4j.searcher;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**.
 * Chapter_007
 * Writing searched files to output file
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class Writer {

    /**.
     * Logger for class writer
     */
    public static final Logger LOGGER = Logger.getLogger(Writer.class);

    /**.
     * @file is output file
     */
    private File file;

    /**.
     * Constructor for this class
     * @param fileName is file name for output file
     */
    public Writer(String fileName) {
        this.file = new File(fileName);
        checkFileOutput();

    }

    /**.
     * Writing all name searched files to output file
     * @param list is list files
     */
    public void write(List<File> list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            list.stream().forEach(s -> writer.write(s.getName() + "\n"));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**.
     * Creating file if not exist
     */
    private void checkFileOutput() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
