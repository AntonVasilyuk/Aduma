package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;

/**.
 * Task 8.5.1.
 * Connect to a database to record found data
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class ConnectDB {

    /**.
     * Create logger for class ConnectDB
     */
    private static final Logger LOG = LoggerFactory.getLogger(ConnectDB.class);

    /**.
     * Is link for connection
     */
    private Connection conn;

    /**.
     * Is setting for connection
     */
    private Settings settings;

    /**.
     * Is's url for database
     */
    private String urlDB;

    /**.
     * Is's login for database
     */
    private String userName;

    /**.
     * Is's password for database
     */
    private String password;

    /**.
     * Constructor for class ConnectDB
     */
    public ConnectDB() {
        LOG.info("Entering to constructor ConnectionDB");
        try {
            settings = Settings.getInstance();
            Class.forName(settings.getValues("jdbc.driver"));
            urlDB = settings.getValues("jdbc.urldb");
            userName = settings.getValues("jdbc.username");
            password = settings.getValues("jdbc.password");
            conn = DriverManager.getConnection(urlDB, userName, password);
            if (conn.isClosed() || conn == null) {
                LOG.error("Соединение не установлено");
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Method for add white to database
     * @param href is link offers
     * @param tmp is date offers
     * @param countOff is num for exit
     */
    public void add(int countOff, String href, String tmp) {
        LOG.info("Adding new writes to database");
        createTable();
        try (PreparedStatement st = conn.prepareStatement(
                "INSERT INTO jobs (id, offers, dates) VALUES (?, ?, ?)")) {
            st.setInt(1, countOff);
            st.setString(2, href);
            st.setString(3, tmp);
            st.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }

    /**.
     * Create table jobs
     */
    public void createTable() {
        LOG.info("Creating new table");
        try (Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS public.jobs\n"
                    + "(\n"
                    + "    id integer NOT NULL,\n"
                    + "    offers character(1000) COLLATE pg_catalog.\"default\",\n"
                    + "    dates character(50) COLLATE pg_catalog.\"default\",\n"
                    + "    CONSTRAINT jobs_pkey PRIMARY KEY (id)\n"
                    + ")\n" + "WITH (\n" + "    OIDS = FALSE\n"
                    + ")\n" + "TABLESPACE pg_default;\n" + "\n"
                    + "ALTER TABLE public.jobs\n" + "    OWNER to postgres;");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
