package ru.job4j.createZipFile;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for check argumets.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 04.03.2019
 */

public class CheckArguments {

    /**.
     * It's logger
     */
    private static final Logger LOG = Logger.getLogger(CheckArguments.class.getName());

    /**.
     * Inner argumets
     */
    private final String[] listArguments;

    /**.
     * It's path dir for archiving
     */
    private String rootPath;

    /**.
     * It's name for archive
     */
    private String nameArchive;

    /**.
     * It's list for type files for adding to archive
     */
    private List<String> extense;

    /**.
     * Constructor for this class
     * @param arg
     */
    public CheckArguments(String[] arg) {
        this.listArguments = arg;
    }

    /**.
     * Verification and processing arguments
     * @return result checking
     */
    public boolean getArgumets() {
        if (listArguments.length == 6) {
            for (int i = 0; i < listArguments.length; i += 2) {
                if ((listArguments[i] == null || listArguments[i].equals("")) || (!listArguments[i].equals("-d") &&
                        !listArguments[i].equals("-o") && !listArguments[i].equals("-e"))) {
                    LOG.error("Uncorrect argumetns");
                    return false;
                }

            }
            setArgs(listArguments);
            return true;
        }
        return false;
    }

    /**.
     * Set verificated argumets
     * @param args
     */
    private void setArgs(String[] args) {
        for(int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-d")) rootPath = args[i + 1];
            if (args[i].equals("-o")) nameArchive = args[i + 1];
            if (args[i].equals("-e")) {
                extense = Arrays.stream(args[++i].split(",")).collect(Collectors.toList());
            }
        }
    }

    /**.
     * Getter for root
     * @return
     */
    public String getRootPath() {
        return rootPath;
    }

    /**.
     * Getter for name archive
     * @return
     */
    public String getNameArchive() {
        return nameArchive;
    }

    /**.
     * Getter for extense
     * @return
     */
    public List<String> getExtense() {
        return extense;
    }
}
