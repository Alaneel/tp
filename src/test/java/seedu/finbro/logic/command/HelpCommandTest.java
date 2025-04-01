package seedu.finbro.logic.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.finbro.model.TransactionManager;
import seedu.finbro.storage.Storage;
import seedu.finbro.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the HelpCommand class.
 */
class HelpCommandTest {
    private HelpCommand helpCommand;
    private TransactionManager transactionManager;
    private Ui ui;
    private Storage storage;

    @BeforeEach
    void setUp() {
        helpCommand = new HelpCommand();
        transactionManager = new TransactionManager();
        ui = new Ui();
        storage = new Storage();
    }

    @Test
    void execute_returnsHelpMessage() {
        String result = helpCommand.execute(transactionManager, ui, storage);

        // Check that the result contains information about all available commands
        assertTrue(result.contains("Available commands:"));
        assertTrue(result.contains("income"));
        assertTrue(result.contains("expense"));
        assertTrue(result.contains("list"));
        assertTrue(result.contains("delete"));
        assertTrue(result.contains("edit"));
        assertTrue(result.contains("search"));
        assertTrue(result.contains("filter"));
        assertTrue(result.contains("balance"));
        assertTrue(result.contains("summary"));
        assertTrue(result.contains("export"));
        assertTrue(result.contains("clear"));
        assertTrue(result.contains("exit"));
        assertTrue(result.contains("help"));
    }

    @Test
    void isExit_returnsFalse() {
        assertFalse(helpCommand.isExit());
    }
}
