package ru.job4j.tracker.storage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**.
 * Task 8.4.2.
 * Update tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */

public class Settings {

    /**.
     * @LOG is logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(Settings.class);

    /**.
     * @INSTANCE is instance for setting
     */
    private static final Settings INSTANCE = new Settings();

    /**.
     * @properties is instance for Properties
     */
    private final Properties properties = new Properties();

    /**.
     * Constructor
     */
    private Settings() {
        try {
            properties.load(new FileInputStream(getClass().getClassLoader().getResource("storage.properties").getFile()));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Get example for thes class
     * @return INSTANCE
     */
    public static Settings getInstance() {
        return INSTANCE;
    }

    /**.
     * Getter for value from file properties
     * @param key key for getting value
     * @return value
     */
    public String getValues(String key) {
        return properties.getProperty(key);
    }
}
