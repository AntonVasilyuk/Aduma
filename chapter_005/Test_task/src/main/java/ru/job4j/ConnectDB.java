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
     * Create logger for class ConnectDB
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
        log.info("Entering to constructor ConnectionDB");
        try {
            settings = Settings.getInstance();
            Class.forName(settings.getValues("jdbc.driver"));
            urlDB = settings.getValues("jdbc.urldb");
            userName = settings.getValues("jdbc.username");
            password = settings.getValues("jdbc.password");
            conn = DriverManager.getConnection(urlDB, userName, password);
            if (conn.isClosed() || conn == null) {
                log.error("Соединение не установлено");
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**.
     * Method for add white to database
     * @param href is link offers
     * @param tmp is date offers
     */
    public void add(int countOff, String href, String tmp) {
        log.info("Adding new writes to database");
        createTable();
        try (PreparedStatement st = conn.prepareStatement
                ("INSERT INTO jobs (id, offers, dates) VALUES (?, ?, ?)"))
        {
            st.setInt(1, countOff);
            st.setString(2, href);
            st.setString(3, tmp);
            st.execute();
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
     * Create table jobs
     */
    public void createTable() {
        log.info("Creating new table");
        try (Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS public.jobs\n" +
                    "(\n" +
                    "    id integer NOT NULL,\n" +
                    "    offers character(1000) COLLATE pg_catalog.\"default\",\n" +
                    "    dates character(50) COLLATE pg_catalog.\"default\",\n" +
                    "    CONSTRAINT jobs_pkey PRIMARY KEY (id)\n" +
                    ")\n" +
                    "WITH (\n" +
                    "    OIDS = FALSE\n" +
                    ")\n" +
                    "TABLESPACE pg_default;\n" +
                    "\n" +
                    "ALTER TABLE public.jobs\n" +
                    "    OWNER to postgres;");
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }
}
