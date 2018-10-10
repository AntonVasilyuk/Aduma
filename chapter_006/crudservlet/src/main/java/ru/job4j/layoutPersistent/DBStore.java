package ru.job4j.layoutPersistent;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DBStore implements Store {


    private final static Logger log = LoggerFactory.getLogger(DBStore.class);
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static DBStore INSTANCE = new DBStore();
    private final Settings settings = Settings.getInstance();
    private final SimpleDateFormat sdf = new SimpleDateFormat("d MMM yy, HH:mm", new Locale("ru", "RU"));

    public DBStore() {
        SOURCE.setUrl(settings.getValues("jdbc.url"));
        SOURCE.setUsername(settings.getValues("jdbc.username"));
        SOURCE.setPassword(settings.getValues("jdbc.password"));
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DBStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(String name, String login, String email) {
        String query = String.format("INSERT INTO users VALUES(?, ?, ?, ?, ?)");
        Calendar date = Calendar.getInstance();
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(query)
        ) {
            st.setString(2, name);
            st.setString(3, login);
            st.setString(4, email);
            st.setString(5, sdf.format(date));
            st.executeUpdate();
        } catch (Exception e) {
            log.error(String.format("Error adding info to data base user %s", name));
        }
    }

    @Override
    public void update(int id, String name, String login, String email) {
        Calendar date = Calendar.getInstance();
        String query = String.format("UPDATE users SET name=%s, login=%s, email=%s, " +
                "date=%s where id=%s", name, login, email, sdf.format(date), String.valueOf(id));
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.prepareStatement(query)
        ) {
        } catch (Exception e) {
            log.error(String.format("Error updateing info to data base user %s", name));
        }
    }

    @Override
    public void delete(int id) {
        String query = String.format("DELETE FROM users where id=%s", String.valueOf(id));
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement();
        ) {
            st.executeUpdate(query);
        } catch (Exception e) {
            log.error(String.format("Error updateing info to data base user"));
        }
    }

    @Override
    public List<User> findByAll() {
        List<User> listAllUser = new ArrayList<>();
        String query = String.format("SELECT * FROM users;");
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"),
                        rs.getString("login"), rs.getString("email"),
                        rs.getString("date"));
                listAllUser.add(user);
            }
            return listAllUser;
        } catch (Exception e) {
            log.error(String.format("Error adding info to data base"));
        }
        return null;
    }

    @Override
    public int getId() {
        String query = String.format("SELECT max(id) FROM users");
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement();
        ) {
            ResultSet rs = st.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            log.error(String.format("Error in searching max id"));
        }
        return -1;
    }

    @Override
    public List<User> getStorage() {
        return findByAll();
    }

    @Override
    public User findById(int id) {
        List<User> list = findByAll();
        for (User user : list) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
