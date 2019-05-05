package ru.job4j;

import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.SECONDS;

/**.
 * Task 7.6.2.
 * Create game Bomberman
 *
 * @author Anton Vasilyuk on 27.09.2017
 * @version 1.0.
 */

public class ActionMonster implements Runnable {

    /**.
     * @monster is monster
     */
    private final Monster monster;

    /**.
     * @board is board
     */
    private final Board board;

    /**.
     * @locationPlayer is location for player
     */
    private final Location locationPlayer;

    /**.
     * @linkEndGame is end game
     */
    private final EndGame linkEndGame;

    /**.
     * Checkpoint for end the game
     */
    private boolean endGame = true;

    /**.
     * Constructor for this class
     * @param monster is link for this player
     * @param board is link for this board
     * @param location is location the player
     * @param linkEndGame is end game
     */
    public ActionMonster(Monster monster, Board board, Location location, EndGame linkEndGame) {
        this.monster = monster;
        this.board = board;
        this.locationPlayer = location;
        this.linkEndGame = linkEndGame;
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
                Location step = monster.step();
                if (step.getX() == locationPlayer.getX() && step.getY() == locationPlayer.getY()) {
                    flag = true;
                    flagSecond = true;
                    System.out.printf("Monster %s caught the player", this.monster.getName());
                    linkEndGame.theEnd();
                }
                try {
                    if (endGame && field[step.getX()][step.getY()].tryLock(5, SECONDS)) {
                        flag = true;
                        flagSecond = true;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (flagSecond) {
                        oldPlace = monster.getPlace();
                        field[oldPlace.getX()][oldPlace.getY()].unlock();
                    }
                }
                if (flagSecond) {
                    monster.newPlace(step);
                    System.out.println(monster);
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
