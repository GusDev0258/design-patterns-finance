/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lgc.lgcfinance;

import controller.AuthorController;
import controller.CategoryController;
import controller.HistoryController;
import controller.HomeController;
import controller.TransactionController;
import observer.Transactions;
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
        CategoryController categoryController = new CategoryController(categoryRepository);
        AuthorController authorController = new AuthorController(authorRepository);
        TransactionController incomeController = new TransactionController();
        var historyController = new HistoryController();
     
        Transactions.addObserver(historyController);

        HomeController homeController = new HomeController(incomeController, historyController, authorController, categoryController);
        homeController.openView();
    }
}
