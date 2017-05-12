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
	* @cellPosition position figure
	*/
	private Cell position;

    /**.
     * Constructor for class Bishop
     * @param position is position figure
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**.
     * Method is getter cell
     */
    public Cell getCell() {
        return this.position;
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

        int srcRow = this.position.getRow();
        int srcCol = this.position.getCol();
        int disRow = cell.getRow();
        int disCol = cell.getCol();

        for (int index = 0; index < board.getFigures().length; index++) {
            Bishop bishop = (Bishop) board.getFigures()[index];
            if (bishop.getCell().getRow() == cell.getRow() &&
                    bishop.getCell().getCol() == cell.getCol()) {
                throw new ImposibleMoveException("It cell is busy, make outher choice");
            }
        }
        if (disRow > 7 && disRow < 0 && disCol > 7 && disCol < 0) {
            throw new ImposibleMoveException("incorrect choice, change outher cell");
        } else if (srcRow == disRow && srcCol == disCol) {
            throw new ImposibleMoveException("this figure nowhere walk, change correct choice");
        } else if (srcRow == disRow || srcCol == disCol) {
            throw new ImposibleMoveException("this figure can not so walk, change correct choice");
        } else if (srcRow == disRow && srcCol != disCol) {
            cells = new Cell[Math.abs(disCol - srcCol)];
            if (srcCol < disCol) {
                for (int i = 0; i < Math.abs(disCol - srcCol); i++) {
                    cells[i] = new Cell(srcRow, srcCol + i);
                }
            } else {
                for (int i = 0; i < Math.abs(disCol - srcCol); i++) {
                    cells[i] = new Cell(srcRow, srcCol - i);
                }
            }
            return cells;
        } else if (srcRow != disRow && srcCol == disCol) {
            cells = new Cell[Math.abs(disRow - srcRow)];
            if (srcRow < disRow) {
                for (int i = 0; i < Math.abs(disRow - srcRow); i++) {
                    cells[i] = new Cell(srcRow + i, srcCol);
                }
            } else {
                for (int i = 0; i < Math.abs(disCol - srcCol); i++) {
                    cells[i] = new Cell(srcRow - i, srcCol);
                }
            }
            return cells;
        } else {
            System.out.println("You destroy my programm");
            return cells = null;
        }
    }
}