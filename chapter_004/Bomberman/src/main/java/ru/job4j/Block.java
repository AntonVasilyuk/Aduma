package ru.job4j;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**.
 * Task 7.6.2.
 * Create game Bomberman
 *
 * @author Anton Vasilyuk on 27.09.2017
 * @version 1.0.
 */

public class Block {

    /**.
     * @count is count blocks
     */
    private final int count;

    /**.
     * @field is field for games
     */
    private final ReentrantLock[][] field;

    /**.
     * Constructor for this class
     * @param difficulty is level difficulty
     * @param field is field the game
     */
    public Block(int difficulty, ReentrantLock[][] field) {
        this.count = difficulty * 2;
        this.field = field;
        choiceLocation();
    }

    /**.
     * Arrangemanet of blocks
     */
    public void choiceLocation() {
        Random rd = new Random(10);
        int x = 0;
        int y = 0;
        for (int i = 0; i < count; i++) {
            boolean flag = false;
            while (!flag) {
                x = rd.nextInt();
                y = rd.nextInt();
                if (field[x][y].tryLock()) {
                    flag = true;
                }
            }
        }
    }
}
