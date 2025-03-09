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
 * Represents an invalid command.
 */
public class InvalidCommand implements Command {
    private final String message;

    /**
     * Constructs an InvalidCommand with the specified error message.
     *
     * @param message The error message
     */
    public InvalidCommand(String message) {
        this.message = message;
    }

    /**
     * Executes the command to display an error message.
     *
     * @param transactionManager The transaction manager
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The error message
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        return "Invalid command: " + message;
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