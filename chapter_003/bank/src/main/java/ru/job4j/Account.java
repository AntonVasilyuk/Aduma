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

    /**.
     * Transfer money to an account
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**.
     * View money in the account
     * @return result
     */
    public double getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) return false;
        return recvisite != null ? recvisite.equals(account.recvisite) : account.recvisite == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (recvisite != null ? recvisite.hashCode() : 0);
        return result;
    }
}
