package ru.job4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

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
     * Main action for this game
     */
    public void action() {
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.submit(new Runnable() {
            @Override
            public void run() {
                boolean flag;
                int[] oldPlace;
                while (endGame) {
                    flag = false;
                    while (!flag) {
                        int[] step = bomber.step();
                        try {
                            if (board[step[0]][step[1]].tryLock(500, MILLISECONDS)) {
                                flag = true;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            oldPlace = bomber.getPlace();
                            board[oldPlace[0]][oldPlace[1]].unlock();
                        }
                        bomber.newPlace(step[0], step[1]);
                        System.out.println(bomber);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**.
     * Set flag endGame
     */
    public void setEndGame() {
        this.endGame = false;
    }
}
