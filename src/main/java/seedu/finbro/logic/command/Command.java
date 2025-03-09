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
 * Represents a command in the FinBro application.
 */
public interface Command {
    /**
     * Executes the command and returns a response message.
     *
     * @param transactionManager The transaction manager to execute the command on
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    String execute(TransactionManager transactionManager, Ui ui, Storage storage);

    /**
     * Returns true if the command is an exit command.
     *
     * @return true if the command is an exit command
     */
    boolean isExit();
}