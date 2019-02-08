package ru.job4j.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by administrator on 14.01.2018.
 */
public class Settings {

    /**.
     * It's logger
     */
    private final static Logger log = LoggerFactory.getLogger(Settings.class);

    /**.
     * Object for sigleton pattern
     */
    private static final Settings INSTANCE = new Settings();

    /**.
     * it.s propertis for this programm
     */
    private final Properties properties = new Properties();

    /**.
     * Constructor for class Settiong
     */
    private Settings() {
        try {
            properties.load(new FileInputStream(getClass().getClassLoader().getResource("Storage.properties").getFile()));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**.
     * Instance for singleton pattern class the Setting
     * @return
     */
    public static Settings getInstance() {
        return INSTANCE;
    }

    /**.
     * Method for returned value from properties
     * @param key is key for properties
     * @return value
     */
    public String getValues(String key) {
        return properties.getProperty(key);
    }
}
