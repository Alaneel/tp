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
 * Represents a command to list transactions.
 */
public class ListCommand implements Command {
    private final Integer limit;
    private final LocalDate date;

    /**
     * Constructs a ListCommand with optional limit and date.
     *
     * @param limit The maximum number of transactions to list, or null for all
     * @param date  The date to filter transactions by, or null for all dates
     */
    public ListCommand(Integer limit, LocalDate date) {
        this.limit = limit;
        this.date = date;
    }

    /**
     * Executes the command to list transactions.
     *
     * @param transactionManager The transaction manager to list transactions from
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        List<Transaction> transactionsToList;

        if (date != null) {
            transactionsToList = transactionManager.listTransactionsFromDate(date);
            if (limit != null) {
                transactionsToList = transactionsToList.subList(0, Math.min(limit, transactionsToList.size()));
            }
        } else if (limit != null) {
            transactionsToList = transactionManager.listTransactions(limit);
        } else {
            transactionsToList = transactionManager.listTransactions();
        }

        if (transactionsToList.isEmpty()) {
            return "No transactions found.";
        }

        StringBuilder response = new StringBuilder("Here are your transactions:\n");
        for (int i = 0; i < transactionsToList.size(); i++) {
            response.append(i + 1).append(". ").append(transactionsToList.get(i)).append("\n");
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