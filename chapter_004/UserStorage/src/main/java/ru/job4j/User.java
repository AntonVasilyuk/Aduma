package ru.job4j;

import net.jcip.annotations.ThreadSafe;

/**.
 * Task 7.3.2.
 * Create User for User Storage
 *
 * @author Anton Vasilyuk on 27.07.2017.
 * @version 1.0.
 */
@ThreadSafe
public class User {

    /**.
     * @id is id for user
     */
    private int id;

    /**.
     * @amount is amount
     */
    private int amount;

    /**.
     * Constructor for this class
     * @param id user
     * @param amount is account the user
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**.
     * Getter for id of the user
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**.
     * Setter for id of the user
     * @param id is id for user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**.
     * Getter for amount of the user
     * @return amount
     */
    public int getAmount() {
        return  this.amount;
    }

    /**.
     * Setter for amount of the user
     * @param amount is amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
