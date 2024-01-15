/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dto.TransactionDTO;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import model.Author;
import javax.swing.JButton;
import javax.swing.JComboBox;
import view.interfaces.ViewInterface;
import model.Category;

/**
 *
 * @author sonho
 */
public class IncomeView extends javax.swing.JFrame implements ViewInterface{

    /**
     * Creates new form TelaAdicionarDespesa
     */
    public IncomeView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        txtValue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAddIncome = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtOrigin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        cbCategory = new javax.swing.JComboBox<>();
        cbAuthor = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Adicionar ganho");

        btnAddIncome.setText("ADICIONAR");
        btnAddIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddIncomeActionPerformed(evt);
            }
        });

        jLabel2.setText("Valor");

        jLabel3.setText("Categoria");

        jLabel4.setText("Nome");

        jLabel5.setText("Data");

        jLabel6.setText("Origem");

        txtOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOriginActionPerformed(evt);
            }
        });

        jLabel7.setText("Autor");

        jLabel8.setText("Descrição");

        taDescription.setColumns(20);
        taDescription.setRows(5);
        jScrollPane1.setViewportView(taDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAddIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1)
                            .addComponent(txtOrigin)
                            .addComponent(txtDate)
                            .addComponent(txtValue)
                            .addComponent(txtName)
                            .addComponent(cbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbAuthor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnAddIncome)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddIncomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddIncomeActionPerformed

    private void txtOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOriginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOriginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddIncome;
    private javax.swing.JComboBox<Author> cbAuthor;
    private javax.swing.JComboBox<Category> cbCategory;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrigin;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void addBtnAction(JButton btn, ActionListener action) {
        btn.addActionListener(action);
    }

    @Override
    public void showView() {
        this.setVisible(true);
    }
    
    public JButton getAddIncomeButton() {
        return this.btnAddIncome;
    }
    
    public String getIncomeName() {
        return this.txtName.getText();
    }
    
    public Double getIncomeValue() {
        return Double.valueOf(this.txtValue.getText());
    }
    
    public Category getCategory() {
        return (Category) this.cbCategory.getSelectedItem();
    }
    
    public String getDate() {
        return this.txtDate.getText();
    }
    
    public String getOrigin() {
        return this.txtOrigin.getText();
    }
    
    public Author getAuthor() {
        return (Author) this.cbAuthor.getSelectedItem();
    }
    
    public String getDescription() {
        return this.taDescription.getText();
    }
    
    public JComboBox getCbAuthor() {
        return this.cbAuthor;
    }
    
    public JComboBox getCbCategory() {
        return this.cbCategory;
    }
    
    public TransactionDTO getTransaction() {
        var transaction = new TransactionDTO();
        transaction.setAuthor(getAuthor().getName());
        transaction.setCategory(getCategory().getName());
        transaction.setDate(LocalDate.parse(getDate()));
        transaction.setName(getIncomeName());
        transaction.setDescription(getDescription());
        transaction.setOrigin(getOrigin());
        transaction.setValue(getIncomeValue());
        
        return transaction;
    }
}
