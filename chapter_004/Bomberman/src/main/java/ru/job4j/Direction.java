package ru.job4j;

import java.util.Random;

/**.
 * Task 7.6.2.
 * Create game Bomberman
 *
 * @author Anton Vasilyuk on 04.09.2017
 * @version 1.0.
 */

public class Direction {

    /**.
     * @step is size step
     */
    private final int step;

    /**.
     * Constructor for this class
     * @param step is size step
     */
    public Direction(int step) {
        this.step = step;
    }

    /**.
     * Searching direction for moving
     * @param x is old x
     * @param y is old y
     * @param max is max location on the board
     * @return new place
     */
    public int[] choiseDirection(int x, int y, int max) {
        int width;
        int height;
        int[] dirct = null;
        Random rd = new Random();
        int randomNumber = rd.nextInt(40);
        if(randomNumber <= 10) {
            if((x + step) <= max) {
                width = x + step;
                height = y;
                dirct = new int[]{width, height};
            } else {randomNumber += 10;}
        }
        if(randomNumber > 10 && randomNumber <= 20) {
            if((x - step) >= 0) {
                width = x - step;
                height = y;
                dirct = new int[]{width, height};
            } else {randomNumber += 10;}
        }
        if(randomNumber > 20 && randomNumber <= 30) {
            if ((y + step) <= max) {
                width = x;
                height = y + step;
                dirct = new int[]{width, height};
            } else {randomNumber += 10;}
        }
        if(randomNumber > 30 && randomNumber <= 40) {
            if((y - step) >= 0) {
                width = x;
                height = y - step;
                dirct = new int[]{width, height};
            } else {
                dirct = choiseDirection(x, y, max);
            }
        }
        return dirct;
    }
}
