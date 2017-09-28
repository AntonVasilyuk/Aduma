package ru.job4j;

public class EndGame {

    private final ActionPlayer player;
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
        for(int i = 0; i < monsters.length; i++) {this.monsters[i].setEndGame();}
    }
}
