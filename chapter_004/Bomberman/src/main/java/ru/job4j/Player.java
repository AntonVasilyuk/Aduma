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
     * @locationPlayer is location the figure
     */
    private final Location locationPlayer;

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
        this.locationPlayer = new Location(0, 0);
        this.max = max;
        this.sizeStep = sizeStep;
        this.direction = new Direction(sizeStep);
    }

    /**.
     * Method for moving figure
     * @return
     */
    public Location step() {
        return direction.choiseDirection(locationPlayer, max);
    }

    /**.
     * Overwrite new location
     * @param location is new location player
     */
    public void newPlace(Location location) {
        this.locationPlayer.setPosition(location.getX(), location.getY());
    }

    /**.
     * Rerurn old location
     * @return array with x and y ola location
     */
    public Location getPlace() {
        return locationPlayer;
    }

    /**.
     * Method for description action the figure
     * @return String
     */
    public String toString() {
        return "Player navigates to a cell " + this.locationPlayer.getX() + ", " + this.locationPlayer.getY();
    }
}

