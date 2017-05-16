package ru.job4j.figure;

import ru.job4j.game.*;

/**.
* Chapter_002
* Task 2.9.2
* Create class Castl
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Castl extends Figure {

    /**.
     * Constructor for class Castl
     * @param cellPosition is position figure
     */
    public Castl(Cell cellPosition) {
        super(cellPosition);
    }

    /**.
     * Method for check validate way this figure
     * @param cell point
     * @return array from cell
     */
    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {

        Board board = new Board();
        Cell[] cells;
        board.fillFigure();

        int srcRow = this.cellPosition.getRow();
        int srcCol = this.cellPosition.getCol();
        int disRow = dist.getRow();
        int disCol = dist.getCol();

        if (srcRow == disRow && srcCol == disCol) {
			throw new ImposibleMoveException("It cell is busy, make outher choice");
        }
        if (disRow > 7 || disRow < 0 || disCol > 7 || disCol < 0) {
            throw new ImposibleMoveException("incorrect choice, change outher cell");
        }

		if (srcRow == disRow || srcCol == disCol) {
			cells = routing(srcRow, srcCol, disRow, disCol);
		} else {
			throw new ImposibleMoveException("don't right choise");
		}
		return cells;
	}
}