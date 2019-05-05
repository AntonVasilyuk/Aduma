package ru.job4j;

import java.util.Map;
import java.util.Random;

/**.
 * Task 7.6.3.
 * Create Aquarium
 *
 * @author Anton Vasilyuk on 02.10.2017
 * @version 1.0.
 */

public class Location {

    /**.
     * @xPosition is x coordinate
     */
    private int xPosition;

    /**.
     * @yPosition is y coordinate
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

    /**.
     * Change location for the fish
     * @param sizeCoordinate is max coordinate
     * @param list is list all fish
     * @return new location
     */
    public Location newLocation(int sizeCoordinate, Map<Location, Fish> list) {
        Random rd = new Random(sizeCoordinate);
        Location location = null;
        boolean flag = true;
        while (flag) {
            location = new Location(rd.nextInt(), rd.nextInt());
            if (list.get(location) == null) {
                flag = false;
            }
        }
        return location;
    }
}
