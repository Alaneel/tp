package seedu.finbro.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the TransactionManager class.
 */
public class TransactionManagerTest {
    private TransactionManager transactionManager;
    private Income income1;
    private Income income2;
    private Expense expense1;
    private Expense expense2;

    @BeforeEach
    public void setUp() {
        transactionManager = new TransactionManager();

        // Create test transactions
        income1 = new Income(3000.00, "Monthly salary",
                LocalDate.of(2025, 2, 1), Collections.singletonList("work"));
        income2 = new Income(500.00, "Bonus",
                LocalDate.of(2025, 2, 15), Collections.singletonList("work"));
        expense1 = new Expense(25.50, "Lunch",
                LocalDate.of(2025, 2, 10), Expense.Category.FOOD, Collections.singletonList("work"));
        expense2 = new Expense(75.00, "New shoes",
                LocalDate.of(2025, 2, 20), Expense.Category.SHOPPING, Collections.emptyList());

        // Add transactions to manager
        transactionManager.addTransaction(income1);
        transactionManager.addTransaction(income2);
        transactionManager.addTransaction(expense1);
        transactionManager.addTransaction(expense2);
    }

    @Test
    public void addTransaction_validTransaction_success() {
        TransactionManager manager = new TransactionManager();
        assertEquals(0, manager.getTransactionCount());

        Income income = new Income(1000.00, "Test", Collections.emptyList());
        manager.addTransaction(income);

        assertEquals(1, manager.getTransactionCount());
    }

    // TODO Test for delete commands (valid / invalid)

    // TODO Tests for list command (3 cases)

    // TODO Tests for search command (3 cases)

    // TODO Test for filter command

    // TODO Test for balance command

    // TODO Test for summary command (5 cases)

    @Test
    public void clearTransactions_removesAllTransactions() {
        assertEquals(4, transactionManager.getTransactionCount());

        transactionManager.clearTransactions();

        assertEquals(0, transactionManager.getTransactionCount());
        assertTrue(transactionManager.listTransactions().isEmpty());
    }
}
