package ru.job4j.tracker.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.tracker.models.Item;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**.
 * Task 8.4.2.
 * Update tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 * .
 */
public class JDBCStorage {

    /**.
     * @log Create logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(JDBCStorage.class);

    /**.
     * @conn Is link for connection
     */
    private Connection conn;

    /**.
     * @setting Is setting for connection
     */
    private Settings settings;

    /**.
     * Constructor
     */
    public JDBCStorage() {
        try {
            settings = Settings.getInstance();
            conn = DriverManager.getConnection(settings.getValues("url"));
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Adding new item to storage
     * @param item is new item
     * @throws SQLException my be exception
     */
    public void add(Item item) {
        createTable();
        try (PreparedStatement st = conn.prepareStatement(
                "INSERT INTO StorageTracker VALUES (?, ?, ?, ?)")) {
            st.setString(1, item.getId());
            st.setString(2, item.getName());
            st.setString(3, item.getDesc());
            st.setLong(4, item.getCreated());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Deleting item from storage
     * @param id is id the item
     * @throws SQLException my be exception
     */
    public void delete(String id) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.execute(String.format("DELETE FROM TABLE StorageTracker WHERE id = %s", id));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Getter for all item from storage
     * @return all items
     * @throws SQLException may be exception
     */
    public List<Item> getAll() throws SQLException {
        List<Item> list = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM StorageTracker");
            while (rs.next()) {
                list.add(new Item(rs.getString("name"), rs.getString("desc"),
                        rs.getLong("created")));
            }
            rs.close();
            st.close();
            return list;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

    /**.
     * Create table if not exist
     * @throws SQLException my be exception
     */
    public void createTable() {
        try (Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE StorageTracker (id VARCHAR(25), name VARCHAR(25), "
                    + "desc VARCHAR(100), created LONG) IF NOT EXISTS ");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
