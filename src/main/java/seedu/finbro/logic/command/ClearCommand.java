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
 * Represents a command to clear all data.
 */
public class ClearCommand implements Command {
    private boolean isConfirmed;

    /**
     * Constructs a ClearCommand.
     *
     * @param isConfirmed Whether the clear operation is confirmed
     */
    public ClearCommand(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    /**
     * Executes the command to clear all data.
     *
     * @param transactionManager The transaction manager to clear data from
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        if (!isConfirmed) {
            return "Are you sure you want to clear all data? This action cannot be undone. " +
                    "Type 'clear confirm' to confirm.";
        }

        transactionManager.clearTransactions();
        storage.saveTransactions(transactionManager);
        return "All data has been cleared.";
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
