package seedu.finbro.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author alanwang
 * @project tp
 * @date 9/3/25
 */

/**
 * Tests for the Transaction class and its subclasses.
 */
public class TransactionTest {

    @Test
    public void income_constructor_validParameters_success() {
        double amount = 3000.00;
        String description = "Monthly salary";
        List<String> tags = Collections.singletonList("work");

        Income income = new Income(amount, description, tags);

        assertEquals(amount, income.getAmount());
        assertEquals(description, income.getDescription());
        assertEquals(LocalDate.now(), income.getDate());
        assertEquals(tags, income.getTags());
    }

    @Test
    public void income_toString_correctFormat() {
        Income income = new Income(3000.00, "Monthly salary", Collections.singletonList("work"));
        String expected = "[Income] $3000.00 - Monthly salary [work]";
        assertEquals(expected, income.toString());
    }

    @Test
    public void income_toString_noTags_correctFormat() {
        Income income = new Income(3000.00, "Monthly salary", Collections.emptyList());
        String expected = "[Income] $3000.00 - Monthly salary";
        assertEquals(expected, income.toString());
    }

    @Test
    public void expense_constructor_validParameters_success() {
        double amount = 25.50;
        String description = "Lunch";
        Expense.Category category = Expense.Category.FOOD;
        List<String> tags = Collections.singletonList("work");

        Expense expense = new Expense(amount, description, category, tags);

        assertEquals(amount, expense.getAmount());
        assertEquals(description, expense.getDescription());
        assertEquals(LocalDate.now(), expense.getDate());
        assertEquals(category, expense.getCategory());
        assertEquals(tags, expense.getTags());
    }

    @Test
    public void expense_constructor_nullCategory_defaultsToOthers() {
        Expense expense = new Expense(25.50, "Lunch", null, Collections.emptyList());
        assertEquals(Expense.Category.OTHERS, expense.getCategory());
    }

    @Test
    public void expense_toString_correctFormat() {
        Expense expense = new Expense(25.50, "Lunch", Expense.Category.FOOD, Collections.singletonList("work"));
        String expected = "[Expense][Food] $25.50 - Lunch [work]";
        assertEquals(expected, expense.toString());
    }

    @Test
    public void expense_toString_noTags_correctFormat() {
        Expense expense = new Expense(25.50, "Lunch", Expense.Category.FOOD, Collections.emptyList());
        String expected = "[Expense][Food] $25.50 - Lunch";
        assertEquals(expected, expense.toString());
    }

    @Test
    public void expenseCategory_fromString_validCategory_returnsCorrectCategory() {
        assertEquals(Expense.Category.FOOD, Expense.Category.fromString("Food"));
        assertEquals(Expense.Category.TRANSPORT, Expense.Category.fromString("Transport"));
        assertEquals(Expense.Category.SHOPPING, Expense.Category.fromString("Shopping"));
        assertEquals(Expense.Category.BILLS, Expense.Category.fromString("Bills"));
        assertEquals(Expense.Category.ENTERTAINMENT, Expense.Category.fromString("Entertainment"));
        assertEquals(Expense.Category.OTHERS, Expense.Category.fromString("Others"));
    }

    @Test
    public void expenseCategory_fromString_invalidCategory_returnsOthers() {
        assertEquals(Expense.Category.OTHERS, Expense.Category.fromString("NotACategory"));
        assertEquals(Expense.Category.OTHERS, Expense.Category.fromString(null));
    }

    @Test
    public void expenseCategory_fromString_caseInsensitive() {
        assertEquals(Expense.Category.FOOD, Expense.Category.fromString("food"));
        assertEquals(Expense.Category.FOOD, Expense.Category.fromString("FOOD"));
        assertEquals(Expense.Category.FOOD, Expense.Category.fromString("Food"));
    }
}