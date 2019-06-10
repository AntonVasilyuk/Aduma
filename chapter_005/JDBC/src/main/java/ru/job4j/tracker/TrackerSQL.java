package ru.job4j.tracker;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.job4j.models.Item;

import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**.
 * Update tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */
public class TrackerSQL implements ITracker, AutoCloseable {

    /**.
     * @LOG Create logger
     */
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class);

    /**.
     * @conn Is link for connection
     */
    private Connection conn;

    /**.
     * Constructor
     */
    public TrackerSQL() {
        if (init()) {
            createTable();
        }
    }

    /**.
     * Method for initialise table and database
     * @return result connection
     */
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("Storage.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("jdbc.driver"));
            this.conn = DriverManager.getConnection(
                    config.getProperty("jdbc.url"),
                    config.getProperty("jdbc.username"),
                    config.getProperty("jdbc.password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.conn != null;
    }

    /**.
     * Adding new item to storage
     * @param item is new item
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement st = conn.prepareStatement(
                "INSERT INTO StorageTracker VALUES (?, ?, ?, ?)")) {
            st.setString(1, item.getId());
            st.setString(2, item.getName());
            st.setString(3, item.getDesc());
            st.setLong(4, item.getCreated());
            st.executeUpdate();
            item.setId(lastId());
            return item;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    /**.
     * Replase item to database
     * @param id is id for replace
     * @param item is item for raplace
     */
    @Override
    public void replace(String id, Item item) {
        try (Statement st = conn.createStatement()) {
            st.execute(String.format("UPDATE TABLE StorageTracker SET name=%s, desk=%s, created=%d,  WHERE id = %s",
                    item.getName(), item.getDesc(), item.getCreated(), id));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Deleting item from storage
     * @param id is id the item
     */
    @Override
    public void delete(String id) {
        try (Statement st = conn.createStatement()) {
            st.execute(String.format("DELETE FROM TABLE StorageTracker WHERE id = %s", id));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Find items by name
     * @param key is key for search
     * @return list items
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM StorageTracker WHERE name=%s", key));
            while (rs.next()) {
                list.add(new Item(rs.getString("name"), rs.getString("desc"),
                        rs.getLong("created")));
            }
            rs.close();
            return list;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

    /**.
     * Find item by id
     * @param id is id for searching
     * @return item
     */
    @Override
    public Item findById(String id) {
        Item item = null;
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM StorageTracker WHERE id=%s", id));
            while (rs.next()) {
                item = new Item(rs.getString("name"), rs.getString("desc"),
                        rs.getLong("created"));
            }
            rs.close();
            return item;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

    /**.
     * Getter for all item from storage
     * @return all items
     */
    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM StorageTracker");
            while (rs.next()) {
                list.add(new Item(rs.getString("name"), rs.getString("desc"),
                        rs.getLong("created")));
            }
            rs.close();
            return list;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

    /**.
     * Create table if not exist
     */
    public void createTable() {
        try (Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE StorageTracker (id VARCHAR(25), name VARCHAR(25), "
                    + "desc VARCHAR(100), created LONG) IF NOT EXISTS ");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Close connection
     * @throws Exception may be exception
     */
    @Override
    public void close() throws Exception {
        conn.close();
    }

    /**.
     * Last added id to database
     * @return id
     */
    public String lastId() {
        String id = null;
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT max(id) FROM StorageTracker");
            while (rs.next()) {
                id = rs.getString("id");
            }
            rs.close();
            return id;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return id;
    }
}
