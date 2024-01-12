/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import model.Author;
import view.HomeView;

/**
 *
 * @author sonho
 */
public class HomeController implements ControllerInterface{
    HomeView homeView;
    ControllerInterface incomeController; 
    ControllerInterface historyController; 
    ControllerInterface expenditureController;
    
    
    public HomeController(ControllerInterface incomeController, ControllerInterface historyController, ControllerInterface expenditureController, Author author) {
        this.homeView = new HomeView();
        this.incomeController = incomeController;
        this.historyController = historyController;
        this.expenditureController = expenditureController;
        
        author.addObserver(homeView);
        
        this.initHomeButtons();
    }
    
    @Override
    public void openView() {
        this.homeView.showView();
    }
    
    public void openIncomeView() {
        this.homeView.addBtnAction(this.homeView.getBtnIncome(),e -> this.incomeController.openView());
    }
    
    public void openHistoryView() {
        this.homeView.addBtnAction(this.homeView.getBtnHistory(), e -> this.historyController.openView());
    }
    
    public void openExpenditureView() {
        this.homeView.addBtnAction(this.homeView.getBtnExpenditure(), e -> this.expenditureController.openView());
    }
    
    public void initHomeButtons() {
        this.openIncomeView();
        this.openHistoryView();
        this.openExpenditureView();
    }
}
