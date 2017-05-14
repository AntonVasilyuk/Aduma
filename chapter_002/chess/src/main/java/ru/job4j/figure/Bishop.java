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
        int line = figure.length;

        if (srcRow == disRow && srcCol == disCol) {
			throw new ImposibleMoveException("It cell is busy, make outher choice");
        }
        if (disRow > 7 || disRow < 0 || disCol > 7 || disCol < 0) {
            throw new ImposibleMoveException("incorrect choice, change outher cell");
        } else if (srcRow == disRow && srcCol == disCol) {
            throw new ImposibleMoveException("this figure nowhere walk, change correct choice");
        } else if (srcRow == disRow && srcCol != disCol) {
            cells = new Cell[Math.abs(disCol - srcCol)];
            if (srcCol < disCol) {
                for (int i = 0; i < Math.abs(disCol - srcCol); i++) {
                    cells[i] = new Cell(srcRow, srcCol + i + 1);
                }
            } else {
                for (int i = 0; i < Math.abs(disCol - srcCol); i++) {
                    cells[i] = new Cell(srcRow, srcCol - i - 1);
                }
            }
            return cells;
        } else if (srcRow != disRow && srcCol == disCol) {
            cells = new Cell[Math.abs(disRow - srcRow)];
            if (srcRow < disRow) {
                for (int i = 0; i < Math.abs(disRow - srcRow); i++) {
                    cells[i] = new Cell(srcRow + i + 1, srcCol);
                }
            } else {
                for (int i = 0; i < Math.abs(disCol - srcCol); i++) {
                    cells[i] = new Cell(srcRow - i - 1, srcCol);
                }
            }
            return cells;
        } else {
            System.out.println("You destroy my programm");
            return cells = null;
        }
    }
}