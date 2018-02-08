package ru.job4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by administrator on 14.01.2018.
 */
public class Settings {
    private static final Settings INSTANCE = new Settings();

    private final Properties properties = new Properties();

    private Settings() {
        try {
            properties.load(new FileInputStream(getClass().getClassLoader().getResource("Storage.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Settings getInstance() {
        return INSTANCE;
    }

    public String getValues(String key) {
        return properties.getProperty(key);
    }
}
