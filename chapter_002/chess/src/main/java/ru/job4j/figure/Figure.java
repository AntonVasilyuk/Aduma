package ru.job4j.figure;

import ru.job4j.game.*;

/**.
* Chapter_002
* Task 2.9.2
* Interface for create figure
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public abstract class Figure {


    /**.
     * @cellPosition cellPosition the sell
     */
    protected final Cell cellPosition;

    /**.
     * Constructor
     * @param cellPosition is cell for new figure
     */
    public Figure(Cell cellPosition){
        this.cellPosition = cellPosition;
    }

    /**.
     * Getter for this cellPosition
     */
    public Cell getCell() {
        return this.cellPosition;
    }

    /**.
     * Abstract method building way for the figure
     * @param dist finish point
     * @return way array cells
     */
    public abstract Cell[] way(Cell dist) throws ImposibleMoveException;

}