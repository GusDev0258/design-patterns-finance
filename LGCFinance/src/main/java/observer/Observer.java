/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observer;

import model.Transaction;
/**
 *
 * @author sonho
 */
public interface Observer {
    public void update(Transaction transaction);
    public void updateRemoved(Transaction transaction);
}
