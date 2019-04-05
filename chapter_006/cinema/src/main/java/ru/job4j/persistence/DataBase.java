package ru.job4j.persistence;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for working with database.
 *
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 02.03.2019
 */

public class DataBase implements Store {

    /**.
     * It's logger for this class.
     */
    private static final Logger LOG = Logger.getLogger(DataBase.class);

    /**.
     * It's example for this class.
     */
    private static final DataBase DB = new DataBase();

    /**.
     * It's sourse for multiple working for database.
     */
    private static final BasicDataSource SOURCE = new BasicDataSource();

    /**.
     * It's settings.
     */
    private final Settings settings = Settings.getInstance();

    /**.
     * It's getter for singleton class.
     * @return example this class.
     */
    public static DataBase getInstance() {
        return DB;
    }

    /**.
     * Constructor for this class.
     */
    private DataBase() {
        SOURCE.setDriverClassName(settings.getValues("jdbc.driver"));
        SOURCE.setUrl(settings.getValues("jdbc.url"));
        SOURCE.setUsername(settings.getValues("jdbc.username"));
        SOURCE.setPassword(settings.getValues("jdbc.password"));

        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    /**.
     * Method for adding new order to database
     * @param place is place in the hall
     */
    public void add(Place place) {
        addAccounts(place);
        int idAccount = getIDAccaunt(place);
        addHall(place, idAccount);
    }

    /**.
     * Add writes to table hall
     * @param place is place in the hall
     * @param idAccount is id account
     */
    public void addHall(Place place, int idAccount) {
        Connection connectionRollBack = null;
        String queryEdit = String.format("UPDATE halls SET occupied='unfree', userID=? WHERE id=?");
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement stEdit = connection.prepareStatement(queryEdit)
        ) {
            connection.setAutoCommit(false);
            connectionRollBack = connection;
            stEdit.addBatch();
            stEdit.setInt(1, idAccount);
            stEdit.setInt(2, getIDPlace(place));
            stEdit.execute();
            connection.commit();
        } catch (Exception e) {
            if (connectionRollBack != null) {
                try {
                    connectionRollBack.rollback();
                } catch (SQLException e1) {
                    LOG.error(e1.getMessage(), e1);
                }
            }
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Method for adding writes to table accounts
     * @param place in the hall
     */
    public void addAccounts(Place place) {
        Connection connectionRollBack = null;
        String queryAdd = String.format("INSERT INTO accounts(name, phone, idPlace) "
                + "VALUES(?, ?, ?)");
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
            if (connectionRollBack != null) {
                try {
                    connectionRollBack.rollback();
                } catch (SQLException e1) {
                    LOG.error(e1.getMessage(), e1);
                }
            }
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Method for getting id place from table hall
     * @param place in the hall
     * @return all places
     */
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
            LOG.error(e.getMessage(), e);
        }
        return id;
    }

    /**.
     * Method getter id from accounts
     * @param place in the hall
     * @return id buyer
     */
    public int getIDAccaunt(Place place) {
        int id = 0;
        String query = String.format("SELECT id FROM accounts WHERE name='%s' AND phone='%s';",
                place.getName(), place.getPhone());
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("id");
            }
            return id;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return id;
    }

    /**.
     * Method for getting all place from table hall
     * @return all writes
     */
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
            return listAllUser;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return listAllUser;
    }
}