/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import command.transaction.ExpenseCommand;
import command.transaction.IncomeCommand;
import command.transaction.TransactionCommand;
import command.transaction.TransactionInvoker;
import controller.interfaces.ControllerInterface;
import factory.ExpenseFactory;
import factory.IncomeFactory;
import factory.TransactionFactory;
import java.util.List;
import model.Author;
import model.Category;
import observer.AuthorListObserver;
import observer.CategoryListObserver;
import repository.TransactionRepository;
import view.TransactionView;
import observer.Transactions;
import repository.AuthorRepository;
import repository.CategoryRepository;
import view.HistoryView;

/**
 *
 * @author sonho
 */
public class TransactionController extends Transactions implements ControllerInterface, AuthorListObserver, CategoryListObserver {

    private TransactionView transactionView;
    private AuthorRepository authorRepository = AuthorRepository.getInstance();
    private CategoryRepository categoryRepository = CategoryRepository.getInstance();
    private TransactionFactory incomeFactory = new IncomeFactory();
    private TransactionFactory expenseFactory = new ExpenseFactory();
    private TransactionRepository transactionRepository = TransactionRepository.getInstance();
    private TransactionInvoker transactionInvoker = new TransactionInvoker();
    private HistoryView historyView;

    public TransactionController() {
        this.transactionView = new TransactionView();
        initiateButtons();
        authorRepository.addObserver(this);
        categoryRepository.addObserver(this);
    }

    public void setHistoryView(HistoryView historyView) {
        this.historyView = historyView;
        this.undoTransaction();
    }

    public HistoryView getHistoryView() throws Exception {
        if (this.historyView != null) {
            return this.historyView;
        }
        throw new Exception("A history view must be set");
    }

    @Override
    public void openView() {
        this.transactionView.showView();
    }

    public TransactionView getTransactionView() {
        return transactionView;
    }

    public AuthorRepository getAuthorRepository() {
        return authorRepository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public TransactionFactory getIncomeFactory() {
        return incomeFactory;
    }

    public TransactionFactory getExpenseFactory() {
        return expenseFactory;
    }

    public TransactionRepository getTransactionRepository() {
        return transactionRepository;
    }

    public void saveTransaction() {

        if (!transactionView.isExpense() && !transactionView.isIncome()) {
            System.out.println("Transação inválida");
            return;
        }
        TransactionCommand command;
        if (transactionView.isIncome()) {
            command = new IncomeCommand(this);
        } else {
            command = new ExpenseCommand(this);
        }

        this.transactionInvoker.executeCommand(command);
    }

    public void undoTransaction() {
        try {
            this.getHistoryView().AddMenuItemAction(this.getHistoryView().getUndoMenuItem(), e -> this.transactionInvoker.undoLastCommand());
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public void initiateButtons() {
        this.transactionView.addBtnAction(this.transactionView.getAddTransactionButton(), e -> saveTransaction());
    }

    public void updateAuthorBalance(Author author, Double balance) {
        var authorFound = authorRepository.findById(author.getId());
        authorFound.setBalance(balance);
        authorRepository.saveAuthor(author);
        this.updateAuthorList(authorRepository.findAll());
        //Observer notificar todos que vigiam o saldo da conta.
    }

    public void populateCbAuthor(List<Author> authors) {
        if (authors == null) {
            return;
        }
        this.transactionView.getCbAuthor().removeAllItems();
        for (Author author : authors) {
            this.transactionView.getCbAuthor().addItem(author);
            System.out.println("populated");
        }
    }

    public void populateCbCategory(List<Category> categories) {
        if (categories == null) {
            return;
        }
        this.transactionView.getCbCategory().removeAllItems();
        for (Category category : categories) {
            this.transactionView.getCbCategory().addItem(category);
        }
    }

    @Override
    public void updateAuthorList(List<Author> authors) {
        System.out.println("updated!");
        this.populateCbAuthor(authors);
    }

    @Override
    public void updateCategoryList(List<Category> categories) {
        this.populateCbCategory(categories);
    }
}
