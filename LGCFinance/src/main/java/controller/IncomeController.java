/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import java.util.List;
import model.Transaction;
import model.Author;
import observer.AuthorListObserver;
import repository.TransactionRepository;
import view.IncomeView;
import observer.Transactions;
import repository.AuthorRepository;

/**
 *
 * @author sonho
 */
public class IncomeController extends Transactions implements ControllerInterface, AuthorListObserver{

    IncomeView incomeView;
    TransactionRepository transactionRepository;
    AuthorRepository authorRepository = AuthorRepository.getInstance();
    
    public IncomeController() {
        this.incomeView = new IncomeView();
        this.initIncomeButtons();
        authorRepository.addObserver(this);
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
    
    public void populateCbAuthor(List<Author> authors) {
        if(authors == null) return;
        for(Author author: authors) {
            this.incomeView.getCbAuthor().addItem(author);
            System.out.println("populated");
        }
    }

    @Override
    public void update(List<Author> authors) {
        System.out.println("updated!");
        this.populateCbAuthor(authors);
    }
}
