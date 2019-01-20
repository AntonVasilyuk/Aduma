package ru.job4j.layoutPersistent;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DBStore implements Store {

    /**.
     * It's logger for this class
     */
    private final static Logger log = LoggerFactory.getLogger(DBStore.class);

    /**.
     * It's pool for create connection
     */
    private final BasicDataSource SOURCE = new BasicDataSource();

    /**.
     * It's example pattern singleton
     */
    private final static DBStore INSTANCE = new DBStore();

    /**.
     * It's my setting
     */
    private final Settings settings = Settings.getInstance();

    /**.
     * It's formating date
     */
    private final SimpleDateFormat sdf = new SimpleDateFormat("d MMM yy, HH:mm");

    /**.
     * Constructor for this class
     */
    private DBStore() {
        SOURCE.setDriverClassName(settings.getValues("jdbc.driver"));
        SOURCE.setUrl(settings.getValues("jdbc.url"));
        SOURCE.setUsername(settings.getValues("jdbc.username"));
        SOURCE.setPassword(settings.getValues("jdbc.password"));

        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        createTable();
    }

    /**.
     * Method for getting singleton example this class
     * @return instance class BDStore
     */
    public static DBStore getInstance() {
        return INSTANCE;
    }

    /**.
     * Method for adding new writes to database
     * @param user it's new user
     */
    @Override
    public void add(User user) {
        Connection connectionRollBack = null;
        String query = String.format("INSERT INTO users(name, login, password, email, time, role, country, city) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
        Calendar date = Calendar.getInstance();
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(query)
        ) {
            connection.setAutoCommit(false);
            connectionRollBack = connection;
            st.addBatch();
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getPassword());
            st.setString(4, user.getPassword());
            st.setTimestamp(5, new Timestamp(date.getTimeInMillis()));
            st.setString(6, user.getRole());
            st.setString(7, user.getCountry());
            st.setString(8, user.getCity());
            st.execute();
            connection.commit();
        } catch (Exception e) {
            if (connectionRollBack != null) {
                try {
                    connectionRollBack.rollback();
                } catch (SQLException e1) {
                    log.error(e1.getMessage(), e1);
                }
            }
            log.error(e.getMessage(), e);
        }
    }

    /**.
     * Method for update writes to database
     * @param user is user for updating
     */
    @Override
    public void update(User user) {
        Connection connectionRollBack = null;
        String query = String.format("UPDATE users SET name=?, login=?, password=?, email=?, role=?, country=?, city=? WHERE id=?;");
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(query);
        ) {
            connection.setAutoCommit(false);
            connectionRollBack = connection;
            st.addBatch();
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getPassword());
            st.setString(4, user.getEmail());
            st.setString(5, user.getRole());
            st.setString(6, user.getCountry());
            st.setString(7, user.getCity());
            st.setInt(8, user.getId());
            st.execute();
            connection.commit();
        } catch (Exception e) {
            if (connectionRollBack != null) {
                try {
                    connectionRollBack.rollback();
                } catch (SQLException e1) {
                    log.error(e1.getMessage(), e1);
                }
            }
            log.error(e.getMessage(), e);
        }
    }

    /**.
     * Method for deleting writes from database
     * @param id
     */
    @Override
    public void delete(int id) {
        Connection connectionRollback = null;
        String query = String.format("DELETE FROM users where id=?;");
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(query);
        ) {
            connection.setAutoCommit(false);
            connectionRollback = connection;
            st.addBatch();
            st.setInt(1, id);
            st.execute();
            connection.commit();
        } catch (Exception e) {
            if (connectionRollback != null) {
                try {
                    connectionRollback.rollback();
                } catch (SQLException e1) {
                    log.error(e1.getMessage(), e1);
                }
            }
        }
    }

    /**.
     * Method for getting all writes from database
     * @return list with all writes
     */
    @Override
    public List<User> findByAll() {
        List<User> listAllUser = new ArrayList<>();
        String query = String.format("SELECT * FROM users;");
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String name = rs.getString("name");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String email = rs.getString("email");
                Timestamp date = rs.getTimestamp("time");
                String role = rs.getString("role");
                String country = rs.getString("country");
                String city = rs.getString("city");
                long time = 0;
                if (date != null) {
                    time = date.getTime();
                }
                User user = new User(idUser, name, login, password, email, time, role, country, city);
                listAllUser.add(user);
            }
            return listAllUser;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return listAllUser;
    }

    /**.
     * Getter for id
     * @return id
     */
    @Override
    public int getId() {
        int id = 0;
        String query = String.format("SELECT max(id) FROM users;");
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("max");
            }
            return id;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return id;
    }

    /**.
     * Method for checking on exist id in database
     * @param id for checking
     * @return return true if exist
     */
    public boolean existID(int id) {
        String query = String.format("SELECT * FROM users WHERE id='%d';", id);
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**.
     * Getter for all writes
     * @return list writes
     */
    @Override
    public List<User> getStorage() {
        return findByAll();
    }

    /**.
     * Method for searching user by id
     * @param id
     * @return user or null
     */
    @Override
    public User findById(int id) {
        User user = null;
        String query = String.format("SELECT * FROM users WHERE id=%d;", id);
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String name = rs.getString("name");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String email = rs.getString("email");
                long date = rs.getTimestamp("date").getTime();
                String role = rs.getString("role");
                String country = rs.getString("country");
                String city = rs.getString("city");
                user = new User(idUser, name, login, password, email, date, role, country, city);
                return user;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return user;
    }

    /**.
     * Getter for counties
     * @return countries
     */
    public List<String> getCountries() {
        List<String> countries = new ArrayList<>();
        String query = "SELECT country FROM location GROUP BY country";
        try (Connection connection = SOURCE.getConnection();
        Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                countries.add(rs.getString("country"));
            }
            return countries;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return countries;
    }

    /**.
     * Getter for cities
     * @param country
     * @return cities
     */
    public List<String> getCity(String country) {
        List<String> city = new ArrayList<>();
        String query = "SELECT city FROM location WHERE country='" + country + "';";
        System.out.println(query);
        try (Connection connection = SOURCE.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                city.add(rs.getString("city"));
            }
            return city;
        } catch (SQLException e) {
           log.error(e.getMessage(), e);
        }
        return city;
    }

    /**.
     * Cheking user on exist
     * @param user for cheking
     * @return result
     */
    @Override
    public boolean isCredentional(User user) {
        String queryLogin = String.format("SELECT * FROM users WHERE login='%s';", user.getLogin());
        String queryEmail = String.format("SELECT * FROM users WHERE email='%s';", user.getEmail());
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rsOne = st.executeQuery(queryLogin);
            while (rsOne.next()) {
                System.out.println("Login exist");
                return false;
            }
            ResultSet rsTwo = st.executeQuery(queryEmail);
            while (rsTwo.next()) {
                System.out.println("email is exist");
                return false;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return true;
    }

    /**.
     * Method for checking needing update
     * @param user
     * @return
     */
    @Override
    public boolean needUpdate(User user) {
        String query = String.format("SELECT * FROM users WHERE id=%d;", user.getId());
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String role = rs.getString("role");
                String country = rs.getString("country");
                String city = rs.getString("city");
                if (!name.equals(user.getName()) || !login.equals(user.getLogin()) || !password.equals(user.getPassword()) ||
                        !email.equals(user.getEmail()) || !role.equals(user.getRole()) || !country.equals(user.getCountry()) ||
                        !city.equals(user.getCity())) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }
    /**.
     * Creating tables if not exist
     */
    public void createTable() {
        String queryCreate = "CREATE TABLE IF NOT EXISTS public.users (id SERIAL PRIMARY KEY, name varchar(50)," +
                "login varchar(50), password varchar(50), email varchar(50), time TIMESTAMP, role varchar(50)," +
                "country varchar(50), city varchar(50));";
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(queryCreate);
        ) {
            connection.setAutoCommit(false);
            statement.execute();
            connection.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**.
     * Cheking role for this user
     * @param login
     * @param password
     * @return true if user is admin
     */
    @Override
    public boolean isExisting(String login, String password) {
        String query = String.format("SELECT * FROM users WHERE login='%s';", login);
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String pass = rs.getString("password");
                System.out.println(pass);
                if (pass.equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**.
     * Cheking role for this user
     * @param login
     * @return true if user is admin
     */
    @Override
    public boolean isAdmin(String login) {
        String query = String.format("SELECT * FROM users WHERE login='%s';", login);
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("role").equals("admin")) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }
}
