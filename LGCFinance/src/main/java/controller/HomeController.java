/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.HomeView;
import view.interfaces.ViewInterface;

/**
 *
 * @author sonho
 */
public class HomeController {
    ViewInterface homeView;
    
    public HomeController() {
        if(homeView == null) {
            homeView = new HomeView();
        }
    }
    public void openView() {
        this.homeView.show();
    }
}
