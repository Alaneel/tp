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
 * Represents a command to exit the application.
 */
public class ExitCommand implements Command {
    /**
     * Executes the command to exit the application.
     *
     * @param transactionManager The transaction manager
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        storage.saveTransactions(transactionManager);
        return "Goodbye! Thank you for using FinBro.";
    }

    /**
     * Returns true since this is an exit command.
     *
     * @return true
     */
    @Override
    public boolean isExit() {
        return true;
    }
}