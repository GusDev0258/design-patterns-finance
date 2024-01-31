/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import abstractFactory.ExportCSVFactory;
import abstractFactory.ExportFactoryUtil;
import abstractFactory.ExportPDFFactory;
import abstractFactory.ExportXMLFactory;
import javax.swing.JTable;

/**
 *
 * @author sonho
 */
public class ExportFacade {

    public static void ExportPDF(JTable table) {
        var pdfFactory = new ExportPDFFactory();
        ExportFactoryUtil.exportData(pdfFactory, table);
    }

    public static void ExportCSV(JTable table) {
        var csvFactory = new ExportCSVFactory();
        ExportFactoryUtil.exportData(csvFactory, table);
    }

    public static void ExportXML(JTable table) {
        var xmlFactory = new ExportXMLFactory();
        ExportFactoryUtil.exportData(xmlFactory, table);
    }
}
