/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import view.HomeView;

/**
 *
 * @author sonho
 */
public class HomeController implements ControllerInterface{
    HomeView homeView;
    TransactionController transactionController; 
    HistoryController historyController; 
    AuthorController authorController;
    CategoryController categoryController;
    
    public HomeController(TransactionController transactionController, HistoryController historyController, AuthorController authorController, CategoryController categoryController) {
        this.homeView = new HomeView();
        this.transactionController = transactionController;
        this.historyController = historyController;
        this.authorController = authorController;
        this.categoryController = categoryController;
        this.transactionController.setHistoryView(this.historyController.getHistoryView());
        this.initHomeButtons();
    }
    
    @Override
    public void openView() {
        this.homeView.showView();
    }
    
    public void openIncomeView() {
        this.homeView.addBtnAction(this.homeView.getBtnIncome(),e -> this.transactionController.openView());
    }
    
    public void openHistoryView() {
        this.homeView.addBtnAction(this.homeView.getBtnHistory(), e -> this.historyController.openView());
    }
    
    public void openAuthorView() {
        this.homeView.addBtnAction(this.homeView.getBtnAddAuthor(), e -> this.authorController.openView());
    }
    
    public void openCategoryView() {
        this.homeView.addBtnAction(this.homeView.getBtnAddCategory(), e -> this.categoryController.openView());
    }
    
    public void initHomeButtons() {
        this.openIncomeView();
        this.openHistoryView();
        this.openAuthorView();
        this.openCategoryView();
    }
}
