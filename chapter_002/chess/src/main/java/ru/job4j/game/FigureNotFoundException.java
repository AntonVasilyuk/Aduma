package ru.job4j.game;

/**.
* Chapter_002
* Task 2.9.2 create chess
* Class for create Exception
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class FigureNotFoundException extends Exception {

	/**
     * Constructor of FigureNotFoundException class.
     * @param msg message of exception
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}