package seedu.finbro.logic.command;

import seedu.finbro.model.Expense;
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
 * Represents a command to add an expense.
 */
public class ExpenseCommand implements Command {
    private final double amount;
    private final String description;
    private final Expense.Category category;
    private final List<String> tags;

    /**
     * Constructs an ExpenseCommand with the specified amount, description, category, and tags.
     *
     * @param amount      The expense amount
     * @param description The expense description
     * @param category    The expense category
     * @param tags        The tags for the expense
     */
    public ExpenseCommand(double amount, String description, Expense.Category category, List<String> tags) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.tags = tags;
    }

    /**
     * Executes the command to add an expense.
     *
     * @param transactionManager The transaction manager to add the expense to
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        Expense expense = new Expense(amount, description, category, tags);
        transactionManager.addTransaction(expense);
        storage.saveTransactions(transactionManager);
        return "New expense added: " + expense;
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