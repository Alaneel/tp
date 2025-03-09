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
 * Represents an unknown command.
 */
public class UnknownCommand implements Command {
    private final String commandWord;

    /**
     * Constructs an UnknownCommand with the specified command word.
     *
     * @param commandWord The unknown command word
     */
    public UnknownCommand(String commandWord) {
        this.commandWord = commandWord;
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
        return "Unknown command: " + commandWord + "\nType 'help' to see available commands.";
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