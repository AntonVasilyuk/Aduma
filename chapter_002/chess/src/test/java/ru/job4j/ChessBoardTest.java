package ru.job4j;

import ru.job4j.game.ImposibleMoveException;
import ru.job4j.game.OccupedWayException;
import ru.job4j.game.FigureNotFoundException;

import ru.job4j.game.Cell;
import ru.job4j.game.Board;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**.
* Chapter_002
* Task 2.9.2
* Test move chess figure
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class ChessBoardTest {

	/**.
	* Method for test move Castl
	 * @throws ImposibleMoveException Impossible to go there
	 * @throws OccupedWayException way is occupied
	 * @throws FigureNotFoundException figure is not found
	*/
	@Test
	public void whenCastlWantMoveThenCheckMayBeMakeThis() throws ImposibleMoveException, OccupedWayException, FigureNotFoundException {
		Cell nowCell = new Cell(0, 0);
		Cell nextCell = new Cell(6, 0);
		Board board = new Board();
		board.fillFigure();
		boolean result = board.move(nowCell, nextCell);
		boolean expect = true;
		assertThat(result, is(expect));
	}

	/**.
	* Method for test ImposibleMoveException
	 * @throws ImposibleMoveException Impossible to go there
	 * @throws OccupedWayException way is occupied
	 * @throws FigureNotFoundException figure is not found
	*/
	@Test(expected = ImposibleMoveException.class)
	public void whenFigureCantMoveThenGetUpError() throws ImposibleMoveException, OccupedWayException, FigureNotFoundException {
		Cell nowCell = new Cell(0, 0);
		Cell nextCell = new Cell(5, 5);
		Board board = new Board();
		board.fillFigure();
		board.move(nowCell, nextCell);
	}

	/**.
	* Method for test OccupedWayException
	 * @throws ImposibleMoveException Impossible to go there
	 * @throws OccupedWayException way is occupied
	 * @throws FigureNotFoundException figure is not found
	*/
	@Test(expected = OccupedWayException.class)
	public void whenFigureDistCellOccupedThenGetUpError() throws ImposibleMoveException, OccupedWayException, FigureNotFoundException {
		Cell nowCell = new Cell(0, 0);
		Cell nextCell = new Cell(0, 7);
		Board board = new Board();
		board.fillFigure();
		board.move(nowCell, nextCell);
	}

	/**.
	* Method for test OccupedWayException
	 * @throws ImposibleMoveException Impossible to go there
	 * @throws OccupedWayException way is occupied
	 * @throws FigureNotFoundException figure is not found
	*/
	@Test(expected = FigureNotFoundException.class)
	public void whenInSourceCellNotFigureThenGetUpError() throws ImposibleMoveException, OccupedWayException, FigureNotFoundException {
		Cell nowCell = new Cell(3, 6);
		Cell nextCell = new Cell(0, 5);
		Board board = new Board();
		board.fillFigure();
		board.move(nowCell, nextCell);
	}

	/**.
	* Method for test move Bishop
	 * @throws ImposibleMoveException Impossible to go there
	 * @throws OccupedWayException way is occupied
	 * @throws FigureNotFoundException figure is not found
	*/
	@Test
	public void whenBishopWantMoveThenCheckMayBeMakeThis() throws ImposibleMoveException, OccupedWayException, FigureNotFoundException {
		Cell nowCell = new Cell(0, 2);
		Cell nextCell = new Cell(2, 4);
		Board board = new Board();
		board.fillFigure();
		boolean result = board.move(nowCell, nextCell);
		boolean expect = true;
		assertThat(result, is(expect));
	}

	/**.
	* Method for test move Knight
	 * @throws ImposibleMoveException Impossible to go there
	 * @throws OccupedWayException way is occupied
	 * @throws FigureNotFoundException figure is not found
	*/
	@Test
	public void whenKnightWantMoveThenCheckMayBeMakeThis() throws ImposibleMoveException, OccupedWayException, FigureNotFoundException {
		Cell nowCell = new Cell(0, 1);
		Cell nextCell = new Cell(2, 2);
		Board board = new Board();
		board.fillFigure();
		boolean result = board.move(nowCell, nextCell);
		boolean expect = true;
		assertThat(result, is(expect));
	}

	/**.
	* Method for test move Queen
	 * @throws ImposibleMoveException Impossible to go there
	 * @throws OccupedWayException way is occupied
	 * @throws FigureNotFoundException figure is not found
	*/
	@Test
	public void whenQueenWantMoveThenCheckMayBeMakeThis() throws ImposibleMoveException, OccupedWayException, FigureNotFoundException {
		Cell nowCell = new Cell(0, 3);
		Cell nextCell = new Cell(5, 3);
		Board board = new Board();
		board.fillFigure();
		boolean result = board.move(nowCell, nextCell);
		boolean expect = true;
		assertThat(result, is(expect));
	}

	/**.
	* Method for test move King
	 * @throws ImposibleMoveException Impossible to go there
	 * @throws OccupedWayException way is occupied
	 * @throws FigureNotFoundException figure is not found
	*/
	@Test
	public void whenKingWantMoveThenCheckMayBeMakeThis() throws ImposibleMoveException, OccupedWayException, FigureNotFoundException {
		Cell nowCell = new Cell(0, 4);
		Cell nextCell = new Cell(1, 3);
		Board board = new Board();
		board.fillFigure();
		boolean result = board.move(nowCell, nextCell);
		boolean expect = true;
		assertThat(result, is(expect));
	}
}