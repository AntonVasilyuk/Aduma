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
     * @param location is location
     * @param max is max location on the board
     * @return new place
     */
    public Location choiseDirection(Location location, int max) {
        int x = location.getX();
        int y = location.getY();
        int width;
        int height;
        Location locon = null;
        Random rd = new Random();
        int randomNumber = rd.nextInt(4);
        if (randomNumber <= 1) {
            if ((x + step) <= max) {
                width = x + step;
                height = y;
                locon = new Location(width, height);
            } else {
                randomNumber += 1;
            }
        }
        if (randomNumber == 2) {
            if ((x - step) >= 0) {
                width = x - step;
                height = y;
                locon = new Location(width, height);
            } else {
                randomNumber += 1;
            }
        }
        if (randomNumber == 3) {
            if ((y + step) <= max) {
                width = x;
                height = y + step;
                locon = new Location(width, height);
            } else {
                randomNumber += 1;
            }
        }
        if (randomNumber == 4) {
            if ((y - step) >= 0) {
                width = x;
                height = y - step;
                locon = new Location(width, height);
            } else {
                locon = choiseDirection(location, max);
            }
        }
        return locon;
    }
}
