package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Task 5.7.1.
 * Create test for my OrderBook
 *
 * Created by Anton Vasilyuk on 09.07.2017.
 * @version 1.0
 */
public class OrderBookTest {

    /**.
     * Link for the OrderBook
     */
    private OrderBook link;

    /**.
     * Preparing for tests
     */
    @Before
    public void preparingForTest() {
        link = new OrderBook();
    }

    /**.
     * Test method addOrder
     */
    @Test
    public void addOrder() {
        boolean result = link.addOrder("Book_One", "Bid", 100.20, 20);
        assertThat(result, is(true));
    }

    /**.
     * Test method deleteOrder
     */
    @Test
    public void deleteOrder() {
        link.addOrder("Book_One", "Bid", 100.20, 20);
        boolean result = link.deleteOrder("Book_One", "Bid", 100.20, 10);
        assertThat(result, is(true));
    }

    /**.
     * Test method printOrder
     */
    @Test
    public void printOrder() {
        link.addOrder("Book_One", "Bid", 100.20, 20);
        link.addOrder("Book_One", "Bid", 100.80, 40);
        link.addOrder("Book_One", "Ask", 100.00, 10);
        link.addOrder("Book_One", "Ask", 98.20, 50);
        link.printOrder("Book_One");
    }
}