/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import view.IncomeView;

/**
 *
 * @author sonho
 */
public class IncomeController implements ControllerInterface{

    IncomeView incomeView;
    
    public IncomeController() {
        this.incomeView = new IncomeView();
    }
    
    @Override
    public void openView() {
        this.incomeView.showView();
    }
    
}
