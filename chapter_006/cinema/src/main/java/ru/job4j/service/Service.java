package ru.job4j.service;

import ru.job4j.persistence.DataBase;
import ru.job4j.persistence.Place;
import ru.job4j.persistence.Store;

import java.util.List;


/**
 * Class for working to database.
 *
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 02.03.2019
 */
public class Service {

    /**.
     * Example for class database
     */
    private final Store base = DataBase.getInstance();

    /**.
     * Example for this class
     */
    private static final Service INSTANCE = new Service();

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
        return INSTANCE;
    }

    /**.
     * Getter all writes form table halls
     * @return all places
     */
    public List<Place> getPlaces() {
        return base.getPlaces();
    }

    /**.
     * Method for adding new order to writes
     * @param place for adding
     */
    public void add(Place place) {
        base.add(place);
    }
}
