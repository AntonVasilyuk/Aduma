package ru.job4j;

public class Location {

    private int xPosition;
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
    public int getX() {return this.xPosition;}

    /**.
     * Getter for y Position
     * @return y
     */
    public int getY() {return this.yPosition;}

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
