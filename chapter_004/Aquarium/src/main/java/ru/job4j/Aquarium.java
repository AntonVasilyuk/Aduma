package ru.job4j;

import java.util.concurrent.locks.ReentrantLock;

/**.
 * Task 7.6.3.
 * Create Aquarium
 *
 * @author Anton Vasilyuk on 02.10.2017
 * @version 1.0.
 */

public class Aquarium {

    /**.
     * @SIZEBOARD is max size the board
     */
    private static final int SIZEBOARD = 10000;

    /**.
     * @board is link for our board
     */
    private final ReentrantLock[][] world;

    /**.
     * @endGame is flag for end game
     */
    private boolean endGame = true;

    /**.
     * Constructor for this class
     */
    public Aquarium() {
        world = new ReentrantLock[SIZEBOARD][SIZEBOARD];
        for (int i = 0; i < SIZEBOARD; i++) {
            for (int j = 0; j < SIZEBOARD; j++) {
                world[i][j] = new ReentrantLock();
            }
        }
    }

    /**.
     * Getter for our field
     * @return array locks
     */
    public ReentrantLock[][] getWorld() {
        return this.world;
    }
}
