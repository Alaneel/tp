package seedu.finbro.logic.command;

import seedu.finbro.model.Income;
import seedu.finbro.model.TransactionManager;
import seedu.finbro.storage.Storage;
import seedu.finbro.ui.Ui;

import java.util.List;

/**
 * @author alanwang
 * @project tp
 * @date 9/3/25
 */

/**
 * Represents a command to add income.
 */
public class IncomeCommand implements Command {
    private final double amount;
    private final String description;
    private final List<String> tags;

    /**
     * Constructs an IncomeCommand with the specified amount, description, and tags.
     *
     * @param amount      The income amount
     * @param description The income description
     * @param tags        The tags for the income
     */
    public IncomeCommand(double amount, String description, List<String> tags) {
        this.amount = amount;
        this.description = description;
        this.tags = tags;
    }

    /**
     * Executes the command to add income.
     *
     * @param transactionManager The transaction manager to add the income to
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        Income income = new Income(amount, description, tags);
        transactionManager.addTransaction(income);
        storage.saveTransactions(transactionManager);
        return "New income added: " + income;
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