/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;
import controller.interfaces.ControllerInterface;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import model.Transaction;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import view.HistoryView;
import observer.Observer;
import org.w3c.dom.Element;

/**
 *
 * @author sonho
 */
public class HistoryController implements ControllerInterface, Observer {

    HistoryView historyView;
    private static final List<Transaction> transactions = new ArrayList<>();

    public HistoryController() {
        this.historyView = new HistoryView();
        initiateButtons();
    }
    
    public HistoryView getHistoryView() {
        return this.historyView;
    }

    @Override
    public void openView() {
        this.historyView.showView();
        loadTable();
    }

    @Override
    public void update(Transaction transaction) {
        transactions.add(transaction);
        loadTable();
    }

    @Override
    public void updateRemoved(Transaction transaction) {
        transactions.remove(transaction);
        loadTable();
    }

    public void loadTable() {
        this.historyView.loadTable(transactions);
    }
    
    public void initiateButtons() {
        historyView.addMenuItemAction(historyView.getExportPDFMenuItem(), e -> addActionExportPDF()); 
        historyView.addMenuItemAction(historyView.getExportCSVMenuItem(), e -> addActionExportCSV());
        historyView.addMenuItemAction(historyView.getExportXMLMenuItem(), e -> addActionExportXML());
    }
    
    public void addActionExportPDF() {
        var historyTable = historyView.getHistoryTable();

        Document document = new Document() ;
        try {
            PdfWriter.getInstance(document, new FileOutputStream("table.pdf"));
            document.open();

            PdfPTable pdfTable = new PdfPTable(historyTable.getColumnCount());
            // Add headers
            for (int i = 0; i < historyTable.getColumnCount(); i++) {
                pdfTable.addCell(historyTable.getColumnName(i));
            }
            // Add data
            for (int i = 0; i < historyTable.getRowCount(); i++) {
                for (int j = 0; j < historyTable.getColumnCount(); j++) {
                    pdfTable.addCell(historyTable.getValueAt(i, j).toString());
                }
            }
            document.add(pdfTable);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
    
    public void addActionExportCSV() {
        JTable historyTable = historyView.getHistoryTable();
        String csvFile = "table_opencsv.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            // Write headers
            String[] headers = new String[historyTable.getColumnCount()];
            for (int i = 0; i < historyTable.getColumnCount(); i++) {
                headers[i] = historyTable.getColumnName(i);
            }
            writer.writeNext(headers);

            for (int i = 0; i < historyTable.getRowCount(); i++) {
                String[] row = new String[historyTable.getColumnCount()];
                for (int j = 0; j < historyTable.getColumnCount(); j++) {
                    row[j] = historyTable.getValueAt(i, j).toString();
                }
                writer.writeNext(row);
            }

            System.out.println("CSV file written successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void addActionExportXML() {
        JTable myTable = historyView.getHistoryTable(); 
        org.w3c.dom.Document xmlDocument = createXMLDocument(myTable);

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(xmlDocument);
            StreamResult result = new StreamResult("table.xml");
            transformer.transform(source, result);
            System.out.println("XML file written successfully!");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    
    private static org.w3c.dom.Document createXMLDocument(JTable table) {
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
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return document;
    }
}
