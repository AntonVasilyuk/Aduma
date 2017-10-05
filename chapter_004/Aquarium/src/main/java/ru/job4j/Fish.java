package ru.job4j;

/**.
 * Task 7.6.3.
 * Create Aquarium
 *
 * @author Anton Vasilyuk on 02.10.2017
 * @version 1.0.
 */

public class Fish {

    /**.
     * Is object for determine for direction
     */
    private Direction direction;

    private final int numFish;
    private final long liveFish;
    private final Location location;
    private final String maleOrFemale;

    /**.
     * Constructor for this class
     * @param numFish is number the fish
     * @param liveFish is long live the fish
     * @param male is male the fish
     * @param location is location the fish
     */
    public Fish(int numFish, long liveFish, String male, Location location) {
        this.numFish = numFish;
        this.liveFish = System.currentTimeMillis() + liveFish;
        this.maleOrFemale = male;
        this.location = location;
        this.direction = new Direction(1);
    }

    /**.
     * Is moving the fish
     * @return location the fish
     */
    public Location step() {
        return direction.choiseDirection(location, 1000);
    }

    /**.
     * Getter for number the fish
     * @return number the fish
     */
    public int getNumFish() {return this.numFish;}

    /**.
     * Getter for long livi the fish
     * @return long live the fish
     */
    public long getLiveFish() {return this.liveFish;}

    /**.
     * Getter for male the fish
     * @return male the fish
     */
    public String getMale() {return this.maleOrFemale;}

    /**.
     * Getter for location the fish
     * @return return location the fish
     */
    public Location getLocation() {return this.location;}

    /**.
     * Inicialisation new location the fish
     * @param newLockn new location
     */
    public void newPlace(Location newLockn) {
        location.setPosition(newLockn.getX(), newLockn.getY());
    }
}
