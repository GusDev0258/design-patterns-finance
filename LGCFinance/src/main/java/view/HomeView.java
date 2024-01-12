/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.interfaces.BalanceObserver;
import view.interfaces.ViewInterface;

/**
 *
 * @author gustavoavelar
 */
public class HomeView extends javax.swing.JFrame implements ViewInterface, BalanceObserver{
    /**
     * Creates new form TelaInicio
     */
    public HomeView() {
        initComponents();
        this.setTitle("LGC Finance");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddExpenditure = new javax.swing.JButton();
        btnAddIncome = new javax.swing.JButton();
        lbCurrentBalance = new javax.swing.JLabel();
        btnHistory = new javax.swing.JButton();
        btnAddCategory = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAddExpenditure.setText("Adicionar despesa");

        btnAddIncome.setText("Adicionar ganho");

        lbCurrentBalance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbCurrentBalance.setText("Saldo: R$ 1900");

        btnHistory.setText("Histórico");
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        btnAddCategory.setText("Cadastrar categoria");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        btnAddUser.setText("Cadastrar usuário");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(lbCurrentBalance))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddExpenditure, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(lbCurrentBalance)
                .addGap(44, 44, 44)
                .addComponent(btnAddExpenditure)
                .addGap(18, 18, 18)
                .addComponent(btnAddIncome)
                .addGap(18, 18, 18)
                .addComponent(btnHistory)
                .addGap(18, 18, 18)
                .addComponent(btnAddCategory)
                .addGap(18, 18, 18)
                .addComponent(btnAddUser)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnAddExpenditure;
    private javax.swing.JButton btnAddIncome;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnHistory;
    private javax.swing.JLabel lbCurrentBalance;
    // End of variables declaration//GEN-END:variables
        
    @Override
    public void addBtnAction(JButton btn, ActionListener action) {
        btn.addActionListener(action);
    }
    
    public JButton getBtnIncome() {
        return this.btnAddIncome;
    }
    
    public JButton getBtnExpenditure() {
        return this.btnAddExpenditure;
    }
    
    public JButton getBtnHistory() {
        return this.btnHistory;
    }
    
    @Override
    public void showView() {
        this.setVisible(true);
    }
    
    @Override
    public void updateBalance(Double amount) {
        this.lbCurrentBalance.setText("Saldo: R$" + amount.toString());
    }
}
