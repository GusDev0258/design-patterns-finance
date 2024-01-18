/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactory.teste;

import model.Expense;
import model.Transaction;

/**
 *
 * @author sonho
 */
public class ExpenseAbstractFactory implements AbstractFactory{

    @Override
    public Transaction getTransaction() {
        return new Expense();
    }
    
}
