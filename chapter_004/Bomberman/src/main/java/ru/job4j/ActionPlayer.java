package ru.job4j;

import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**.
 * Task 7.6.2.
 * Create game Bomberman
 *
 * @author Anton Vasilyuk on 04.09.2017
 * @version 1.0.
 */

public class ActionPlayer implements Runnable {

    private final Player bomber;
    private final Board board;

    /**.
     * Checkpoint for end the game
     */
    private boolean endGame = true;

    /**.
     * Constructor for this class
     * @param player is link for this player
     * @param board is link for this board
     */
    public ActionPlayer(Player player, Board board) {
        this.bomber = player;
        this.board = board;
    }

    /**.
     * Action for thread
     */
    @Override
    public void run() {
        boolean flag;
        Location oldPlace;
        ReentrantLock[][] field = board.getBoard();
        while (endGame) {
            flag = false;
            while (!flag) {
                boolean flagSecond = false;
                Location step = bomber.step();
                try {
                    if(field[step.getX()][step.getY()].tryLock(500, MILLISECONDS)) {
                        flag = true;
                        flagSecond = true;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if(flagSecond) {
                        oldPlace = bomber.getPlace();
                        field[oldPlace.getX()][oldPlace.getY()].unlock();
                    }
                }
                if(flagSecond) {
                    bomber.newPlace(step);
                    System.out.println(bomber);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**.
     * Set flag endGame
     */
    public void setEndGame() {
        this.endGame = false;
    }
}
