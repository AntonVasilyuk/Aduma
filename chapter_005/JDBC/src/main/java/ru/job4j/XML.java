package ru.job4j;

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
     * Create XML file from our db with DOM
     * @param list is list all writes
     */
    public void createXMLDOM(List<Integer> list) {
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
                        new StreamResult(new FileOutputStream("1.xml")));

            } catch (TransformerException | IOException te) {
                System.out.println(te.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }

    /**.
     * Create XML with SAX
     * @param list
     * @throws FileNotFoundException
     * @throws XMLStreamException
     */
    public void createXMLSAX(List<Integer> list) throws FileNotFoundException, XMLStreamException {
        Iterator<Integer> iter = list.iterator();
        String root = "entries";
        String child = "entry";
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("11.xml"));
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
            File file = new File("111.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(entries, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    /**.
     * XML reader with DOM
     * @return list writes
     */
    public List<String> readerXML(String adress, String teg, String values) {
        List<String> list = new LinkedList<>();
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(adress);
            NodeList node = doc.getElementsByTagName(teg);
            for (int i = 0; i < node.getLength(); i++) {
                list.add(node.item(i).getAttributes().getNamedItem(values).getNodeValue());
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
     * XML reader with JAXB
     * @return list
     * @throws JAXBException my be exception
     */
    public List<String> XMLReaderWithJAXB() throws JAXBException {
        File file = new File("1.xml");
        JAXBContext context = JAXBContext.newInstance(Entries.class);

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
    }


    /**.
     * Convert xml file to other format xml file.
     * @throws TransformerException my be exception
     */
    public void convertXML() throws TransformerException {
        String sourseFile = "1.xml";
        String stileFile = "chapter_005/JDBC/src/main/resourcec/StileForConvert.xml";
        String result = "2.xml";

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
        String adress = "2.xml";
        String teg = "entry";
        String values = "field";

        List<String> list = readerXML(adress, teg, values);
        Iterator<String> iter = list.iterator();

        while(iter.hasNext()) {
            String text = iter.next();
            summ = summ + Integer.parseInt(text);
        }
        return summ;
    }

    /**.
     * Summ all nubber with JAXB
     * @return summ all number
     */
    public int summCountJAXB() throws JAXBException {
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

