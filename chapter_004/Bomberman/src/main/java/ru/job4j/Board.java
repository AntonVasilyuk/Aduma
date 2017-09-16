package ru.job4j;

import java.util.concurrent.locks.ReentrantLock;

/**.
 * Task 7.6.2.
 * Create game Bomberman
 *
 * @author Anton Vasilyuk on 04.09.2017
 * @version 1.0.
 */

public class Board {

    /**.
     * @SIZEBOARD is max size the board
     */
    private static final int SIZEBOARD = 10;

    /**.
     * @board is link for our board
     */
    private final ReentrantLock[][] board;

    /**.
     * @bomber is our main figure
     */
    private final Player bomber;

    /**.
     * @endGame is flag for end game
     */
    private boolean endGame = true;

    /**.
     * Constructor for this class
     */
    public Board() {
        board = new ReentrantLock[SIZEBOARD][SIZEBOARD];
        for(int i = 0; i < SIZEBOARD; i++) {
            for (int j = 0; j < SIZEBOARD; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
        bomber = new Player("Gosha", 1, SIZEBOARD);
    }

    /**.
     * Getter for our field
     */
    public ReentrantLock[][] getBoard() {
        return this.board;
    }
}
