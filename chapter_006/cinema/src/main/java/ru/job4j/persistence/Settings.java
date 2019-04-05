package ru.job4j.persistence;



import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class for load setting for working this apps.
 *
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 02.03.2019
 */
public class Settings {

    /**.
     * It's logger
     */
    private static final Logger LOG = Logger.getLogger(Settings.class);

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
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Instance for singleton pattern class the Setting
     * @return return instance for this class
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
