/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package factory;

import java.time.LocalDate;
import model.Author;
import model.Category;
import model.Transaction;

/**
 *
 * @author sonho
 */
public interface TransactionFactory {
    
    Transaction createTransaction(String name, Double value, String date, String origin, Category category, Author author, String description);
    public Long generateId(String salt);
    public LocalDate parseStringToDate(String date);
}
