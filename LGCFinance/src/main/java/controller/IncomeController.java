/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import model.Transaction;
import repository.TransactionRepository;
import view.IncomeView;
import observer.Transactions;

/**
 *
 * @author sonho
 */
public class IncomeController extends Transactions implements ControllerInterface{

    IncomeView incomeView;
    TransactionRepository transactionRepository;
    
    public IncomeController() {
        this.incomeView = new IncomeView();
        this.initIncomeButtons();
    }
    
    @Override
    public void openView() {
        this.incomeView.showView();
    }
    
    public void saveIncome() {
       var value       = this.incomeView.getIncomeValue();
       var name        = this.incomeView.getIncomeName();
       var date        = this.incomeView.getDate();
       var description = this.incomeView.getDescription();
       var author      = this.incomeView.getAuthor();
       var category    = this.incomeView.getCategory();
       var origin      = this.incomeView.getOrigin();
       var income      = new Transaction();
       income.setValue(value);
       income.setName(name);
       income.setDate(date);
       income.setDescription(description);
       income.setOrigin(origin);
       income.setType("income");
    }
    
    public void initIncomeButtons() {
        this.incomeView.addBtnAction(this.incomeView.getAddIncomeButton(), e -> this.saveIncome());
    }
    
    public void initiateButtons() {
        this.incomeView.addBtnAction(this.incomeView.getAddIncomeButton(), e -> addTransaction());
    }
    
    public void addTransaction() {
        var transaction = this.incomeView.getTransaction();
        super.notify(transaction);
    }
}
