package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.job4j.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.io.FileOutputStream;

/**
 * Task 8.4.1.
 * Create worker for my db
 *
 * @author Anton Vasilyuk on 29.12.2017
 * @version 1.0.
 */
public class XML {

    /**.
     * Is logger
     */
    private final static Logger log = LoggerFactory.getLogger(XML.class);

    /**.
     * Create XML with SAX
     * @param list
     * @throws FileNotFoundException
     * @throws XMLStreamException
     */
    public void createXMLSAX(List<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        String root = "entries";
        String child = "entry";
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = null;
        try {
            writer = factory.createXMLStreamWriter(new FileOutputStream("11.xml"));
            writer.writeStartDocument();
            writer.writeStartElement(root);
            while(iter.hasNext()) {
                writer.writeStartElement(child);
                writer.writeStartElement("field");
                writer.writeCharacters(String.valueOf(iter.next()));
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();
        } catch (XMLStreamException e) {
            log.error(e.getMessage() ,e);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**.
     * Create xml with JAXB
     * @param list is data for created
     */
    public void createXMLJAXB(List<Integer> list) {
        List<Entry> array = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            array.add(new Entry(list.get(i)));
        }
        Entries entries = new Entries(array);


        try {
            File file = new File("1.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(entries, file);

        } catch (JAXBException e) {
            log.error(e.getMessage(), e);
        }

    }

    /**.
     * XML reader with JAXB
     * @return list
     * @throws JAXBException my be exception
     */
    public List<String> XMLReaderWithJAXB() {
        File file = new File("1.xml");
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Entries.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Entries entries = (Entries) unmarshaller.unmarshal(file);
            List<Entry> list = entries.getList();
            Iterator<Entry> iter = list.iterator();
            List<String> listNum = new ArrayList<>();
            while (iter.hasNext()) {
                int num = iter.next().getField();
                String temp = String.valueOf(num);
                listNum.add(temp);
            }
            return listNum;
        } catch (JAXBException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }


    /**.
     * Convert xml file to other format xml file.
     * @throws TransformerException my be exception
     */
    public void convertXML() {
        String sourseFile = "1.xml";
        String stileFile = "chapter_005/JDBC/src/main/resourcec/StileForConvert.xml";
        String result = "2.xml";

        TransformerFactory trans = TransformerFactory.newInstance();
        Source xlts = new StreamSource(new File(stileFile));
        Transformer transformer = null;
        try {
            transformer = trans.newTransformer(xlts);
            Source text = new StreamSource(new File(sourseFile));

            transformer.transform(text, new StreamResult(result));
        } catch (TransformerConfigurationException e) {
            log.error(e.getMessage(), e);
        } catch (TransformerException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**.
     * Summ all nubber
     * @return summ all number
     */
    public int summCount() {
        int summ = 0;

        List<String> list = XMLReaderWithJAXB();
        Iterator<String> iter = list.iterator();

        while(iter.hasNext()) {
            String text = iter.next();
            summ = summ + Integer.parseInt(text);
        }
        return summ;
    }

    /**.
     * For printing result
     * @param summ
     */
    public void print(int summ) {
        System.out.printf("%d", summ);
    }
}

