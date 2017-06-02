package ru.job4j;

/**
 * Testing Task 3.4.2
 * Create collection Map for bank
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class Account {

    /**.
     * Amount money
     */
    private double value;

    /**.
     * Number account
     */
    private Integer recvisite;

    /**.
     * Constructor for account
     * @param value amount money
     * @param recvisite number account
     */
    public Account(double value, Integer recvisite) {
        this.value = value;
        this.recvisite = recvisite;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public double getValue() {
        return this.value;
    }
}
