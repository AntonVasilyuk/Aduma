package ru.job4j;

/**.
 * Task 7.6.2.
 * Create game Bomberman
 *
 * @author Anton Vasilyuk on 04.09.2017
 * @version 1.0.
 */

public class GameBomberman {

    private final ActionPlayer bomberman;
    private final ActionMonster[] monsters;

    private final Player player;
    private final int difficultyGame;

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
     * @param difficulty is level difficulty for this game
     */
    public GameBomberman(String name, int stepPlayer, int difficulty) {
        this.difficultyGame = difficulty;
        board = new Board();
        Block block = new Block(difficulty, board.getBoard());
        player = new Player(name, stepPlayer, SIZEFIELD);
        this.bomberman = new ActionPlayer(player, board);
        monsters = new ActionMonster[difficultyGame];
    }

    /**.
     * Is main method
     */
    public void mainAction() {
        Thread tBomberMan = new Thread(bomberman);
        tBomberMan.start();
        for (int i = 0; i < difficultyGame; i++) {
            monsters[i] = new ActionMonster(new Monster(i, 1, SIZEFIELD), board, player.getPlace());
            Thread thread = new Thread(monsters[i]);
            thread.start();
        }
    }

    /**.
     * Is initialisation end the game
     */
    public void endGame() {
        bomberman.setEndGame();
        for(int i = 0; i < monsters.length; i++) {
            monsters[i].setEndGame();
        }
        System.out.printf("Player is alive!");
    }
}
