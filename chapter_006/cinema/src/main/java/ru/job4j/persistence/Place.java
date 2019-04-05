package ru.job4j.persistence;

/**
 * Model for place in the hall.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 02.03.2019
 */

public class Place implements Comparable<Place> {

    /**.
     * It's id in database
     */
    private final int id;

    /**.
     * It's row for place
     */
    private final int row;

    /**.
     * It's place
     */
    private final int place;

    /**.
     * It's name buyer
     */
    private final String name;

    /**.
     * It's phone the buyer
     */
    private final String phone;

    /**.
     * It's for checking occuped the place
     */
    private final boolean occupied;

    /**.
     * Constructor for this class
     * @param id the place
     * @param row the place
     * @param place the place
     * @param occupied the place
     */
    public Place(int id, int row, int place, boolean occupied) {
        this.id = id;
        this.row = row;
        this.place = place;
        this.occupied = occupied;
        this.name = null;
        this.phone = null;
    }

    /**.
     *  Constructor for this class
     * @param row the place
     * @param place the place
     */
    public Place(int row, int place) {
        this.id = 0;
        this.row = row;
        this.place = place;
        this.occupied = false;
        this.name = null;
        this.phone = null;
    }

    /**.
     * Constructor for this class
     * @param row the place
     * @param place the place
     * @param name the place
     * @param phone the place
     * @param occupied the place
     */
    public Place(int row, int place, String name, String phone, boolean occupied) {
        this.id = 0;
        this.row = row;
        this.place = place;
        this.name = name;
        this.phone = phone;
        this.occupied = occupied;
    }

    /**.
     * Constructor for this class
     * @param id the place
     * @param row  the place
     * @param place the place
     * @param name the place
     * @param phone the place
     * @param occupied the place
     */
    public Place(int id, int row, int place, String name, String phone, boolean occupied) {
        this.id = id;
        this.row = row;
        this.place = place;
        this.name = name;
        this.phone = phone;
        this.occupied = occupied;
    }

    /**.
     * Getter for row
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**.
     * Getter for place
     * @return place
     */
    public int getPlace() {
        return place;
    }

    /**.
     * Checking occupied
     * @return result
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**.
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**.
     * Getter for phone
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**.
     * Getter for id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**.
     * Return all field
     * @return result
     */
    @Override
    public String toString() {
        return "Place{"
                + "row=" + row
                + ", place=" + place
                + ", name='" + name + '\''
                + ", phone='" + phone + '\''
                + ", occupied=" + occupied
                + '}';
    }

    /**.
     * Comparator for sorting
     * @param place
     * @return
     */
    @Override
    public int compareTo(Place place) {
        if (this.getId() > place.getId()) {
            return 1;
        } else if (this.getId() < place.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
