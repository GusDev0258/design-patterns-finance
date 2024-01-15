/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import view.interfaces.ViewInterface;
import dto.TransactionDTO;

/**
 *
 * @author sonho
 */
public class HistoryView extends javax.swing.JFrame implements ViewInterface {

    /**
     * Creates new form TelaHistorico
     */
    public HistoryView() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbTransaction = new javax.swing.JTable();

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
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
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
    
    public void loadTable(List<TransactionDTO> transactions) { 
        for (int currentLine = 0; currentLine < getRowCount(); currentLine++) {
            setNameColumn(transactions.get(currentLine).getName(), currentLine);
            setValueColumn(transactions.get(currentLine).getValue(), currentLine);
            setCategoryColumn(transactions.get(currentLine).getCategory(), currentLine);
            setDateColumn(transactions.get(currentLine).getDate(), currentLine);
            setOriginColumn(transactions.get(currentLine).getOrigin(), currentLine);
            setAuthorColumn(transactions.get(currentLine).getAuthor(), currentLine);
            setDescriptionColumn(transactions.get(currentLine).getDescription(), currentLine);
        }
    }
    
    public int getRowCount() {
        return tbTransaction.getRowCount();
    }

  private void setNameColumn(Object value, int currentRow) {
        byte nameColumn = 1;
        tbTransaction.setValueAt(value, currentRow, nameColumn);
    }
  
  private void setValueColumn(Object value, int currentRow) {
      byte nameColumn = 2;
      tbTransaction.setValueAt(value, currentRow, nameColumn);
  }
  
  private void setCategoryColumn(Object value, int currentRow) {
      byte categoryColumn = 3;
      tbTransaction.setValueAt(value, currentRow, categoryColumn);
  }
  
  private void setDateColumn(Object value, int currentRow) {
      byte dateColumn = 4;
      tbTransaction.setValueAt(value, currentRow, dateColumn);
  }
  
  private void setOriginColumn(Object value, int currentRow) {
      byte originColumn = 5;
      tbTransaction.setValueAt(value, currentRow, originColumn);
  }
  
  private void setAuthorColumn(Object value, int currentRow) {
      byte authorColumn = 1;
      tbTransaction.setValueAt(value, currentRow, authorColumn);
  }
  
  private void setDescriptionColumn(Object value, int currentRow) {
      byte descriptionColumn = 1;
      tbTransaction.setValueAt(value, currentRow, descriptionColumn);
  }
}
