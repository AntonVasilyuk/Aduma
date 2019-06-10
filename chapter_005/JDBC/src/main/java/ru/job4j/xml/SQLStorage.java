package ru.job4j.xml;


import org.apache.log4j.Logger;

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
    private static final Logger LOG = Logger.getLogger(SQLStorage.class);

    /**.
     * Point for enter in this app
     * @param args its default argument
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
