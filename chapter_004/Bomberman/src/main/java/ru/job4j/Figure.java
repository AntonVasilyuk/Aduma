package ru.job4j;

/**.
 * Task 7.6.2.
 * Create game Bomberman
 *
 * @author Anton Vasilyuk on 04.09.2017
 * @version 1.0.
 */

public interface Figure {

    /**.
     * This method moving figure
     * @return direction
     */
    public Location step();
}
