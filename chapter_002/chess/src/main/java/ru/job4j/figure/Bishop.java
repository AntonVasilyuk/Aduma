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
     * Method for check validate way this figure
     * @param cell point
     * @return array from cell
     */
    @Override
    public Cell[] way(Cell cell) throws ImposibleMoveException {

        Board board = new Board();
        Cell[] cells;
		Figure[] figure = board.getFigures();
        board.fillFigure();

        int srcRow = this.cellPosition.getRow();
        int srcCol = this.cellPosition.getCol();
        int disRow = cell.getRow();
        int disCol = cell.getCol();
		int positionRow = 0;
		int positionCol = 0;
        int line = 0;

        if (srcRow == disRow && srcCol == disCol) {
			throw new ImposibleMoveException("It cell is busy, make outher choice");
        }
        if (disRow > 7 || disRow < 0 || disCol > 7 || disCol < 0) {
            throw new ImposibleMoveException("incorrect choice, change outher cell");
        }

		if (srcRow == disRow && srcCol == disCol) {
            throw new ImposibleMoveException("this figure nowhere walk, change correct choice");
        }

		if (srcRow == disRow || srcCol == disCol) {
			if (srcRow == disRow) {line = Math.abs(disCol - srcCol);}
			if (srcCol == disCol) {line = Math.abs(disRow - srcRow);}
            cells = new Cell[line];
			int rMove = disRow > srcRow ? 1 : disRow < srcRow ? -1 : 0;
			int cMove = disCol > srcCol ? 1 : disCol < srcCol ? -1 : 0;
			for (int i = 0; i < line; i++) {
				positionRow = positionRow + rMove;
				positionCol = positionCol + cMove;
				cells[i] = new Cell(positionRow, positionCol);
			}
		} else {
			throw new ImposibleMoveException("don't right choise");
		}
		return cells;
	}
}