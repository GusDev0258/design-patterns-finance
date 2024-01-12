/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view.interfaces;

/**
 *
 * @author sonho
 */
public interface BalanceObserver {
    public void updateBalance(Double amount);
    public void addObserver(BalanceObserver observer);
    public void removeObserver(BalanceObserver observer);
}