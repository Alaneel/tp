package seedu.finbro.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    /**
     * Deletes a transaction at the specified index.
     *
     * @param index The index of the transaction to delete (1-based)
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void deleteTransaction(int index) {
        if (index < 1 || index > transactions.size()) {
            throw new IndexOutOfBoundsException("Transaction index out of range: " + index);
        }
        transactions.remove(index - 1); // Convert from 1-based to 0-based
    }

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

    /**
     * Lists a limited number of transactions in reverse chronological order.
     *
     * @param limit The maximum number of transactions to return
     * @return List of transactions, limited to the specified number
     */
    public List<Transaction> listTransactions(int limit) {
        List<Transaction> allTransactions = listTransactions();
        return allTransactions.subList(0, Math.min(limit, allTransactions.size()));
    }

    /**
     * Lists transactions from a specific date in reverse chronological order.
     *
     * @param date The date to filter transactions from
     * @return List of transactions from the specified date
     */
    public List<Transaction> listTransactionsFromDate(LocalDate date) {
        return listTransactions().stream()
                .filter(t -> !t.getDate().isBefore(date))
                .collect(Collectors.toList());
    }

    /**
     * Searches for transactions whose descriptions contain any of the given keywords.
     *
     * @param keywords The keywords to search for
     * @return List of transactions matching the search criteria
     */
    public List<Transaction> searchTransactions(List<String> keywords) {
        if (keywords == null || keywords.isEmpty()) {
            return new ArrayList<>();
        }

        return listTransactions().stream()
                .filter(t -> keywords.stream()
                        .anyMatch(k -> t.getDescription().toLowerCase().contains(k.toLowerCase())))
                .collect(Collectors.toList());
    }

    /**
     * Filters transactions between the specified start and end dates.
     *
     * @param startDate The start date (inclusive)
     * @param endDate   The end date (inclusive)
     * @return List of transactions within the date range
     */
    public List<Transaction> filterTransactions(LocalDate startDate, LocalDate endDate) {
        return listTransactions().stream()
                .filter(t -> !t.getDate().isBefore(startDate) && !t.getDate().isAfter(endDate))
                .collect(Collectors.toList());
    }

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

    /**
     * Gets the total income for a specific month and year.
     *
     * @param month The month (1-12)
     * @param year The year
     * @return The total income for the specified month and year
     */
    public double getMonthlyIncome(int month, int year) {
        return transactions.stream()
                .filter(t -> t instanceof Income)
                .filter(t -> t.getDate().getMonthValue() == month && t.getDate().getYear() == year)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    /**
     * Gets the total expenses for a specific month and year.
     *
     * @param month The month (1-12)
     * @param year  The year
     * @return The total expenses for the specified month and year
     */
    public double getMonthlyExpenses(int month, int year) {
        return transactions.stream()
                .filter(t -> t instanceof Expense)
                .filter(t -> t.getDate().getMonthValue() == month && t.getDate().getYear() == year)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    /**
     * Gets expenses by category for a specific month and year.
     *
     * @param month The month (1-12)
     * @param year  The year
     * @return A map of category to total expenses
     */
    public Map<Expense.Category, Double> getMonthlyExpensesByCategory(int month, int year) {
        return transactions.stream()
                .filter(t -> t instanceof Expense)
                .filter(t -> t.getDate().getMonthValue() == month && t.getDate().getYear() == year)
                .map(t -> (Expense) t)
                .collect(Collectors.groupingBy(
                        Expense::getCategory,
                        Collectors.summingDouble(Transaction::getAmount)
                ));
    }

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