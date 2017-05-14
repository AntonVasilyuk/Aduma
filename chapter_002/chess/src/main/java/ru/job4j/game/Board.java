package ru.job4j.game;

import ru.job4j.figure.*;

/**.
* Chapter_002
* Task 2.9.2
* Class for create Board for figure
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Board {

	/**.
	* @numFigure is index
	*/
	private int numFigure = 0;

    /**.
     * Array figures
     */
    private Figure[] figures = new Figure[2];

    /**.
     * Method for fill array figures
     */
    public void fillFigure() {
		int numFigure = 0;
        this.figures[numFigure++] = new Bishop(new Cell(0, 0));
        this.figures[numFigure++] = new Bishop(new Cell(0, 7));
    }

    /**.
     * Method for check validate move need figure
     * @param source start point
     * @param dist finish point
     * @return is it possible to move
     */
    public boolean move(Cell source, Cell dist) throws ImposibleMoveException, OccupedWayException, FigureNotFoundException, CloneNotSupportedException {
        int index = 0;
        boolean result = true;

        int srcRow = source.getRow();
        int srcCol = source.getCol();
        int disRow = dist.getRow();
        int disCol = dist.getCol();

        for (int i = 0; i < figures.length; i++) {
            if (srcRow == figures[i].getCell().getRow() && srcCol == figures[i].getCell().getCol()) {
                index = i;
            }
        }

        Cell[] cell = this.figures[index].way(dist);

        if (index == 0) {
            result = false;
            throw new FigureNotFoundException("this cell empty, check your choise");
        }

        if (cell == null) {
            result = false;
            throw new ImposibleMoveException("figure don't move to this cell");
        }

        for (int x = 0; x < cell.length; x++) {
            for (int y = 0; y < figures.length; y++) {
                Bishop bishop = (Bishop) figures[y];
                if (cell[x].getRow() == figures[y].getCell().getRow() &&
                        cell[x].getCol() == figures[y].getCell().getCol()) {
                    result = false;
                    throw new OccupedWayException("way is not empty");
                }
            }
        }
        if (result) {
            figures[index] = clone(dist, figures[index]);
        }
        return result;
    }

    /**.
     * Method for add and treament exception
     * @param source start point
     * @param dist finish point
     */
    public void checkChoise(Cell source, Cell dist) throws ImposibleMoveException, OccupedWayException, FigureNotFoundException {
        try {
            move(source, dist);
        } catch (FigureNotFoundException fnfe) {
            System.out.println("this cell empty, check your choise");
        } catch (ImposibleMoveException ime) {
            System.out.println("figure don't move to this cell");
        } catch (OccupedWayException owe) {
            System.out.println("way is not empty");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    public Figure[] getFigures() {
        return this.figures;
    }

    public Figure clone(Cell cell, Figure figure) {
        Figure newFigure = null;
        if (figure instanceof Bishop) {newFigure = new Bishop(cell);}
        return newFigure;
    }
}