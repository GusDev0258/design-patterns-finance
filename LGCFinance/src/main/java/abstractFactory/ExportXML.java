/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactory;

import java.io.IOException;
import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;

/**
 *
 * @author sonho
 */
public class ExportXML implements ExportObject {

    @Override
    public void writeData(JTable table) throws IOException {
        org.w3c.dom.Document xmlDocument = this.createXMLDocument(table);

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(xmlDocument);
            StreamResult result = new StreamResult("table.xml");
            transformer.transform(source, result);
            System.out.println("XML file written successfully!");
        } catch (TransformerException error) {
            error.printStackTrace();
        }
    }

    private org.w3c.dom.Document createXMLDocument(JTable table) {
        org.w3c.dom.Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("tableData");
            document.appendChild(rootElement);

            for (int i = 0; i < table.getRowCount(); i++) {
                Element rowElement = document.createElement("row");
                rootElement.appendChild(rowElement);

                for (int j = 0; j < table.getColumnCount(); j++) {
                    Element columnElement = document.createElement(table.getColumnName(j));
                    columnElement.appendChild(document.createTextNode(table.getValueAt(i, j).toString()));
                    rowElement.appendChild(columnElement);
                }
            }
        } catch (ParserConfigurationException error) {
            error.printStackTrace();
        }

        return document;
    }

}
