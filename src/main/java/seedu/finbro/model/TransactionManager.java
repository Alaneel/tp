package seedu.finbro.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages transactions in the FinBro application.
 */
public class TransactionManager {
    private final List<Transaction> transactions;

    /**
     * Constructs a TransactionManager with an empty list of transactions.
     */
    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

    /**
     * Adds a transaction to the manager.
     *
     * @param transaction The transaction to add
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // TODO Deletes a transaction at the specified index.

    /**
     * Lists all transactions in reverse chronological order.
     *
     * @return List of all transactions in reverse chronological order
     */
    public List<Transaction> listTransactions() {
        // Sort by date in reverse chronological order
        List<Transaction> sortedTransactions = new ArrayList<>(transactions);
        Collections.sort(sortedTransactions, (t1, t2) -> t2.getDate().compareTo(t1.getDate()));
        return sortedTransactions;
    }

    // TODO Lists a limited number of transactions in reverse chronological order.

    // TODO Lists transactions from a specific date in reverse chronological order.

    // TODO Searches for transactions whose descriptions contain any of the given keywords.

    // TODO Filters transactions between the specified start and end dates.

    /**
     * Calculates the current balance based on all transactions.
     *
     * @return The current balance
     */
    public double getBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            if (transaction instanceof Income) {
                balance += transaction.getAmount();
            } else if (transaction instanceof Expense) {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }

    /**
     * Calculates the total income from all transactions.
     *
     * @return The total income
     */
    public double getTotalIncome() {
        return transactions.stream()
                .filter(t -> t instanceof Income)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    /**
     * Calculates the total expenses from all transactions.
     *
     * @return The total expenses
     */
    public double getTotalExpenses() {
        return transactions.stream()
                .filter(t -> t instanceof Expense)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    // TODO Gets the total income for a specific month and year.

    // TODO Gets the total expenses for a specific month and year.

    // TODO Gets expenses by category for a specific month and year.

    /**
     * Clears all transactions.
     */
    public void clearTransactions() {
        transactions.clear();
    }

    /**
     * Returns the number of transactions.
     *
     * @return The number of transactions
     */
    public int getTransactionCount() {
        return transactions.size();
    }
}
