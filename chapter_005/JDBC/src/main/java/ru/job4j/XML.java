package ru.job4j;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.io.FileOutputStream;

/**
 * Task 8.4.1.
 * Create worker for db
 *
 * @author Anton Vasilyuk on 29.12.2017
 * @version 1.0.
 */
public class XML {

    /**.
     * Create XML file from our db
     * @param list is list all writes
     */
    public void createXMLOne(List<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        Document doc = null;
        Element el = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.newDocument();
            Element entries = doc.createElement("entries");
            while (iter.hasNext()) {
                el = doc.createElement("entry");
                Element child = doc.createElement("field");
                child.setTextContent(iter.next().toString());
                el.appendChild(child);
                entries.appendChild(el);
            }
            doc.appendChild(entries);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                tr.transform(new DOMSource(doc),
                        new StreamResult(new FileOutputStream("chapter_005/JDBC/src/main/resourcec/1.xml")));

            } catch (TransformerException | IOException te) {
                System.out.println(te.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }

    /**.
     * XML reader
     * @return list writes
     */
    public List<String> readerXML() {
        List<String> list = new LinkedList<>();
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse("chapter_005/JDBC/src/main/resourcec/1.xml");
            NodeList node = doc.getElementsByTagName("FIELD");
            for (int i = 0; i < node.getLength(); i++) {
                list.add(node.item(i).getTextContent());
            }
            return list;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**.
     * Convert xml file to other format xml file.
     * @throws TransformerException my be exception
     */
    public void convertXML() throws TransformerException {
        String sourseFile = "chapter_005/JDBC/src/main/resourcec/1.xml";
        String stileFile = "chapter_005/JDBC/src/main/resourcec/StileForConvert.xml";
        String result = "chapter_005/JDBC/src/main/resourcec/2.xml";

        TransformerFactory trans = TransformerFactory.newInstance();
        Source xlts = new StreamSource(new File(stileFile));
        Transformer transformer = trans.newTransformer(xlts);
        Source text = new StreamSource(new File(sourseFile));

        transformer.transform(text, new StreamResult(result));
    }

    /**.
     * Summ all nubber
     * @return summ all number
     */
    public int summCount() {
        int summ = 0;
        String adress = "chapter_005/JDBC/src/main/resourcec/2.xml";
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(adress);
            NodeList node = doc.getElementsByTagName("entry");

            for (int i = 0; i < node.getLength(); i++) {
                String text = node.item(i).getAttributes().getNamedItem("field").getNodeValue();
                summ = summ + Integer.parseInt(text);
            }
            return summ;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
    /**.
     * For printing result
     * @param summ
     */
    public void print(int summ) {
        System.out.printf("%d", summ);
    }
}

