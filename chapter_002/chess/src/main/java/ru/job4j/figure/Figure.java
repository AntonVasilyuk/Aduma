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

	public Cell[] routing(int srcRow, int srcCol, int disRow, int disCol) {
		int positionRow = 0;
		int positionCol = 0;
		int line = 0;
		if (srcRow == disRow) {line = Math.abs(disCol - srcCol);}
		if (srcCol == disCol) {line = Math.abs(disRow - srcRow);}
		if (Math.abs(disRow - srcRow) == Math.abs(disCol - srcRow)) {line = Math.abs(disRow - srcRow);}
        Cell[] cells = new Cell[line];
		int rMove = disRow > srcRow ? 1 : disRow < srcRow ? -1 : 0;
		int cMove = disCol > srcCol ? 1 : disCol < srcCol ? -1 : 0;
		for (int i = 0; i < line; i++) {
			positionRow = positionRow + rMove;
			positionCol = positionCol + cMove;
			cells[i] = new Cell(positionRow, positionCol);
		}
	return cells;
	}
}