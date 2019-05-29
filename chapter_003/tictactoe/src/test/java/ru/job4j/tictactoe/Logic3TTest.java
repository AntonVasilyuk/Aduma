package ru.job4j.tictactoe;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**.
 * Chapter_003
 * Task_49777
 * Game TicTacToe
 * Test working logic game
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class Logic3TTest {

    /**.
     * Testing working method isWinnerX
     */
    @Test
    public void whenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T login = new Logic3T(table);
        Assert.assertThat(login.isWinnerX(), is(true));
    }

    /**.
     * Test working method IsWinnerO
     */
    @Test
    public void whenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(false, true), new Figure3T(), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T login = new Logic3T(table);
        Assert.assertThat(login.isWinnerO(), is(true));
    }

    /**.
     * Test working method isGamp
     */
    @Test
    public void whenHasGas() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(false, true), new Figure3T(true, false)},
                {new Figure3T(false, true), new Figure3T(true, false), new Figure3T(false, true)},
                {new Figure3T(false, true), new Figure3T(true, false), new Figure3T(false, true)},
        };
        Logic3T login = new Logic3T(table);
        Assert.assertThat(login.hasGap(), is(true));
    }
}