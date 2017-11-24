package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.sql.*;
import java.util.Properties;

public class SQLStorage {
    private final static Logger log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/java_from_a_to_z";
        String username = "postgres";
        String password = "password";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars");
            while (rs.next()) {
                System.out.println(String.format("%d %S", rs.getInt("id"),
                        rs.getString("name") ));
            } rs.close();
            st.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
        }
    }
}
