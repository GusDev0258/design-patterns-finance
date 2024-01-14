/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lgc.lgcfinance;

import controller.AuthorController;
import controller.ExpenditureController;
import controller.HistoryController;
import controller.HomeController;
import controller.IncomeController;
import controller.interfaces.ControllerInterface;
import data.DataBase;
import repository.AuthorRepository;

/**
 *
 * @author gustavoavelar
 */
public class LGCFinance {

    public static void main(String[] args) {
        DataBase connection = DataBase.getInstance();
        try {
            connection.initConnection("jdbc:postgresql://localhost:5432/lgcfinance","postgres", "postgres");
        } catch( Exception error) {
            System.out.println("Erro:" + error.getMessage());
        }
        AuthorRepository authorRepository = new AuthorRepository();
        ControllerInterface authorController = new AuthorController(authorRepository);
        ControllerInterface incomeController = new IncomeController();
        ControllerInterface historyController = new HistoryController();
        ControllerInterface expenditureController = new ExpenditureController();
        ControllerInterface homeController = new HomeController(incomeController, historyController, expenditureController, authorController);
        homeController.openView();
    }
}
