package ru.job4j;

import java.util.Date;
import java.util.Map;

/**.
 * Task 7.6.3.
 * Create Aquarium
 *
 * @author Anton Vasilyuk on 05.10.2017
 * @version 1.0.
 */

public class Information implements Runnable {

    /**.
     * @list is list for fishes with location
     */
    private Map<Location, Fish> list;

    /**.
     * @date for print the current date
     */
    private final Date date;

    /**.
     * @end is flag for end the thread
     */
    private boolean endGame = false;

    /**.
     * Constructor
     * @param list is list all fish in the aquarium
     */
    public Information(Map<Location, Fish> list) {
        this.list = list;
        date = new Date();
    }

    /**.
     * Print the current information
     */
    @Override
    public void run() {
        while (!endGame) {
            System.out.printf("In our aquarium is %d fish on %d", list.size(), date.toString());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**.
     * Initialize the expiration of
     */
    public void setEndGame() {
        this.endGame = true;
    }
}
