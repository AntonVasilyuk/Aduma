package ru.job4j.persistence;

import java.util.List;

/**
 * Interface for working with database.
 *
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 02.03.2019
 */

public interface Store {

    /**.
     * Method for adding new place.
     * @param place for adding.
     */
    void add(Place place);

    /**.
     * Getting all places.
     * @return all places.
     */
    List<Place> getPlaces();
}
