package ru.job4j;

import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;
import java.util.Comparator;

/**
 * Task 5.7.1.
 * Create OrderBook
 *
 * Created by Anton Vasilyuk on 03.07.2017.
 * @version 1.0
 */
public class OrderBook {

    /**.
     * @highPrice is highest price in this order book
     */
    private Double highPrise;

    /**.
     * @lowPrice is lowest price is this order book
     */
    private Double lowPrise;

    /**.
     * @nameBid is name for bid order
     */
    private String nameBid = "Bid";

    /**.
     * @nameAsk is name for ask order
     */
    private String nameAsk = "Ask";

    /**.
     * @priceMarket is price on the market
     */
    private Double priceMarket = 100.10;

    /**.
     * @orderBooks, is links for all order books
     */
    private Map<String, Map<String, Map<Double, Order>>> orderBooks;

    /**.
     * @orderBook, is links for order book
     */
    private Map<String, Map<Double, Order>> orderBook;

    /**.
     * @orderBookBid, is links for bid order
     */
    private TreeMap<Double, Order> orderBookBid;

    /**.
     * @orderBookAsk is links for ask order
     */
    private TreeMap<Double, Order> orderBookAsk;

    /**.
     * @tempOrder is link on temp the order
     */
    private Order tempOrder;

    /**.
     * @tempOrderBook is link for the temp orderbook
     */
    private Map<String, Map<Double, Order>> tempOrderBook;

    /**.
     * @tempMap is link on the temp map
     */
    private Map<Double, Order> tempMap;

    /**.
     * Constructor for this class
     */
    public OrderBook() {
        orderBooks = new HashMap<>();
    }

    /**.
     * Method for add order to the orderbook
     * @param nameBook is name book
     * @param nameOrder is name order
     * @param price is price order
     * @param volume is volume order
     * @return boolean
     */
    public boolean addOrder(String nameBook, String nameOrder, Double price, int volume) {
        if (nameOrder.equals(nameBid)) {
            if (price < priceMarket) {
                return false;
            }
        }
        if (nameOrder.equals(nameAsk)) {
            if (price > priceMarket) {
                return false;
            }
        }

        if (orderBooks.containsKey(nameBook)) {
            tempOrderBook = orderBooks.get(nameBook);
            tempMap = tempOrderBook.get(nameOrder);
            if (tempMap.containsKey(price)) {
                tempMap.get(price).setAddVolume(volume);
            } else {
                tempOrder = new Order(nameOrder, price, volume);
                tempMap.put(price, tempOrder);
            }
        } else {
            createOrderBook(nameBook);
            tempOrder = new Order(nameOrder, price, volume);
            if (nameOrder.equals(nameBid)) {
                orderBookBid.put(price, tempOrder);
            }
            if (nameOrder.equals(nameAsk)) {
                orderBookAsk.put(price, tempOrder);
            }
        }
        if (!orderBookBid.isEmpty()) {
            highPrise = orderBookBid.firstKey();
        }
        if (!orderBookAsk.isEmpty()) {
            lowPrise = orderBookAsk.firstKey();
        }
        return true;
    }

    /**.
     * Method for delete order from the orderbook
     * @param nameBook is name book
     * @param nameOrder is name order
     * @param price is price order
     * @param volume is volume order
     * @return boolean
     */
    public boolean deleteOrder(String nameBook, String nameOrder, Double price, int volume) {
        if (!orderBooks.containsKey(nameBook)) {
            return false;
        }
        tempOrderBook = orderBooks.get(nameBook);

        if (lowPrise != null) {
            if (price < lowPrise) {
                return false;
            }
        }
        if (highPrise != null) {
            if (price > highPrise) {
                return false;
            }
        }

        tempMap = tempOrderBook.get(nameOrder);
        if (!tempMap.containsKey(price)) {
            return false;
        }

        int result = tempMap.get(price).setDelVolume(volume);
        if (result <= 0) {
            tempMap.remove(price);
        }
        return true;
    }

    /**.
     * Method for print the orderbook
     * @param nameBook is name the orderbook
     */
    public void printOrder(String nameBook) {
        if (!orderBooks.containsKey(nameBook)) {
            return;
        }
        tempOrderBook = orderBooks.get(nameBook);
        if (tempOrderBook.get(nameBid).isEmpty() && tempOrderBook.get(nameAsk).isEmpty()) {
            System.out.printf("%s", "Order book is empty");
        }
        System.out.printf("Order book: %s%n", nameBook);

        Set<Double> priceBid = tempOrderBook.get(nameBid).keySet();
        Set<Double> priceAsk = tempOrderBook.get(nameAsk).keySet();
        Collection<Order> orderBid = tempOrderBook.get(nameBid).values();
        Collection<Order> orderAsk = tempOrderBook.get(nameAsk).values();
        Iterator<Double> itPriceBid = priceBid.iterator();
        Iterator<Double> itPriceAsk = priceAsk.iterator();
        Iterator<Order> itOrderBid = orderBid.iterator();
        Iterator<Order> itOrderAsk = orderAsk.iterator();

        System.out.printf("%s%s%s%n", nameBid, "             ", nameAsk);
        System.out.printf("Volume@Price – Volume@Price%n");

        while (itPriceBid.hasNext() || itPriceAsk.hasNext()) {
            String left = null;
            String right = null;
            if (itPriceBid.hasNext()) {
                left = itOrderBid.next().getVolume() + "@" + itPriceBid.next();
            } else {
                left = "----------";
            }
            if (itPriceAsk.hasNext()) {
                right = itOrderAsk.next().getVolume() + "@" + itPriceAsk.next();
            } else {
                right = "----------";
            }
            System.out.printf("%s  -  %s%n", left, right);
        }
    }

    /**.
     * Method for crean new order book
     * @param nameBook is name new orderbook
     */
    private void createOrderBook(String nameBook) {
        this.orderBookBid = new TreeMap(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o1, o2);
            }
        });
        this.orderBookAsk = new TreeMap(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o2, o1);
            }
        });
        orderBook = new HashMap<>();
        orderBook.put(nameBid, orderBookBid);
        orderBook.put(nameAsk, orderBookAsk);
        orderBooks.put(nameBook, orderBook);
    }
}