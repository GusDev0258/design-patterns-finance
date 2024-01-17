/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactory;

import java.io.IOException;
import javax.swing.JTable;

/**
 *
 * @author sonho
 */
public class ExportFactoryUtil {
    public static void exportData(ExportFactory factory, JTable table) {
        ExportObject exportObject = factory.createExportObject();
        try {
            exportObject.writeData(table);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
