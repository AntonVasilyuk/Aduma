package ru.job4j.figure;

import ru.job4j.game.ImposibleMoveException;
import ru.job4j.game.Cell;

/**.
* Chapter_002
* Task 2.9.2
* Create class Queen
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Queen extends Figure {

    /**.
     * Constructor for class Queen
     * @param cellPosition is position figure
     */
    public Queen(Cell cellPosition) {
        super(cellPosition);
    }

	/**.
	* Method for check may be way figure
	* @dist finish cell way
	* @return array cell is way figure
	*/
	@Override
	public Cell[] way(Cell dist) throws ImposibleMoveException {

		Cell[] cell;

        int srcRow = this.getCell().getRow();
        int srcCol = this.getCell().getCol();
        int disRow = dist.getRow();
        int disCol = dist.getCol();

		if (srcRow == disRow || srcCol == disCol || Math.abs(disRow - srcRow) == Math.abs(disCol - srcCol)) {
			cell = routing(srcRow, srcCol, disRow, disCol);
		} else {
			throw new ImposibleMoveException("don't right choise");
		}
		return cell;
	}
}