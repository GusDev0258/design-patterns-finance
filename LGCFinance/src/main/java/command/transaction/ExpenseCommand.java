/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command.transaction;

import controller.TransactionController;
import model.Transaction;
import view.TransactionView;

/**
 *
 * @author sonho
 */
public class ExpenseCommand implements TransactionCommand {

    TransactionController transactionController;

    Transaction lastTransaction;
    TransactionView transactionView;

    public ExpenseCommand(TransactionController transactionController) {
        this.transactionController = transactionController;
        if(this.transactionController != null) {
            this.transactionView = this.transactionController.getTransactionView();
        }
    }

    @Override
    public void execute() {
        
        var expense = this.transactionController.getExpenseFactory().createTransaction(
                this.transactionView.getTransactionName(),
                this.transactionView.getTransactionValue(),
                this.transactionView.getDate(),
                this.transactionView.getOrigin(),
                this.transactionView.getCategory(),
                this.transactionView.getAuthor(),
                this.transactionView.getDescription()
        );
        
        expense.setInvoice(this.transactionController.getExpenseFactory().createInvoice("CODE0981", expense.getValue()));
        
        this.transactionController.getTransactionRepository().saveTransaction(expense);
        this.transactionController.notify(expense);
        this.transactionController.updateAuthorBalance(this.transactionView.getAuthor(), this.transactionView.getAuthor().getBalance() - this.transactionView.getTransactionValue());
        this.lastTransaction = expense;
        System.out.println("Expense Saved");
    }

    @Override
    public void undo() {
        if (this.lastTransaction != null) {
            this.transactionController.getTransactionRepository().deleteById(this.lastTransaction.getId());
            this.transactionController.notifyUndo(this.lastTransaction);
            System.out.println(this.lastTransaction.getValue());
            this.transactionController.updateAuthorBalance(this.lastTransaction.getAuthor(), this.lastTransaction.getAuthor().getBalance() + this.lastTransaction.getValue());
            System.out.println("Undo for Expense completed");
        } else {
            System.out.println("No transaction to undo for Expense");
        }
    }
}
