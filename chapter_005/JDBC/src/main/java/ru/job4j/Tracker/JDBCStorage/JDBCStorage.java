package ru.job4j.Tracker.JDBCStorage;

import ru.job4j.Tracker.models.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Task 8.4.2.
 * Update Tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 * .
 */
public class JDBCStorage {

    /**.
     * Is link for connection
     */
    private Connection conn;

    /**.
     * Constructor
     */
    public JDBCStorage() {
        try {
            Settings settings = Settings.getInstance();
            conn = DriverManager.getConnection(settings.getValues("url"));
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**.
     * Adding new item to storage
     * @param item is new item
     * @throws SQLException my be exception
     */
    public void add(Item item) throws SQLException {
        createTable();
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO StorageTracker VALUES (?, ?, ?, ?)");
            st.setString(1, item.getId());
            st.setString(2, item.getName());
            st.setString(3, item.getDesc());
            st.setLong(4, item.getCreated());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**.
     * Deleting item from storage
     * @param id is id the item
     * @throws SQLException my be exception
     */
    public void delete(String id) throws SQLException{
        try {
            Statement st = conn.createStatement();
            st.execute(String.format("DELETE FROM TABLE StorageTracker WHERE id = %s", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**.
     * Getter for all item from storage
     * @return
     * @throws SQLException
     */
    public List<Item> getAll() throws SQLException{
        List<Item> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM StorageTracker");
            while(rs.next()) {
                list.add(new Item(rs.getString("name"), rs.getString("desc"), rs.getLong("created")));
            }
            rs.close();
            st.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**.
     * Create table if not exist
     * @throws SQLException my be exception
     */
    public void createTable() throws SQLException{
        Statement st = null;
        try {
            st = conn.createStatement();
            st.execute("CREATE TABLE StorageTracker (id VARCHAR(25), name VARCHAR(25), " +
                    "desc VARCHAR(100), created LONG) IF NOT EXISTS ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
