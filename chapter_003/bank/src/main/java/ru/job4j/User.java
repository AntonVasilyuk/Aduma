package ru.job4j;

/**.
 * Testing Task 3.4.2
 * Create collection Map for bank
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class User {
    /**.
     * name user
     */
    private String name;

    /**.
     * passport user
     */
    private Integer passport;

    /**.
     * Constructor for create user
     * @param name it's name for user
     * @param passport it's passport for user
     */
    public User(String name, Integer passport) {
        this.name = name;
        this.passport = passport;
    }
    /**.
     * equals users by name
     * @param o is object for checking
     * @return result
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return this.name.equals(user.name);
    }

    /**.
     * hashCod users
     * @return hashCod users
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**.
     * Getter name
     * @return name user
     */
    public String getName() {
        return this.name;
    }

    /**.
     * Getter passport user
     * @return passport user
     */
    public Integer getPassport() {
        return this.passport;
    }
}
