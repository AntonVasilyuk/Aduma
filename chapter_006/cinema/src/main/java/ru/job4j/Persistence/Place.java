package ru.job4j.Persistence;

public class Place implements Comparable<Place>{

    private final int id;

    private final int row;

    private final int place;

    private final String name;

    private final String phone;

    private boolean occupied;

    public Place(int id, int row, int place, boolean occupied) {
        this.id = id;
        this.row = row;
        this.place = place;
        this.occupied = occupied;
        this.name = null;
        this.phone = null;
    }

    public Place(int row, int place) {
        this.id = 0;
        this.row = row;
        this.place = place;
        this.occupied = false;
        this.name = null;
        this.phone = null;
    }

    public Place(int row, int place, String name, String phone, boolean occupied) {
        this.id = 0;
        this.row = row;
        this.place = place;
        this.name = name;
        this.phone = phone;
        this.occupied = occupied;
    }

    public Place(int id, int row, int place, String name, String phone, boolean occupied) {
        this.id = id;
        this.row = row;
        this.place = place;
        this.name = name;
        this.phone = phone;
        this.occupied = occupied;
    }

    public int getRow() {
        return row;
    }

    public int getPlace() {
        return place;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Place{" +
                "row=" + row +
                ", place=" + place +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", occupied=" + occupied +
                '}';
    }

    @Override
    public int compareTo(Place place) {
        if (this.getId() > place.getId() ) {
            return 1;
        } else if (this.getId() < place.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
