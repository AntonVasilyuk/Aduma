package ru.job4j;

/**.
 * Task 7.5.1.
 * Create my realisation non blocking cash
 *
 * @author Anton Vasilyuk on 31.08.2017
 * @version 1.0.
 */

public class OptimisticException extends RuntimeException {

    /**.
     * Constructor for our Exception
     * @param msg is massage when return our exception
     */
    public OptimisticException(String msg) {
        super(msg);
    }
}
