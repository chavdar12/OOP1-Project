package tu.varna.util;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.jdom2.output.XMLOutputter;
import tu.varna.table.impl.HashBasedImpl;
import tu.varna.table.impl.Table;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class FileUtil {
    public static void saveTable(Table<String, String, String> table, String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMBuilder domBuilder = new DOMBuilder();
            Document document = domBuilder.build(builder.newDocument());
            document.setRootElement(table.toXml());
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.output(document, new FileWriter(fileName));
        } catch (Exception e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }

    public static Table<String, String, String> loadTable(String fileName) {
        Table<String, String, String> table = new HashBasedImpl<>();
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            DOMBuilder domBuilder = new DOMBuilder();
            Document document = domBuilder.build(doc);
            Element root = document.getRootElement();
            List<Element> rows = root.getChildren();
            for (Element row : rows) {
                String rowKey = row.getAttributeValue("key");
                List<Element> columns = row.getChildren();
                for (Element column : columns) {
                    String columnKey = column.getAttributeValue("key");
                    String value = column.getChildText("value");
                    table.put(rowKey, columnKey, value);
                }
            }
        } catch (Exception e) {
            System.out.printf("Error: %s", e.getMessage());
        }
        return table;
    }
}
