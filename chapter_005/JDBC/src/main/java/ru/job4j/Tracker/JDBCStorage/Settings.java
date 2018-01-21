package ru.job4j.Tracker.JDBCStorage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Task 8.4.2.
 * Update Tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */

public class Settings {

    private final static Logger log = LoggerFactory.getLogger(Settings.class);

    private static final Settings INSTANCE = new Settings();

    private final Properties properties = new Properties();

    private Settings() {
        try {
            properties.load(new FileInputStream(getClass().getClassLoader().getResource("Storage.properties").getFile()));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static Settings getInstance() {
        return INSTANCE;
    }

    public String getValues(String key) {
        return properties.getProperty(key);
    }
}
