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
    private final static Logger LOG = LoggerFactory.getLogger(DBStore.class);

    /**.
     * It's pool for create connection
     */
    private BasicDataSource SOURCE = new BasicDataSource();

    /**.
     * It's example pattern singleton
     */
    private static DBStore INSTANCE = new DBStore();

    /**.
     * It's my setting
     */
    private final Settings settings = Settings.getInstance();

    /**.
     * It's formating date
     */
    private final SimpleDateFormat sdf = new SimpleDateFormat("d MMM yy, HH:mm");

    /**.
     * It's thread-safe counter for id
     */
    private final AtomicInteger currentID = new AtomicInteger(1);

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
    }

    /**.
     * Method for getting singleton example this class
     * @return
     */
    public static DBStore getInstance() {
        return INSTANCE;
    }

    /**.
     * Method for adding new writes to database
     * @param name
     * @param login
     * @param email
     */
    @Override
    public void add(String name, String login, String email) {
        String query = String.format("INSERT INTO users VALUES(?, ?, ?, ?, ?)");
        Calendar date = Calendar.getInstance();
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(query)
        ) {
            System.out.println(connection);
            st.addBatch();
            st.setInt(1, currentID.get());
            st.setString(2, name);
            st.setString(3, login);
            st.setString(4, email);
            st.setString(5, "Ha");
            st.execute();
            connection.commit();
            currentID.incrementAndGet();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Method for update writes to database
     * @param id
     * @param name
     * @param login
     * @param email
     */
    @Override
    public void update(int id, String name, String login, String email) {
        String query = String.format("UPDATE users SET name='%s', login='%s', email='%s'" +
                " where id=%d", name, login, email, id);
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement();
        ) {
            st.executeUpdate(query);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Method for deleting writes from database
     * @param id
     */
    @Override
    public void delete(int id) {
        String query = String.format("DELETE FROM users where id=%d", id);
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement();
        ) {
            st.executeUpdate(query);
        } catch (Exception e) {
            LOG.error(String.format("Error in mehtod delete - class DBStore"));
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
                String email = rs.getString("email");
                System.out.println(String.format("%d %s %s", idUser, name, login));
                User user = new User(idUser, name, login, email);
                listAllUser.add(user);
            }
            return listAllUser;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return listAllUser;
    }

    /**.
     * Getter for id
     * @return id
     */
    @Override
    public int getId() {
        return currentID.get();
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
                String email = rs.getString("email");
                user = new User(idUser, name, login, email);
                return user;
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return user;
    }
}
