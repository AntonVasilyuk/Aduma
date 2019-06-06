package ru.job4j.searcher;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**.
 * Chapter_007
 * Task 10.1.2.
 * Edit text in the input stream
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class StartSearching {

    /**.
     * @params is PARAMS for working
     */
    private static final Map<String, String> PARAMS = new HashMap<>();

    /**.
     * Is main method this apps
     * @param args is array PARAMS
     * @throws ParamsException exception if not set PARAMS
     */
    public static void main(String[] args) throws ParamsException {
        for (int i = 0; i < args.length; i += 2) {
            PARAMS.put(args[i], args[i + 1]);
        }
        if (!PARAMS.containsKey("-d") || !PARAMS.containsKey("-o")) {
            throw new ParamsException("Do not set the parameters to source or output");
        }
        Predicate<File> predicate;
        if (PARAMS.containsKey("-m")) {
            predicate = new FilterMask(PARAMS.get("-m"));
        } else if (PARAMS.containsKey("-f")) {
            predicate = new FilterAbsolute(PARAMS.get("-f"));
        } else if (PARAMS.containsKey("-r")) {
            predicate = new FilterRegex(PARAMS.get("-r"));
        } else {
            throw new ParamsException("Do not set the parameters to checking...");
        }
        Searcher searcher = new Searcher();
        List<File> searchedFiles = searcher.files(PARAMS.get("-d"), predicate);
        new Writer(PARAMS.get("-o")).write(searchedFiles);
    }
}
