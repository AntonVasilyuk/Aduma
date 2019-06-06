package ru.job4j.searcher;

/**.
 * Chapter_007
 * Exception if no correct params
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class ParamsException extends Exception {

    /**.
     * Constructor exception
     * @param message message for exception
     */
    public ParamsException(String message) {
        super(message);
    }
}
