package ru.job4j;

/**.
 * Task 7.6.2.
 * Create game Bomberman
 *
 * @author Anton Vasilyuk on 04.09.2017
 * @version 1.0.
 */

public class EndGame {

    /**.
     * @player is player
     */
    private final ActionPlayer player;

    /**.
     * @monsters is array for all mosters
     */
    private final ActionMonster[] monsters;

    /**.
     * Constructor for this class
     * @param player is link for thread player
     * @param monsters is link for all the monsters
     */
    public EndGame(ActionPlayer player, ActionMonster[] monsters) {
        this.player = player;
        this.monsters = monsters;
    }

    /**.
     * End game
     */
    public void theEnd() {
        this.player.setEndGame();
        for (int i = 0; i < monsters.length; i++) {
            this.monsters[i].setEndGame();
        }
    }
}
