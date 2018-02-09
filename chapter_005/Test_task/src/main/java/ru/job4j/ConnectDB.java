package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**.
 * Task 8.5.1.
 * Connect to a database to record found data
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class ConnectDB {

    /**.
     * Create logger
     */
    private final static Logger log = LoggerFactory.getLogger(ConnectDB.class);

    /**.
     * Is link for connection
     */
    private Connection conn;

    /**.
     * Is setting for connection
     */
    private Settings settings;

    /**.
     * Constructor
     */
    public ConnectDB() {
        try {
            settings = Settings.getInstance();
            conn = DriverManager.getConnection(settings.getValues("url"));
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**.
     * Method for add white to db
     * @param href is link offers
     * @param tmp is date offers
     */
    public void add(String href, Timestamp tmp) {
        createTable();
        try (PreparedStatement st = conn.prepareStatement
                ("INSERT INTO SampleSite (href, time_created) VALUES (?, ?) IF NOT EXISTS "))
        {
            st.setString(1, href);
            st.setTimestamp(2, tmp);
            st.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }

    /**.
     * Create table if not exist
     * @throws SQLException my be exception
     */
    public void createTable() {
        try (Statement st = conn.createStatement()){
            st.execute("CREATE TABLE SampleSite (id INTEGER PRIMARY KEY AUTOINCREMENT, href VARCHAR(1000), " +
                    "time_created TIMESTAMP) IF NOT EXISTS");
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }


    public void printDB() {
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM SampleSite");
            while (rs.next()) {
                System.out.printf("%sn", rs.getString(0));
            }
            rs.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }
}
