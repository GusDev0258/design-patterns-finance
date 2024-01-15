/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import dto.TransactionDTO;
import java.util.ArrayList;
import java.util.List;
import view.HistoryView;
import observer.Observer;
/**
 *
 * @author sonho
 */
public class HistoryController implements ControllerInterface, Observer
{

    HistoryView historyView;
    List<TransactionDTO> transactions = new ArrayList<>();

    public HistoryController() {
        this.historyView = new HistoryView();
    }
    
    @Override
    public void openView() {
        this.historyView.showView();
        loadTable();
    }

    @Override
    public void update(TransactionDTO transaction) {
        transactions.add(transaction);
    }
    
    public void loadTable() {
        this.historyView.loadTable(transactions);
    }
    
    
}
