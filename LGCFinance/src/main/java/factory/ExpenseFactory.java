/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import model.Author;
import model.Category;
import model.Transaction;
import model.Expense;

/**
 *
 * @author sonho
 */
public class ExpenseFactory implements TransactionFactory{

    @Override
    public Transaction createTransaction(String name, Double value, String date, String origin, Category category, Author author, String description) {
        Expense expense = new Expense();
        expense.setId(this.generateId(name));
        expense.setName(name);
        expense.setValue(value);
        expense.setDate(this.parseStringToDate(date));
        expense.setAuthor(author);
        expense.setCategory(category);
        expense.setDescription(description);
        expense.setOrigin(origin);
        return expense;
    }
}
