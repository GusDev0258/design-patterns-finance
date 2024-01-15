/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.ArrayList;
import java.util.List;
import observer.Observer;
import dto.TransactionDTO;

/**
 *
 * @author gustavoavelar
 */

public class Author {
    
    private List<Observer> observers = new ArrayList<>();
    
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }
    
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }
    
    private Long id;
    
    private String name;

    private List<Transaction> payments;
    
    private Double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transaction> getPayments() {
        return payments;
    }

    public void setPayments(List<Transaction> payments) {
        this.payments = payments;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    private void notifyObservers(TransactionDTO transaction) {
        for (Observer observer: observers) {
            observer.update(transaction);
        }
    }
    @Override
    public String toString() {
        return " " + this.getName() + " Saldo: " + this.getBalance() + " ";
    }
}
