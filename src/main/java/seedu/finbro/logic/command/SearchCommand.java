package seedu.finbro.logic.command;

import seedu.finbro.model.Transaction;
import seedu.finbro.model.TransactionManager;
import seedu.finbro.storage.Storage;
import seedu.finbro.ui.Ui;

import java.util.List;

/**
 * Represents a command to search for transactions.
 */
public class SearchCommand implements Command {
    private final List<String> keywords;

    /**
     * Constructs a SearchCommand with the specified keywords.
     *
     * @param keywords The keywords to search for
     */
    public SearchCommand(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Executes the command to search for transactions.
     *
     * @param transactionManager The transaction manager to search transactions in
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        List<Transaction> matchingTransactions = transactionManager.searchTransactions(keywords);

        if (matchingTransactions.isEmpty()) {
            return "No matching transactions found.";
        }

        StringBuilder response = new StringBuilder("Found " + matchingTransactions.size() +
                " matching transaction(s):\n");
        for (int i = 0; i < matchingTransactions.size(); i++) {
            response.append(i + 1).append(". ").append(matchingTransactions.get(i)).append("\n");
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