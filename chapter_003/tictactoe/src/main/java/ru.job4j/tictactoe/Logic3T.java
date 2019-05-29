package ru.job4j.tictactoe;

import java.util.function.Predicate;

/**.
 * Chapter_003
 * Task_49777
 * Game TicTacToe
 * Class is logic for gaming
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class Logic3T {

    /**.
     * Field cells
     */
    private final Figure3T[][] table;

    /**.
     * Constructor
     * @param table is field for gaming
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**.
     * Function interface
     * @param predicate is function for checking
     * @param startX is start X for checking
     * @param startY is start Y for checking
     * @param deltaX is one step by X
     * @param deltaY is one step by Y
     * @return result checking
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**.
     * Checking win X
     * @return result
     */
    public boolean isWinnerX() {
        return checking(Figure3T::hasMarkX);
    }

    /**.
     * Checking win Y
     * @return result
     */
    public boolean isWinnerO() {
        return checking(Figure3T::hasMarkO);
    }

    /**.
     * Method for checking winner
     * @param function is function for checking
     * @return result
     */
    public boolean checking(Predicate<Figure3T> function) {
        return fillBy(function, 0, 0, 0, 1)
                || fillBy(function, 0, 0, 1, 0)
                || fillBy(function, 0, 0, 1, 1)
                || fillBy(function, 1, 0, 0, 1)
                || fillBy(function, 2, 0, 0, 1)
                || fillBy(function, 2, 0, 1, 1)
                || fillBy(function, 0, 1, 0, 1)
                || fillBy(function, 0, 2, 0, 1)
                || fillBy(function, 0, 2, 1, 1);
    }

    /**.
     * Checking empty cells
     * @return result checking
     */
    public boolean hasGap() {
        int count = table.length * table[0].length;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j].hasMarkX() || table[i][j].hasMarkO()) {
                    count -= 1;
                }
            }
        }
        return count == 0 ? true : false;
    }
}