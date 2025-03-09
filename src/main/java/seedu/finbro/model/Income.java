package seedu.finbro.model;

import java.time.LocalDate;
import java.util.List;

/**
 * @author alanwang
 * @project tp
 * @date 9/3/25
 */

/**
 * Represents an income transaction in the FinBro application.
 */
public class Income extends Transaction {
    /**
     * Constructs an Income with the specified amount, description, and optional tags.
     *
     * @param amount The amount of money received
     * @param description A description of the income
     * @param tags Optional tags for categorizing the income
     */
    public Income(double amount, String description, List<String> tags) {
        super(amount, description, tags);
    }

    /**
     * Constructs an Income with the specified amount, description, date, and optional tags.
     *
     * @param amount The amount of money received
     * @param description A description of the income
     * @param date The date of the income
     * @param tags Optional tags for categorizing the income
     */
    public Income(double amount, String description, LocalDate date, List<String> tags) {
        super(amount, description, date, tags);
    }

    /**
     * Returns a string representation of the income.
     *
     * @return A string representation of the income
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Income] $").append(String.format("%.2f", amount))
                .append(" - ").append(description);

        if (!tags.isEmpty()) {
            sb.append(" [");
            for (int i = 0; i < tags.size(); i++) {
                sb.append(tags.get(i));
                if (i < tags.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }

        return sb.toString();
    }
}