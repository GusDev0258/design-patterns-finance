/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Author;
import model.Category;
import model.Income;
import model.Transaction;

/**
 *
 * @author sonho
 */
public class IncomeFactory implements TransactionFactory{
    
    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d/MM/yyyy");
    
    @Override
    public Transaction createTransaction(String name, Double value, String date, String origin, Category category, Author author, String description) {
        Income income = new Income();
        income.setId(this.generateId(name));
        income.setName(name);
        income.setValue(value);
        income.setDate(this.parseStringToDate(date));
        income.setAuthor(author);
        income.setCategory(category);
        income.setDescription(description);
        income.setOrigin(origin);
        return income;
    }
    
    @Override
    public Long generateId(String incomeName) {
        var nameCount = incomeName.length();
        var id = String.valueOf(Math.random() * nameCount * 100).replace(".", "");
        return Long.valueOf(id);
    }
    
    @Override
    public LocalDate parseStringToDate(String date) {
        return LocalDate.parse(date, DATE_FORMAT);
    }
}
