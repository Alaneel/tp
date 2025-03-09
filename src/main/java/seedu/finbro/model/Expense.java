package seedu.finbro.model;

import java.time.LocalDate;
import java.util.List;

/**
 * @author alanwang
 * @project tp
 * @date 9/3/25
 */

/**
 * Represents an expense transaction in the FinBro application.
 */
public class Expense extends Transaction {
    public enum Category {
        FOOD("Food"),
        TRANSPORT("Transport"),
        SHOPPING("Shopping"),
        BILLS("Bills"),
        ENTERTAINMENT("Entertainment"),
        OTHERS("Others");

        private final String displayName;

        Category(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }

        /**
         * Gets a Category from a string, case-insensitive.
         *
         * @param str The string to convert to a Category
         * @return The corresponding Category, or OTHERS if no match is found
         */
        public static Category fromString(String str) {
            if (str == null) {
                return OTHERS;
            }

            for (Category category : Category.values()) {
                if (category.toString().equalsIgnoreCase(str)) {
                    return category;
                }
            }

            return OTHERS;
        }
    }

    private final Category category;

    /**
     * Constructs an Expense with the specified amount, description, category, and optional tags.
     *
     * @param amount The amount of money spent
     * @param description A description of the expense
     * @param category The category of the expense
     * @param tags Optional tags for categorizing the expense
     */
    public Expense(double amount, String description, Category category, List<String> tags) {
        super(amount, description, tags);
        this.category = category != null ? category : Category.OTHERS;
    }

    /**
     * Constructs an Expense with the specified amount, description, date, category, and optional tags.
     *
     * @param amount The amount of money spent
     * @param description A description of the expense
     * @param date The date of the expense
     * @param category The category of the expense
     * @param tags Optional tags for categorizing the expense
     */
    public Expense(double amount, String description, LocalDate date, Category category, List<String> tags) {
        super(amount, description, date, tags);
        this.category = category != null ? category : Category.OTHERS;
    }

    /**
     * Returns the category of the expense.
     *
     * @return The category of the expense
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Returns a string representation of the expense.
     *
     * @return A string representation of the expense
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Expense][").append(category).append("] $")
                .append(String.format("%.2f", amount))
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