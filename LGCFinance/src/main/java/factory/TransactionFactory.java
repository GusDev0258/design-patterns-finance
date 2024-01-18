/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Author;
import model.Category;
import model.Invoice;
import model.Transaction;

/**
 *
 * @author sonho
 */
public interface TransactionFactory {
    
    public final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    Transaction createTransaction(String name, Double value, String date, String origin, Category category, Author author, String description);
    Invoice createInvoice(String code, Double value);
    
    default Long generateId(String incomeName) {
        var nameCount = incomeName.length();
        var id = String.valueOf(Math.random() * nameCount * 100).replace(".", "");
        return Long.valueOf(id);
    }
    
    default LocalDate parseStringToDate(String date) {
        return LocalDate.parse(date, DATE_FORMAT);
    }
}
