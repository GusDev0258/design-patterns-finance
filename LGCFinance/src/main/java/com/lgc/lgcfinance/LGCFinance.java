/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lgc.lgcfinance;

import controller.ExpenditureController;
import controller.HistoryController;
import controller.HomeController;
import controller.IncomeController;
import controller.interfaces.ControllerInterface;

/**
 *
 * @author gustavoavelar
 */
public class LGCFinance {

    public static void main(String[] args) {
        ControllerInterface incomeController = new IncomeController();
        ControllerInterface historyController = new HistoryController();
        ControllerInterface expenditureController = new ExpenditureController();
        ControllerInterface homeController = new HomeController(incomeController, historyController, expenditureController);
        homeController.openView();
    }
}
