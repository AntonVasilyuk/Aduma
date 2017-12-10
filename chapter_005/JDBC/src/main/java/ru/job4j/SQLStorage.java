package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


public class SQLStorage {
    private final static Logger log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/SQLite/java_a_to_z.db");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM work");
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
