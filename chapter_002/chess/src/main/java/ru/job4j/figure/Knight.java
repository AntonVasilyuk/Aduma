package ru.job4j.figure;

import ru.job4j.game.*;

/**.
* Chapter_002
* Task 2.9.2
* Create class Knight
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Knight extends Figure {

    /**.
     * Constructor for class Knight
     * @param cellPosition is position figure
     */
    public Knight(Cell cellPosition) {
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
		Cell[] cell = new Cell[1];
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

		if (disRow == srcRow + 2 && disCol == srcCol - 1) {
			cell[0] = new Cell(disRow, disCol);
		} else if (disRow == srcRow + 2 && disCol == srcCol + 1) {
			cell[0] = new Cell(disRow, disCol);
		} else if (disRow == srcRow + 1 && disCol == srcCol + 2) {
			cell[0] = new Cell(disRow, disCol);
		} else if (disRow == srcRow - 1 && disCol == srcCol + 2) {
			cell[0] = new Cell(disRow, disCol);
		} else if (disRow == srcRow - 2 && disCol == srcCol + 1) {
			cell[0] = new Cell(disRow, disCol);
		} else if (disRow == srcRow - 2 && disCol == srcCol - 1) {
			cell[0] = new Cell(disRow, disCol);
		} else if (disRow == srcRow + 1 && disCol == srcCol - 2) {
			cell[0] = new Cell(disRow, disCol);
		} else if (disRow == srcRow - 1 && disCol == srcCol - 2) {
			cell[0] = new Cell(disRow, disCol);
		} else {
			throw new ImposibleMoveException("incorrect choise cell");
		}
		return cell;
	}
}