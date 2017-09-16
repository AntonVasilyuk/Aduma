package ru.job4j;

/**.
 * Task 7.6.2.
 * Create game Bomberman
 *
 * @author Anton Vasilyuk on 04.09.2017
 * @version 1.0.
 */

public class Player implements Figure {

    /**.
     * @name is name this figure
     */
    private String name;

    /**.
     * @x is location the figure
     */
    private int x;

    /**.
     * @y is location the figure
     */
    private int y;

    /**.
     * @max is max x or y
     */
    private int max;

    /**.
     * @sizeStep is max step for this figure
     */
    private final int sizeStep;

    /**.
     * @direction is object for search direction
     */
    private Direction direction;

    /**.
     * Constructor for this class
     * @param name is name this figure
     * @param sizeStep is max step for this figure
     * @param max is max step for this figure
     */
    public Player(String name, int sizeStep, int max) {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.max = max;
        this.sizeStep = sizeStep;
        this.direction = new Direction(sizeStep);
    }

    /**.
     * Method for moving figure
     * @return
     */
    public int[] step() {
        int[] way = direction.choiseDirection(x, y, max);
        this.x = way[0];
        this.y = way[1];
        return way;
    }

    /**.
     * Overwrite new location
     * @param x
     * @param y
     */
    public void newPlace(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**.
     * Rerurn old location
     * @return array with x and y ola location
     */
    public int[] getPlace() {
        int[] place = {this.x, this.y};
        return place;
    }

    /**.
     * Method for description action the figure
     * @return String
     */
    public String toString() {
        return "Player navigates to a cell " + this.x + ", " + this.y;
    }
}

