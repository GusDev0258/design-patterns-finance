/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import abstractFactory.ExportCSVFactory;
import abstractFactory.ExportFactoryUtil;
import abstractFactory.ExportPDFFactory;
import controller.interfaces.ControllerInterface;
import facade.ExportFacade;
import model.Transaction;
import java.util.ArrayList;
import java.util.List;
import view.HistoryView;
import observer.Observer;

/**
 *
 * @author sonho
 */
public class HistoryController implements ControllerInterface, Observer {

    HistoryView historyView;
    private static final List<Transaction> transactions = new ArrayList<>();

    public HistoryController() {
        this.historyView = new HistoryView();
        initiateButtons();
    }

    public HistoryView getHistoryView() {
        return this.historyView;
    }

    @Override
    public void openView() {
        this.historyView.showView();
        loadTable();
    }

    @Override
    public void update(Transaction transaction) {
        transactions.add(transaction);
        loadTable();
    }

    @Override
    public void updateRemoved(Transaction transaction) {
        transactions.remove(transaction);
        loadTable();
    }

    public void loadTable() {
        this.historyView.loadTable(transactions);
    }

    public void initiateButtons() {
        historyView.addMenuItemAction(historyView.getExportPDFMenuItem(), e -> actionExportPDF());
        historyView.addMenuItemAction(historyView.getExportCSVMenuItem(), e -> actionExportCSV());
        historyView.addMenuItemAction(historyView.getExportXMLMenuItem(), e -> actionExportXML());
    }

    public void actionExportPDF() {
        ExportFacade.ExportPDF(this.getHistoryView().getHistoryTable());
    }

    public void actionExportCSV() {
        ExportFacade.ExportCSV(this.getHistoryView().getHistoryTable());
    }

    public void actionExportXML() {
        ExportFacade.ExportXML(this.getHistoryView().getHistoryTable());
    }

}
