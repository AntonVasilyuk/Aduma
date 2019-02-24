package ru.job4j.Persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Store {

    void add(Place place);
    List<Place> getPlaces();
}
