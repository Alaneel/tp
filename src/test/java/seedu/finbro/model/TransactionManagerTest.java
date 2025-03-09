package seedu.finbro.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author alanwang
 * @project tp
 * @date 9/3/25
 */

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

    @Test
    public void deleteTransaction_validIndex_success() {
        assertEquals(4, transactionManager.getTransactionCount());

        transactionManager.deleteTransaction(2); // Delete income2
        assertEquals(3, transactionManager.getTransactionCount());

        List<Transaction> transactions = transactionManager.listTransactions();
        assertFalse(transactions.contains(income2));
        assertTrue(transactions.contains(income1));
        assertTrue(transactions.contains(expense1));
        assertTrue(transactions.contains(expense2));
    }

    @Test
    public void deleteTransaction_invalidIndex_throwsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> transactionManager.deleteTransaction(0));
        assertThrows(IndexOutOfBoundsException.class, () -> transactionManager.deleteTransaction(5));
    }

    @Test
    public void listTransactions_returnsAllTransactionsInReverseChronologicalOrder() {
        List<Transaction> transactions = transactionManager.listTransactions();

        assertEquals(4, transactions.size());
        // Check reverse chronological order
        assertEquals(expense2, transactions.get(0)); // Feb 20
        assertEquals(income2, transactions.get(1));  // Feb 15
        assertEquals(expense1, transactions.get(2)); // Feb 10
        assertEquals(income1, transactions.get(3));  // Feb 1
    }

    @Test
    public void listTransactions_withLimit_returnsLimitedTransactions() {
        List<Transaction> transactions = transactionManager.listTransactions(2);

        assertEquals(2, transactions.size());
        assertEquals(expense2, transactions.get(0)); // Feb 20
        assertEquals(income2, transactions.get(1));  // Feb 15
    }

    @Test
    public void listTransactionsFromDate_returnsMatchingTransactions() {
        List<Transaction> transactions = transactionManager.listTransactionsFromDate(LocalDate.of(2025, 2, 15));

        assertEquals(2, transactions.size());
        assertTrue(transactions.contains(expense2)); // Feb 20
        assertTrue(transactions.contains(income2));  // Feb 15
    }

    @Test
    public void searchTransactions_matchingKeyword_returnsMatchingTransactions() {
        List<Transaction> results = transactionManager.searchTransactions(Collections.singletonList("salary"));

        assertEquals(1, results.size());
        assertEquals(income1, results.get(0));
    }

    @Test
    public void searchTransactions_multipleKeywords_returnsMatchingTransactions() {
        List<Transaction> results = transactionManager.searchTransactions(Arrays.asList("lunch", "shoes"));

        assertEquals(2, results.size());
        assertTrue(results.contains(expense1));
        assertTrue(results.contains(expense2));
    }

    @Test
    public void searchTransactions_caseInsensitive() {
        List<Transaction> results = transactionManager.searchTransactions(Collections.singletonList("SALARY"));

        assertEquals(1, results.size());
        assertEquals(income1, results.get(0));
    }

    @Test
    public void filterTransactions_returnsTransactionsInDateRange() {
        LocalDate startDate = LocalDate.of(2025, 2, 10);
        LocalDate endDate = LocalDate.of(2025, 2, 15);

        List<Transaction> filtered = transactionManager.filterTransactions(startDate, endDate);

        assertEquals(2, filtered.size());
        assertTrue(filtered.contains(expense1)); // Feb 10
        assertTrue(filtered.contains(income2));  // Feb 15
    }

    @Test
    public void getBalance_calculatesCorrectBalance() {
        // Income: 3000 + 500 = 3500
        // Expenses: 25.50 + 75 = 100.50
        // Balance: 3500 - 100.50 = 3399.50
        assertEquals(3399.50, transactionManager.getBalance());
    }

    @Test
    public void getTotalIncome_calculatesCorrectTotal() {
        assertEquals(3500.00, transactionManager.getTotalIncome());
    }

    @Test
    public void getTotalExpenses_calculatesCorrectTotal() {
        assertEquals(100.50, transactionManager.getTotalExpenses());
    }

    @Test
    public void getMonthlyIncome_calculatesCorrectMonthlyIncome() {
        assertEquals(3500.00, transactionManager.getMonthlyIncome(2, 2025));
        assertEquals(0.00, transactionManager.getMonthlyIncome(3, 2025));
    }

    @Test
    public void getMonthlyExpenses_calculatesCorrectMonthlyExpenses() {
        assertEquals(100.50, transactionManager.getMonthlyExpenses(2, 2025));
        assertEquals(0.00, transactionManager.getMonthlyExpenses(3, 2025));
    }

    @Test
    public void getMonthlyExpensesByCategory_returnsCorrectCategoryMap() {
        Map<Expense.Category, Double> expensesByCategory =
                transactionManager.getMonthlyExpensesByCategory(2, 2025);

        assertEquals(2, expensesByCategory.size());
        assertEquals(25.50, expensesByCategory.get(Expense.Category.FOOD));
        assertEquals(75.00, expensesByCategory.get(Expense.Category.SHOPPING));
    }

    @Test
    public void clearTransactions_removesAllTransactions() {
        assertEquals(4, transactionManager.getTransactionCount());

        transactionManager.clearTransactions();

        assertEquals(0, transactionManager.getTransactionCount());
        assertTrue(transactionManager.listTransactions().isEmpty());
    }
}