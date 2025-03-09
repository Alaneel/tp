package seedu.finbro.ui;

import java.util.Scanner;

/**
 * @author alanwang
 * @project tp
 * @date 9/3/25
 */

/**
 * Text-based UI for the FinBro application.
 */
public class Ui {
    private static final String LINE = "____________________________________________________________";

    private final Scanner scanner;

    /**
     * Constructs a Ui with System.in as input source.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Constructs a Ui with a custom input source.
     *
     * @param scanner The scanner to use for input
     */
    public Ui(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Shows a welcome message.
     */
    public void showWelcome() {
        System.out.println(LINE);
        System.out.println("Welcome to FinBro - Your Personal Finance Manager!");
        System.out.println("Type 'help' to see available commands.");
        System.out.println(LINE);
    }

    /**
     * Shows a goodbye message.
     */
    public void showGoodbye() {
        System.out.println(LINE);
        System.out.println("Thank you for using FinBro. Your finances are now in better shape!");
        System.out.println("Goodbye!");
        System.out.println(LINE);
    }

    /**
     * Shows a message to the user.
     *
     * @param message The message to show
     */
    public void showMessage(String message) {
        System.out.println(LINE);
        System.out.println(message);
        System.out.println(LINE);
    }

    /**
     * Shows an error message to the user.
     *
     * @param message The error message to show
     */
    public void showError(String message) {
        System.out.println(LINE);
        System.out.println("ERROR: " + message);
        System.out.println(LINE);
    }

    /**
     * Reads a command from the user.
     *
     * @return The command entered by the user
     */
    public String readCommand() {
        System.out.print("> ");
        return scanner.nextLine();
    }

    /**
     * Reads user confirmation (y/n).
     *
     * @param message The confirmation message to show
     * @return true if the user confirms, false otherwise
     */
    public boolean readConfirmation(String message) {
        System.out.println(LINE);
        System.out.println(message + " (y/n)");
        System.out.print("> ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }
}