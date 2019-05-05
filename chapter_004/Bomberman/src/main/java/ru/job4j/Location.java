package ru.job4j;

/**.
 * Task 7.6.2.
 * Create game Bomberman
 *
 * @author Anton Vasilyuk on 04.09.2017
 * @version 1.0.
 */

public class Location {

    /**.
     * @xPosition x coordinate
     */
    private int xPosition;

    /**.
     * @yPosition y coordinate
     */
    private int yPosition;

    /**.
     * Constructor for this class
     * @param x is location
     * @param y is location
     */
    public Location(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    /**.
     * Getter for x Position
     * @return x
     */
    public int getX() {
        return this.xPosition;
    }

    /**.
     * Getter for y Position
     * @return y
     */
    public int getY() {
        return this.yPosition;
    }

    /**.
     * Method for change of location
     * @param x is new location
     * @param y is new location
     */
    public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }
}
