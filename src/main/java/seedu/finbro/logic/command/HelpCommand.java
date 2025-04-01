package seedu.finbro.logic.command;

import seedu.finbro.model.TransactionManager;
import seedu.finbro.storage.Storage;
import seedu.finbro.ui.Ui;

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
        return "FinBro uses an interactive command experience. Type a command and follow the prompts.\n\n" +
                "Available commands:\n\n" +
                "income   => Add income transaction (prompts for amount, description, tags)\n" +
                "expense  => Add expense transaction (prompts for amount, description, category, tags)\n" +
                "list     => List transactions (prompts for optional date and limit)\n" +
                "delete   => Delete a transaction (prompts for index)\n" +
                "edit     => Edit a transaction (prompts for index and fields to update)\n" +
                "filter   => Filter transactions by date (prompts for start/end dates)\n" +
                "search   => Search transactions (prompts for keyword)\n" +
                "balance  => View current balance\n" +
                "summary  => View financial summary (prompts for month/year)\n" +
                "setbudget => Set a monthly budget (prompts for month/year and amount)\n" +
                "trackbudget => Track your budget progress (prompts for month/year)\n" +
                "setsavings => Set a savings goal (prompts for month/year and amount)\n" +
                "tracksavings => Track your savings progress (prompts for month/year)\n" +
                "export   => Export data (prompts for format: csv or txt)\n" +
                "clear    => Clear all data (with confirmation)\n" +
                "exit     => Exit the program\n" +
                "help     => Show this help message";
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
