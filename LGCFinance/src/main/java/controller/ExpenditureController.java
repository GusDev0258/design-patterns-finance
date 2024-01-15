/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import observer.Observer;
import view.ExpenditureView;
import observer.Transactions;

/**
 *
 * @author sonho
 */
public class ExpenditureController extends Transactions implements ControllerInterface {

    ExpenditureView expenditureView;
    
    public ExpenditureController() {
        this.expenditureView = new ExpenditureView();    
        this.initiateButtons();
    }
    
    @Override
    public void openView() {
        this.expenditureView.showView();
    }
    
    public void initiateButtons() {
        this.expenditureView.addBtnAction(this.expenditureView.getBtnAdd(), e -> addTransaction());
    }
    
    public void addTransaction() {
        var transaction = this.expenditureView.getTransaction();
        super.notify(transaction);
    }
}
