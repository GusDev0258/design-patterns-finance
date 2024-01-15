/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lgc.lgcfinance;

import controller.ExpenditureController;
import controller.HistoryController;
import controller.HomeController;
import controller.IncomeController;
import controller.interfaces.ControllerInterface;
import model.Author;
import observer.Transactions;

/**
 *
 * @author gustavoavelar
 */
public class LGCFinance {

    public static void main(String[] args) {
        Author autor = new Author();
        ControllerInterface incomeController = new IncomeController();
        var historyController = new HistoryController();
        ControllerInterface expenditureController = new ExpenditureController();
        ControllerInterface homeController = new HomeController(incomeController, historyController, expenditureController, autor);
        
        Transactions.addObserver(historyController);
        homeController.openView();
    }
}
