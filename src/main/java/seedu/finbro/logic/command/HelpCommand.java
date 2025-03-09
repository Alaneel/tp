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
 * Represents a help command.
 */
public class HelpCommand implements Command {
    /**
     * Executes the command to display help information.
     *
     * @param transactionManager The transaction manager
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The help message
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        return "Available commands:\n" +
                "income AMOUNT d/DESCRIPTION [t/TAG...] - Add income\n" +
                "expense AMOUNT d/DESCRIPTION [c/CATEGORY] [t/TAG...] - Add expense\n" +
                "list [n/NUMBER] [d/DATE] - List transactions\n" +
                "delete INDEX - Delete a transaction\n" +
                "search KEYWORD [MORE_KEYWORDS] - Search transactions\n" +
                "filter d/DATE [to/DATE] - Filter transactions by date\n" +
                "balance - View current balance\n" +
                "summary [m/MONTH] [y/YEAR] - View financial summary\n" +
                "export [f/FORMAT] - Export data (csv or txt)\n" +
                "clear - Clear all data\n" +
                "exit - Exit the program\n" +
                "help - Show this help message";
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