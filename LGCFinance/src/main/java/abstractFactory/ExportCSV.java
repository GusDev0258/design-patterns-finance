/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactory;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;

/**
 *
 * @author sonho
 */
public class ExportCSV implements ExportObject {

    @Override
    public void writeData(JTable table) throws IOException {
        String csvFile = "table_opencsv.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            String[] headers = new String[table.getColumnCount()];
            for (int i = 0; i < table.getColumnCount(); i++) {
                headers[i] = table.getColumnName(i);
            }
            writer.writeNext(headers);

            for (int i = 0; i < table.getRowCount(); i++) {
                String[] row = new String[table.getColumnCount()];
                for (int j = 0; j < table.getColumnCount(); j++) {
                    row[j] = table.getValueAt(i, j).toString();
                }
                writer.writeNext(row);
            }

            System.out.println("CSV file written successfully!");

        } catch (IOException error) {
            error.printStackTrace();
        }
    }

}
