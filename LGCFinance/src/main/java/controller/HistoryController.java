/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import view.HistoryView;

/**
 *
 * @author sonho
 */
public class HistoryController implements ControllerInterface{

    HistoryView historyView;

    public HistoryController() {
        this.historyView = new HistoryView();
    }
    
    @Override
    public void openView() {
        this.historyView.showView();
    }
    
    
}
