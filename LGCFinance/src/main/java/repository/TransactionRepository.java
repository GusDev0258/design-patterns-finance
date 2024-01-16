/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Transaction;


/**
 *
 * @author sonho
 */
public class TransactionRepository {
    
    private static final TransactionRepository instance = new TransactionRepository();
    
    private TransactionRepository(){};
    
    public static TransactionRepository getInstance() {
        return instance;
    }
    
    private List<Transaction> transactions = new ArrayList<>();
    
    public List<Transaction> findAll() {
        return this.transactions;
    }
    
    public void saveTransaction(Transaction transaction) {
        var transactionFound = this.findById(transaction.getId());
        if(transactionFound == null) {
            transactions.add(transaction);
            System.out.println("Transação feita com sucesso!");
        } else {
            transactions.remove(transactionFound);
            var transactionMapped = this.transactionMapper(transactionFound, transaction);
            transactions.add(transactionMapped);
            System.out.println("Transação atualizada!");
        }
    }
    
    public void deleteById(Long id) {
        var transactionFound = this.findById(id);
        if(transactionFound != null) {
            transactions.remove(transactionFound);
            System.out.println(transactionFound.getName() + "deletei");
        } else {
            System.out.println("Transação não encontrada");
        }
    }
    
    public Transaction findById(Long id) {
        for(Transaction transaction: transactions) {
            if (Objects.equals(transaction.getId(), id)){
                return transaction;
            }
        }
        return null;
    }
    
    public List<Transaction> findAllIncomes() {
        var incomeList = new ArrayList<Transaction>();
        for (Transaction transaction : transactions) {
            if(transaction.getType().equals("INCOME")){
                incomeList.add(transaction);
            }
        }
        return incomeList;
    }
    
    public List<Transaction> findAllExpenses() {
        var expenseList = new ArrayList<Transaction>();
        for (Transaction transaction : transactions) {
            if(transaction.getType().equals("EXPENSE")) {
                expenseList.add(transaction);
            }
        }
        return expenseList;
    }
    
    private Transaction transactionMapper(Transaction transactionToBeMapped, Transaction transactionToMap) {
        transactionToBeMapped.setAuthor(transactionToMap.getAuthor());
        transactionToBeMapped.setCategory(transactionToMap.getCategory());
        transactionToBeMapped.setDate(transactionToMap.getDate());
        transactionToBeMapped.setDescription(transactionToMap.getDescription());
        transactionToBeMapped.setId(transactionToMap.getId());
        transactionToBeMapped.setName(transactionToMap.getName());
        transactionToBeMapped.setOrigin(transactionToMap.getOrigin());
        transactionToBeMapped.setValue(transactionToMap.getValue());
        return transactionToBeMapped;
    }
}
