package ru.job4j.tracker;

import org.junit.Test;

import org.junit.Assert;

import static org.hamcrest.Matchers.is;

/**.
 * Test TrackerSql
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */
public class TrackerSQLTest {

    /**.
     * Test created connection
     */
    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        Assert.assertThat(sql.init(), is(true));
    }
}