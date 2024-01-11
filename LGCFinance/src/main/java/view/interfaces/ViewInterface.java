/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view.interfaces;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author sonho
 */
public interface ViewInterface {
    public void addBtnAction(JButton btn, ActionListener action);
    public void show();
}
