package seedu.finbro.logic.command;

import seedu.finbro.model.TransactionManager;
import seedu.finbro.storage.Storage;
import seedu.finbro.ui.Ui;

/**
 * Represents a command to view the current balance.
 */
public class BalanceCommand implements Command {
    /**
     * Executes the command to view the current balance.
     *
     * @param transactionManager The transaction manager to get the balance from
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        double balance = transactionManager.getBalance();
        double totalIncome = transactionManager.getTotalIncome();
        double totalExpenses = transactionManager.getTotalExpenses();

        StringBuilder response = new StringBuilder();
        response.append("Current Balance: $").append(String.format("%.2f", balance)).append("\n");
        response.append("Total Income: $").append(String.format("%.2f", totalIncome)).append("\n");
        response.append("Total Expenses: $").append(String.format("%.2f", totalExpenses));

        return response.toString();
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