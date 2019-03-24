package ru.job4j.persistence;

import java.util.List;

public interface Store {

    void add(Place place);
    List<Place> getPlaces();
}
