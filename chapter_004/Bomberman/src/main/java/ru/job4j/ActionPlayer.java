package ru.job4j;

import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

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
        int[] oldPlace;
        ReentrantLock[][] field = board.getBoard();
        while (endGame) {
            flag = false;
            while (!flag) {
                int[] step = bomber.step();
                try {
                    if (field[step[0]][step[1]].tryLock(500, MILLISECONDS)) {
                        flag = true;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    oldPlace = bomber.getPlace();
                    field[oldPlace[0]][oldPlace[1]].unlock();
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

    /**.
     * Set flag endGame
     */
    public void setEndGame() {
        this.endGame = false;
    }
}
