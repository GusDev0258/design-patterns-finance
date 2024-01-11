/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import view.ExpenditureView;

/**
 *
 * @author sonho
 */
public class ExpenditureController implements ControllerInterface{

    ExpenditureView expenditureView;
    
    public ExpenditureController() {
        this.expenditureView = new ExpenditureView();    
    }
    
    @Override
    public void openView() {
        this.expenditureView.showView();
    }
    
}
