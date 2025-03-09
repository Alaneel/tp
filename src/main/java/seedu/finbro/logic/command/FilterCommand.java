package seedu.finbro.logic.command;

import seedu.finbro.model.Transaction;
import seedu.finbro.model.TransactionManager;
import seedu.finbro.storage.Storage;
import seedu.finbro.ui.Ui;

import java.time.LocalDate;
import java.util.List;

/**
 * @author alanwang
 * @project tp
 * @date 9/3/25
 */

/**
 * Represents a command to filter transactions by date.
 */
public class FilterCommand implements Command {
    private final LocalDate startDate;
    private final LocalDate endDate;

    /**
     * Constructs a FilterCommand with the specified start and end dates.
     *
     * @param startDate The start date for filtering
     * @param endDate   The end date for filtering, or null to filter to the present
     */
    public FilterCommand(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate != null ? endDate : LocalDate.now();
    }

    /**
     * Executes the command to filter transactions by date.
     *
     * @param transactionManager The transaction manager to filter transactions in
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        List<Transaction> filteredTransactions = transactionManager.filterTransactions(startDate, endDate);

        if (filteredTransactions.isEmpty()) {
            return "No transactions found in the specified date range.";
        }

        StringBuilder response = new StringBuilder("Showing transactions from " +
                startDate + " to " + endDate + ":\n");
        for (int i = 0; i < filteredTransactions.size(); i++) {
            response.append(i + 1).append(". ").append(filteredTransactions.get(i)).append("\n");
        }

        return response.toString().trim();
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