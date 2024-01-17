/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import model.Author;
import model.Category;
import model.Income;
import model.Transaction;

/**
 *
 * @author sonho
 */
public class IncomeFactory implements TransactionFactory{
    
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
}
