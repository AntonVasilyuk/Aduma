package ru.job4j.Service;

import ru.job4j.Persistence.DataBase;
import ru.job4j.Persistence.Place;

import java.util.List;

public class Service {

    private final DataBase base = DataBase.getInstance();

    private static final Service service = new Service();

    private Service() {
    }

    public static Service getInstance() {
        return service;
    }

    public List<Place> getPlaces() {
        return base.getPlaces();
    }

    public void add(Place place) {
        base.add(place);
    }


}
