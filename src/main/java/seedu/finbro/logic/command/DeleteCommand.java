package seedu.finbro.logic.command;

import seedu.finbro.model.TransactionManager;
import seedu.finbro.storage.Storage;
import seedu.finbro.ui.Ui;

/**
 * @author alanwang
 * @project tp
 * @date 9/3/25
 */

/**
 * Represents a command to delete a transaction.
 */
public class DeleteCommand implements Command {
    private final int index;

    /**
     * Constructs a DeleteCommand with the specified index.
     *
     * @param index The index of the transaction to delete (1-based)
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the command to delete a transaction.
     *
     * @param transactionManager The transaction manager to delete the transaction from
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        try {
            if (index < 1 || index > transactionManager.getTransactionCount()) {
                return "Invalid transaction index. There are only " +
                        transactionManager.getTransactionCount() + " transactions.";
            }

            // Get the transaction to display in the confirmation message
            String transactionToDelete = transactionManager.listTransactions().get(index - 1).toString();

            // Delete the transaction
            transactionManager.deleteTransaction(index);
            storage.saveTransactions(transactionManager);

            return "Transaction deleted: " + transactionToDelete;
        } catch (IndexOutOfBoundsException e) {
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Returns false since this is not an exit command.
     *
     * @return false
     */
    @Override
    public boolean isExit() {
        return false;
    }
}