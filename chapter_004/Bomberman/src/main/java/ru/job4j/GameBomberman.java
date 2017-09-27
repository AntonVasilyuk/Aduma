package ru.job4j;

public class GameBomberman {

    private final ActionPlayer bomberman;

    /**.
     * @SIZEFIELD is max size for field the board
     */
    private static final int SIZEFIELD = 10;

    /**.
     * @board is link for board
     */
    private final Board board;

    /**.
     * Constructor for this class
     * @param name is name for the player
     * @param stepPlayer is max step for the player
     */
    public GameBomberman(String name, int stepPlayer, int difficulty) {
        board = new Board();
        Block block = new Block(difficulty, board.getBoard());
        this.bomberman = new ActionPlayer(new Player(name, stepPlayer, SIZEFIELD), board);
    }

    /**.
     * Is main method
     */
    public void mainAction() {
        Thread tBomberMan = new Thread(bomberman);
        tBomberMan.start();
    }

    /**.
     * Is initialisation end the game
     */
    public void endGame() {
        bomberman.setEndGame();
    }
}
