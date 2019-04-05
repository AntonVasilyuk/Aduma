package ru.job4j.figure;

import ru.job4j.game.Cell;
import ru.job4j.game.ImposibleMoveException;

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

		Cell[] cell = new Cell[1];

        int srcRow = this.getCell().getRow();
        int srcCol = this.getCell().getCol();
        int disRow = dist.getRow();
        int disCol = dist.getCol();

		if (Math.abs(srcRow - disRow) == 2 && Math.abs(srcCol - disCol) == 1 || Math.abs(srcRow - disRow) == 1 && Math.abs(srcCol - disCol) == 2) {
			cell[0] = new Cell(disRow, disCol);
		} else {
			throw new ImposibleMoveException("incorrect choise cell");
		}
		return cell;
	}
}