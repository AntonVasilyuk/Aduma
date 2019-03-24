package ru.job4j.service;

import ru.job4j.persistence.DataBase;
import ru.job4j.persistence.Place;
import ru.job4j.persistence.Store;

import java.util.List;

public class Service {

    /**.
     * Example for class database
     */
    private final Store base = DataBase.getInstance();

    /**.
     * Example for this class
     */
    private static final Service service = new Service();

    /**.
     * It's private constructor
     */
    private Service() {
    }

    /**.
     * Getter for example this class
     * @return example
     */
    public static Service getInstance() {
        return service;
    }

    /**.
     * Getter all writes form table halls
     * @return
     */
    public List<Place> getPlaces() {
        return base.getPlaces();
    }

    /**.
     * Method for adding new order to writes
     * @param place
     */
    public void add(Place place) {
        base.add(place);
    }
}
