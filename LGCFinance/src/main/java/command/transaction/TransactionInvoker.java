/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command.transaction;
import java.util.Stack;
/**
 *
 * @author sonho
 */
public class TransactionInvoker {

    private TransactionCommand command;

    private Stack<TransactionCommand> commandHistory = new Stack<>();

    public void executeCommand(TransactionCommand command) {
        if (command != null) {
            command.execute();
            commandHistory.push(command);
        } else {
            System.out.println("No command set.");
        }
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            TransactionCommand lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("No command to undo.");
        }
    }
}
