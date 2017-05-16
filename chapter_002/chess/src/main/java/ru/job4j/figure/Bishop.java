package ru.job4j.figure;

import ru.job4j.game.*;

/**.
* Chapter_002
* Task 2.9.2
* Create class Bishop
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Bishop extends Figure {

    /**.
     * Constructor for class Bishop
     * @param cellPosition is position figure
     */
    public Bishop(Cell cellPosition) {
        super(cellPosition);
    }

	/**.
	* Method for check may be way figure
	* @dist finish cell way
	* @return array cell is way figure
	*/
	@Override
	public Cell[] way(Cell dist) throws ImposibleMoveException {

		Board board = new Board();
		Cell[] cell;
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

		if (Math.abs(disRow - srcRow) != Math.abs(disCol - srcCol)) {
			throw new ImposibleMoveException("this figure don't can go to the cell");
		}
		if (Math.abs(disRow - srcRow) == Math.abs(disCol - srcCol)) {
			cell = routing(srcRow, srcCol, disRow, disCol);
		} else {
			throw new ImposibleMoveException("don't right choise");
		}
		return cell;
	}
}