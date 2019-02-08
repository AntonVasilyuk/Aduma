package ru.job4j.Persistence;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBase {

    Logger log = LoggerFactory.getLogger(DataBase.class);

    private static final DataBase db = new DataBase();

    private final BasicDataSource SOURCE = new BasicDataSource();

    Settings settings = Settings.getInstance();

    public static DataBase getInstance() {
        return db;
    }

    private DataBase() {
        SOURCE.setDriverClassName(settings.getValues("jdbc.driver"));
        SOURCE.setUrl(settings.getValues("jdbc.url"));
        SOURCE.setUsername(settings.getValues("jdbc.username"));
        SOURCE.setPassword(settings.getValues("jdbc.password"));

        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        createTables();
    }

    public void add(Place place) {
        addAccounts(place);
        addHall(place);
    }

    public boolean addHall(Place place) {
        Connection connectionRollBack = null;
        String queryEdit = String.format("UPDATE halls SET occupied='unfree' WHERE id=?");
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement stEdit = connection.prepareStatement(queryEdit)
        ) {
            connection.setAutoCommit(false);
            connectionRollBack = connection;
            stEdit.addBatch();
            stEdit.setInt(1, getIDPlace(place));
            stEdit.execute();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (connectionRollBack != null) {
                try {
                    connectionRollBack.rollback();
                } catch (SQLException e1) {
                    log.error(e1.getMessage(), e1);
                }
            }
            log.error(e.getMessage(), e);
        }
        return true;
    }

    public boolean addAccounts(Place place) {
        Connection connectionRollBack = null;
        String queryAdd = String.format("INSERT INTO accounts(name, phone, idPlace) " +
                "VALUES(?, ?, ?)");
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement stAdd = connection.prepareStatement(queryAdd)
        ) {
            connection.setAutoCommit(false);
            connectionRollBack = connection;
            stAdd.addBatch();
            stAdd.setString(1, place.getName());
            stAdd.setString(2, place.getPhone());
            stAdd.setInt(3, getIDPlace(place));
            stAdd.execute();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (connectionRollBack != null) {
                try {
                    connectionRollBack.rollback();
                } catch (SQLException e1) {
                    log.error(e1.getMessage(), e1);
                }
            }
            log.error(e.getMessage(), e);
        }
        return true;
    }

    public int getIDPlace(Place place) {
        int id = 0;
        String query = String.format("SELECT id FROM halls WHERE row=%d AND place=%d;",
                place.getRow(), place.getPlace());
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("id");
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
        System.out.println(id);
        return id;
    }

    public List<Place> getPlaces() {
        List<Place> listAllUser = new ArrayList<>();
        String query = String.format("SELECT * FROM halls;");
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                int row = rs.getInt("row");
                int place = rs.getInt("place");
                String free = rs.getString("occupied");
                boolean occupied = false;
                if (free.equals("unfree")) {
                    occupied = true;
                }
                Place placeForAdding = new Place(id, row, place, occupied);
                listAllUser.add(placeForAdding);
            }
            Collections.sort(listAllUser);
            System.out.println(listAllUser);
            return listAllUser;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return listAllUser;
    }

    public void createTables() {
        createTableHall();
        createTableAccount();
    }

    public void createTableAccount() {
        String queryAccounts = String.format("CREATE TABLE IF NOT EXISTS accounts (id SERIAL PRIMARY KEY, name VARCHAR(50) ," +
                "phone VARCHAR(15) NOT NULL, idPlace INT NOT NULL );");
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(queryAccounts);
        ) {
            connection.setAutoCommit(false);
            st.addBatch();
            st.execute();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
    }

    public void createTableHall() {
        String queryHall = String.format("CREATE TABLE IF NOT EXISTS halls (id SERIAL PRIMARY KEY, row INT NOT NULL ," +
                "place INT NOT NULL , occupied VARCHAR(10) NOT NULL, userID INT);");
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(queryHall);
        ) {
            connection.setAutoCommit(false);
            st.addBatch();
            st.execute();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
    }


    public static void main(String[] args) {
        DataBase db = DataBase.getInstance();
        Place place = new Place(1, 2, "tony", "79825054792", true);
        db.getPlaces();
    }
}