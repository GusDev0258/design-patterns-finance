/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactory;

/**
 *
 * @author sonho
 */
public class ExportXMLFactory implements ExportFactory{

    @Override
    public ExportObject createExportObject() {
        return new ExportXML();
    }
    
}
