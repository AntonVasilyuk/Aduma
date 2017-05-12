package ru.job4j.game;

import ru.job4j.figure.*;

/**.
* Chapter_002
* Task 2.9.2
* Interface for create figure
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Cell {

    /**.
     * @rowCell row board
     */
    private int rowCell;

    /**.
     * @colCell column board
     */
    private int colCell;

    /**.
     * Constructor for class Cell
     * @param rowCell row this cell on the board
     * @param colCell column this cell on the board
     */
    public Cell(int rowCell, int colCell) {
        this.rowCell = rowCell;
        this.colCell = colCell;
    }

    /**.
     * Method getter row the cell
     * @return row the cell
     */
    public int getRow() {
        return this.rowCell;
    }

    /**.
     * Method getter row the cell
     * @return row the cell
     */
    public int getCol() {
        return this.colCell;
    }
}
