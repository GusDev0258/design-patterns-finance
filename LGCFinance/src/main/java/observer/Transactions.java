/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import java.util.List;
import dto.TransactionDTO;
import java.util.ArrayList;

/**
 *
 * @author luiz
 */
public abstract class Transactions {
    private static List<Observer> observers = new ArrayList<>(); 
    
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    public void notify(TransactionDTO payment) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(payment);
        }
    }
    
    
}
