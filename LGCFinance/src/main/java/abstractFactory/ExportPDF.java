/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JTable;

/**
 *
 * @author sonho
 */
public class ExportPDF implements ExportObject {

    @Override
    public void writeData(JTable table) throws IOException {
        Document document = new Document();
        
        try {
            PdfWriter.getInstance(document, new FileOutputStream("table.pdf"));
            document.open();
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(table.getColumnName(i));
            }
            
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    pdfTable.addCell(table.getValueAt(i, j).toString());
                }
            }
            
            document.add(pdfTable);
        } catch (DocumentException error) {
            error.printStackTrace();
        } catch (Exception error) {
            error.printStackTrace();
        } finally {
            document.close();
        }
    }

}
