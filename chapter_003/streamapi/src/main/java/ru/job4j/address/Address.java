package ru.job4j.address;

import java.util.Objects;

/**.
 * Chapter_003
 * Task_110062
 * Model for address
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class Address {

    /**.
     * @city is name city
     */
    private final String city;

    /**.
     * @street is name street
     */
    private final String street;

    /**.
     * @home is number of the home
     */
    private final int home;

    /**.
     * @apartment is number the apartment
     */
    private final int apartment;

    /**.
     * Constructor
     * @param city is data for city
     * @param street is data for street
     * @param home is data for home
     * @param apartment is data for apartment
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    /**.
     * Getter for city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**.
     * Getter for street
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**.
     * Getter for home
     * @return home
     */
    public int getHome() {
        return home;
    }

    /**.
     * Getter for apartment
     * @return apartment
     */
    public int getApartment() {
        return apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        int result = 17;
        int count = 31;
        result = count * result + city.hashCode();
        result = count * result + street.hashCode();
        result = count * result + home;
        result = count * result + apartment;
        return result;
    }

    @Override
    public String toString() {
        return "Address{"
                + "city='" + city + '\''
                + ", street='" + street + '\''
                + ", home=" + home
                + ", apartment=" + apartment
                + '}';
    }
}
