package ru.job4j.address;

/**.
 * Chapter_003
 * Task_110062
 * Model for profile
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class Profile {

    /**.
     * @address is address from profile
     */
    private final Address address;

    /**.
     * Construcrtor
     * @param address is address for this profile
     */
    public Profile(Address address) {
        this.address = address;
    }

    /**.
     * Getter for address
     * @return address
     */
    public Address getAddress() {
        return address;
    }
}
