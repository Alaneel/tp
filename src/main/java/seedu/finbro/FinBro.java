package seedu.finbro;

import seedu.finbro.logic.command.Command;
import seedu.finbro.logic.parser.Parser;
import seedu.finbro.model.TransactionManager;
import seedu.finbro.storage.Storage;
import seedu.finbro.ui.Ui;

/**
 * Main class for the FinBro application.
 */
public class FinBro {
    private final Ui ui;
    private final Storage storage;
    private final Parser parser;
    private TransactionManager transactionManager;

    /**
     * Constructs a new FinBro application with default components.
     */
    public FinBro() {
        ui = new Ui();
        storage = new Storage();
        parser = new Parser();
        transactionManager = new TransactionManager();
    }

    /**
     * Runs the application.
     */
    public void run() {
        start();
        runCommandLoop();
        exit();
    }

    /**
     * Starts the application.
     */
    private void start() {
        ui.showWelcome();
        try {
            transactionManager = storage.loadTransactions();
        } catch (Exception e) {
            ui.showError("Problem loading data: " + e.getMessage());
            transactionManager = new TransactionManager(); // Start with empty data if loading fails
        }
    }

    /**
     * Runs the main command loop.
     */
    private void runCommandLoop() {
        boolean isExit = false;

        while (!isExit) {
            try {
                String userInput = ui.readCommand();
                Command command = parser.parseCommand(userInput);
                String result = command.execute(transactionManager, ui, storage);
                ui.showMessage(result);
                isExit = command.isExit();
            } catch (Exception e) {
                ui.showError("An error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Exits the application.
     */
    private void exit() {
        ui.showGoodbye();
    }

    /**
     * Main entry point of the application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        new FinBro().run();
    }
}