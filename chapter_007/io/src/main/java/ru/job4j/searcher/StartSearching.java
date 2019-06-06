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
     * @params is params for working
     */
    private static final Map<String, String> params = new HashMap<>();

    /**.
     * Is main method this apps
     * @param args is array params
     * @throws ParamsException exception if not set params
     */
    public static void main(String[] args) throws ParamsException {
        for (int i = 0; i < args.length; i += 2) {
            params.put(args[i], args[i + 1]);
        }
        if (!params.containsKey("-d") || !params.containsKey("-o")) {
            throw new ParamsException("Do not set the parameters to source or output");
        }
        Predicate<File> predicate;
        if (params.containsKey("-m")) {
            predicate = new FilterMask(params.get("-m"));
        } else if (params.containsKey("-f")) {
            predicate = new FilterAbsolute(params.get("-f"));
        } else if (params.containsKey("-r")) {
            predicate = new FilterRegex(params.get("-r"));
        } else {
            throw new ParamsException("Do not set the parameters to checking...");
        }
        Searcher searcher = new Searcher();
        List<File> searchedFiles = searcher.files(params.get("-d"), predicate);
        new Writer(params.get("-o")).write(searchedFiles);
    }
}
