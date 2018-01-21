package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Task 8.4.1.
 * Create main class for connection and filling this database
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class MainClass {

    /**.
     * Create logger
     */
    private final static Logger log = LoggerFactory.getLogger(MainClass.class);

    /**.
     * Its count writes to db
     */
    private int numCount;

    /**.
     * Its link for writing from consol
     */
    private Concole concole;

    /**.
     * Its link for connection with this db
     */
    Connection conn;

    /**.
     * Its query for output tables
     */
    String quere = "SELECT * FROM TEST";

    /**.
     * Its text query for create db
     */
    String create = "CREATE TABLE TEST (FIELD INT) IF NOT EXISTS";

    /**.
     * Its text query for paste values
     */
    String insert = "INSERT INTO TEST VALUES (?)";

    /**.
     * Its text query for delete writes
     */
    String delete = "DELETE FROM TEST";

    /**.
     * Constructor
     */
    public MainClass() {
        concole = new Concole();
        numCount = concole.ask("Please enter count:");
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/administrator/java_from_a_to_z.db");
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**.
     * Fill writes to db
     */
    public void fillMyDB() {
        dell();
        try (Statement statement = conn.createStatement();)
        {
            for (int i = 0; i < numCount; i++) {
                statement.addBatch(String.format("INSERT INTO TEST(FIELD) VALUES (%d)", i));
            }
            statement.executeBatch();
            conn.commit();
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
     * Delete all writes from db
     * @throws SQLException my be exception
     */
    public void dell() {
        try (Statement st = conn.createStatement()){
            st.execute(delete);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                log.error(e1.getMessage(), e1);
            }
            log.error(e.getMessage(), e);
        }
    }

    /**.
     * Getter for writes this db
     * @return list writes form db
     * @throws SQLException my be exception
     */
    public List<Integer> getDBWrite() {
        List<Integer> list = new LinkedList<>();
        try (Statement st = conn.createStatement();) {
            ResultSet rs = st.executeQuery(quere);
                while (rs.next()) {
                    list.add(rs.getInt("FIELD"));
                }
            conn.commit();
            rs.close();
            return list;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
                log.error(e1.getMessage(), e1);
            }
            return null;
        }
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
