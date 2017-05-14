package ru.job4j;

import ru.job4j.game.*;
import ru.job4j.figure.*;

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
	* Method for test move figures
	*/
	@Test//(expected = ImposibleMoveException.class)
	public void whenFigureWantMoveThenCheckMayBeMakeThis() throws ImposibleMoveException, OccupedWayException, FigureNotFoundException, CloneNotSupportedException {
		Cell nowCell = new Cell(0, 0);
		Cell nextCell = new Cell(0, 6);
		Board board = new Board();
		board.fillFigure();
		//Figure[] figures = board.getFigures();
		boolean result = board.move(nowCell, nextCell);
		//Bishop bishop = new Bishop(nowCell);
		//bishop.way(nextCell);
		boolean expect = true;
		assertThat(result, is(expect));
	}
}