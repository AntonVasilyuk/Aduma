package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.TransformerException;
import java.sql.*;

/**.
 * Task 8.4.1.
 * Create SqlStorage
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */

public class SQLStorage {

    /**.
     * Create logger.
     */
    private final static Logger log = LoggerFactory.getLogger(SQLStorage.class);

    /**.
     * Point for enter in this app
     * @param args its default argument
     * @throws SQLException my be exception
     * @throws TransformerException my be exception
     */
    public static void main(String[] args) throws SQLException, TransformerException {

        MainClass main = new MainClass();
        XML xmlCreater = new XML();

        main.fillMyDB();
        xmlCreater.createXMLOne(main.getDBWrite());
        xmlCreater.convertXML();
        xmlCreater.print(xmlCreater.summCount());
    }
}
