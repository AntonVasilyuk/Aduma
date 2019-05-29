package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;
/**.
 * Chapter_003
 * Task_49777
 * Game TicTacToe
 * Class is model for figure
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class Figure3T extends Rectangle {

    /**.
     * @markX the square is occupied X
     */
    private boolean markX = false;

    /**.
     * @markO the square is occupied O
     */
    private boolean markO = false;

    /**.
     * Constructor
     */
    public Figure3T() {
    }

    /**.
     * Constructor
     * @param markX is flag X field
     * @param markO is flag O field
     */
    public Figure3T(boolean markX, boolean markO) {
        this.markX = markX;
        this.markO = markO;
    }

    /**.
     * Set occupied
     * @param markX is flag X
     */
    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**.
     * Check cell
     * @return result checking
     */
    public boolean hasMarkX() {
        return this.markX;
    }

    /**.
     * Check cell
     * @return result checking
     */
    public boolean hasMarkO() {
        return this.markO;
    }
}