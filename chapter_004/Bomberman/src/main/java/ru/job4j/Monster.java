package ru.job4j;

/**.
 * Task 7.6.2.
 * Create game Bomberman
 *
 * @author Anton Vasilyuk on 27.09.2017
 * @version 1.0.
 */

public class Monster implements Figure{

    /**.
     * @name is name this figure
     */
    private String name = "Monster";

    /**.
     * @locationPlayer is location the figure
     */
    private final Location locationMonster;

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
     * @param numMonster is count of the monsters
     * @param sizeStep is max size step the monsters
     * @param max is size field
     */
    public Monster(int numMonster, int sizeStep, int max) {
        this.name = this.name + numMonster;
        this.locationMonster = new Location(0, 0);
        this.max = max;
        this.sizeStep = sizeStep;
        this.direction = new Direction(sizeStep);
    }

    /**.
     * Step the monster
     * @return new location
     */
    @Override
    public Location step() {
        direction.choiseDirection(locationMonster, max);
        return this.locationMonster;
    }


    /**.
     * Overwrite new location
     * @param location is new location player
     */
    public void newPlace(Location location) {
        this.locationMonster.setPosition(location.getX(), location.getY());
    }

    /**.
     * Rerurn old location
     * @return array with x and y ola location
     */
    public Location getPlace() {
        return locationMonster;
    }

    /**.
     * Method getter for name
     */
    public String getName() {return this.name;}

    /**.
     * Method for description action the figure
     * @return String is text for print
     */
    public String toString() {
        return "Monster navigates to a cell " + this.locationMonster.getX() + ", " + this.locationMonster.getY();
    }
}
