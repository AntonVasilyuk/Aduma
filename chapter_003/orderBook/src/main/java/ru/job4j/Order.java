package ru.job4j;

/**
 * Task 5.7.1.
 * This class is template for order
 *
 * Created by Anton Vasilyuk on 03.07.2017.
 * @version 1.0
 */
public class Order {

    /**.
     * @name is name the order
     */
    private String name;

    /**.
     * @price is price the order
     */
    private Double price;

    /**.
     * @volume is volume the order
     */
    private int volume;

    /**.
     * Constructor for order
     * @param name is name the order
     * @param price is price the order
     * @param volume is volume the order
     */
    public Order(String name, Double price, int volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    /**.
     * Method for change volume for add order
     * @param volume is volume the order
     */
    public void setAddVolume(int volume) {
        this.volume = this.volume + volume;
    }

    /**.
     * Method for change volume for delete order
     * @param volume the order
     * @return return remnamt volume
     */
    public int setDelVolume(int volume) {
        this.volume = this.volume - volume;
        return this.volume;
    }

    /**.
     * Getter for price
     * @return price
     */
    public double getPrice() {
        return this.price;
    }

    /**.
     * Getter for volume
     * @return return volume
     */
    public int getVolume() {
        return this.volume;
    }
}
