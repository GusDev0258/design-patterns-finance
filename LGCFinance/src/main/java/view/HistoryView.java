/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;
import view.interfaces.ViewInterface;
import model.Transaction;

/**
 *
 * @author sonho
 */
public class HistoryView extends javax.swing.JFrame implements ViewInterface {

    private DefaultTableModel tableModel;

    /**
     * Creates new form TelaHistorico
     */
    public HistoryView() {
        initComponents();
        String[] columnNames = {"Name", "Value", "Category", "Date", "Origin", "Author", "Description"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tbTransaction.setModel(tableModel);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbTransaction = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        miUndoLastTransaction = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Valor", "Categoria", "Data", "Origem", "Autor", "Descrição"
            }
        ));
        jScrollPane1.setViewportView(tbTransaction);

        jMenu2.setText("Edit");

        miUndoLastTransaction.setText("Desfazer última transação");
        jMenu2.add(miUndoLastTransaction);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miUndoLastTransaction;
    private javax.swing.JTable tbTransaction;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addBtnAction(JButton btn, ActionListener action) {
        btn.addActionListener(action);
    }

    @Override
    public void showView() {
        this.setVisible(true);
    }

    public void loadTable(List<Transaction> transactions) {
        tableModel.setRowCount(0);

        for (Transaction transaction : transactions) {
            tableModel.addRow(new Object[]{
                transaction.getName(),
                transaction.getValue(),
                transaction.getCategory().getName(),
                transaction.getDate(),
                transaction.getOrigin(),
                transaction.getAuthor().getName(),
                transaction.getDescription()
            });
        }
    }

    public JMenuItem getUndoMenuItem() {
        return this.miUndoLastTransaction;
    }

    public void AddMenuItemAction(JMenuItem menuItem, ActionListener action) {
        menuItem.addActionListener(action);
    }
}
