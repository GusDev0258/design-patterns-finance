/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import factory.IncomeFactory;
import factory.TransactionFactory;
import java.util.List;
import model.Income;
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
    AuthorRepository authorRepository = AuthorRepository.getInstance();
    TransactionFactory incomeFactory = new IncomeFactory();
    TransactionRepository transactionRepository = TransactionRepository.getInstance();
    
    public IncomeController() {
        this.incomeView = new IncomeView();
        initiateButtons();
        authorRepository.addObserver(this);
    }
    
    @Override
    public void openView() {
        this.incomeView.showView();
    }
    
    public void saveIncome() {
        var income = incomeFactory.createTransaction(this.incomeView.getIncomeName(), 
                this.incomeView.getIncomeValue(), 
                this.incomeView.getDate(), 
                this.incomeView.getOrigin(), 
                this.incomeView.getCategory(), 
                this.incomeView.getAuthor(), 
                this.incomeView.getDescription());
        transactionRepository.saveTransaction(income);  
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
