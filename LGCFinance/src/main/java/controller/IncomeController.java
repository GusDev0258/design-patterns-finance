/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import view.IncomeView;
import observer.Transactions;

/**
 *
 * @author sonho
 */
public class IncomeController extends Transactions implements ControllerInterface{

    IncomeView incomeView;
    
    public IncomeController() {
        this.incomeView = new IncomeView();
        initiateButtons();
    }
    
    @Override
    public void openView() {
        this.incomeView.showView();
    }
    
    public void initiateButtons() {
        this.incomeView.addBtnAction(this.incomeView.getAddIncomeButton(), e -> addTransaction());
    }
    
    public void addTransaction() {
        var transaction = this.incomeView.getTransaction();
        super.notify(transaction);
    }
}
