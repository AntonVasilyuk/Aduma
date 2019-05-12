package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger LOG = LoggerFactory.getLogger(SQLStorage.class);

    /**.
     * Point for enter in this app
     * @param args its default argument
     * @throws SQLException my be exception
     * @throws TransformerException my be exception
     */
    public static void main(String[] args) {

        MainClass main = new MainClass();
        XML xmlCreater = new XML();

        main.fillMyDB();
        xmlCreater.createXMLSAX(main.getDBWrite());
        xmlCreater.createXMLJAXB(main.getDBWrite());
        main.close();
        xmlCreater.convertXML();
        xmlCreater.print(xmlCreater.summCount());
    }
}
