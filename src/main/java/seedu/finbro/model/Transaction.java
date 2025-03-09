package seedu.finbro.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alanwang
 * @project tp
 * @date 9/3/25
 */

/**
 * Represents a financial transaction in the FinBro application.
 */
public abstract class Transaction {
    protected final double amount;
    protected final String description;
    protected final LocalDate date;
    protected final List<String> tags;

    /**
     * Constructs a Transaction with the specified amount, description, and optional tags.
     *
     * @param amount The amount of money involved in the transaction
     * @param description A description of the transaction
     * @param tags Optional tags for categorizing the transaction
     */
    public Transaction(double amount, String description, List<String> tags) {
        this.amount = amount;
        this.description = description;
        this.date = LocalDate.now(); // Default to current date
        this.tags = tags != null ? tags : new ArrayList<>();
    }

    /**
     * Constructs a Transaction with the specified amount, description, date, and optional tags.
     *
     * @param amount The amount of money involved in the transaction
     * @param description A description of the transaction
     * @param date The date of the transaction
     * @param tags Optional tags for categorizing the transaction
     */
    public Transaction(double amount, String description, LocalDate date, List<String> tags) {
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.tags = tags != null ? tags : new ArrayList<>();
    }

    /**
     * Returns the amount of the transaction.
     *
     * @return The amount of the transaction
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the description of the transaction.
     *
     * @return The description of the transaction
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the date of the transaction.
     *
     * @return The date of the transaction
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns the tags associated with the transaction.
     *
     * @return The tags associated with the transaction
     */
    public List<String> getTags() {
        return new ArrayList<>(tags); // Return a copy to prevent modification
    }

    /**
     * Returns a string representation of the transaction.
     *
     * @return A string representation of the transaction
     */
    @Override
    public abstract String toString();
}