package seedu.finbro.logic.command;

import seedu.finbro.model.Expense;
import seedu.finbro.model.TransactionManager;
import seedu.finbro.storage.Storage;
import seedu.finbro.ui.Ui;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;

/**
 * Represents a command to view a financial summary.
 */
public class SummaryCommand implements Command {
    private final Integer month;
    private final Integer year;

    /**
     * Constructs a SummaryCommand with optional month and year.
     *
     * @param month The month to get a summary for, or null for the current month
     * @param year  The year to get a summary for, or null for the current year
     */
    public SummaryCommand(Integer month, Integer year) {
        LocalDate now = LocalDate.now();
        this.month = month != null ? month : now.getMonthValue();
        this.year = year != null ? year : now.getYear();
    }

    /**
     * Executes the command to view a financial summary.
     *
     * @param transactionManager The transaction manager to get the summary from
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        double monthlyIncome = transactionManager.getMonthlyIncome(month, year);
        double monthlyExpenses = transactionManager.getMonthlyExpenses(month, year);
        double balance = monthlyIncome - monthlyExpenses;

        Map<Expense.Category, Double> expensesByCategory =
                transactionManager.getMonthlyExpensesByCategory(month, year);

        String monthName = Month.of(month).getDisplayName(TextStyle.FULL, Locale.US);

        StringBuilder response = new StringBuilder();
        response.append("Financial Summary for ").append(monthName).append(" ").append(year).append(":\n");
        response.append("Total Income: $").append(String.format("%.2f", monthlyIncome)).append("\n");
        response.append("Total Expenses: $").append(String.format("%.2f", monthlyExpenses)).append("\n");
        response.append("Net Balance: $").append(String.format("%.2f", balance)).append("\n\n");

        if (!expensesByCategory.isEmpty()) {
            response.append("Expenses by Category:\n");
            for (Map.Entry<Expense.Category, Double> entry : expensesByCategory.entrySet()) {
                response.append(entry.getKey()).append(": $")
                        .append(String.format("%.2f", entry.getValue()))
                        .append(" (").append(String.format("%.1f", entry.getValue() / monthlyExpenses * 100))
                        .append("%)\n");
            }
        } else {
            response.append("No expenses recorded for this period.");
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