/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lgc.lgcfinance;

import controller.AuthorController;
import controller.CategoryController;
import controller.ExpenditureController;
import controller.HistoryController;
import controller.HomeController;
import controller.IncomeController;
import controller.interfaces.ControllerInterface;
import repository.AuthorRepository;
import repository.CategoryRepository;

/**
 *
 * @author gustavoavelar
 */
public class LGCFinance {

    public static void main(String[] args) {
        
        var authorRepository = AuthorRepository.getInstance();
        var categoryRepository = CategoryRepository.getInstance();
        ControllerInterface categoryController = new CategoryController(categoryRepository);
        ControllerInterface authorController = new AuthorController(authorRepository);
        ControllerInterface incomeController = new IncomeController();
        ControllerInterface historyController = new HistoryController();
        ControllerInterface expenditureController = new ExpenditureController();
        ControllerInterface homeController = new HomeController(incomeController, historyController, expenditureController, authorController, categoryController);
        homeController.openView();
    }
}
