package seedu.finbro.logic.parser;

import seedu.finbro.logic.command.*;
import seedu.finbro.model.Expense;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Parses user input and creates the corresponding command.
 */
public class Parser {
    private static final Pattern AMOUNT_PATTERN = Pattern.compile("^\\d+(\\.\\d{1,2})?$");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Parses user input into a Command.
     *
     * @param userInput Full user input string
     * @return The command based on the user input
     */
    public Command parseCommand(String userInput) {
        userInput = userInput.trim();
        if (userInput.isEmpty()) {
            return new HelpCommand();
        }

        String[] parts = userInput.split("\\s+", 2);
        String commandWord = parts[0].toLowerCase();
        String arguments = parts.length > 1 ? parts[1] : "";

        return switch (commandWord) {
            case "income" -> parseIncomeCommand(arguments);
            case "expense" -> parseExpenseCommand(arguments);
            case "list" -> parseListCommand(arguments);
            case "delete" -> parseDeleteCommand(arguments);
            case "search" -> parseSearchCommand(arguments);
            case "filter" -> parseFilterCommand(arguments);
            case "balance" -> new BalanceCommand();
            case "summary" -> parseSummaryCommand(arguments);
            case "export" -> parseExportCommand(arguments);
            case "clear" -> parseClearCommand(arguments);
            case "exit" -> new ExitCommand();
            case "help" -> new HelpCommand();
            default -> new UnknownCommand(commandWord);
        };
    }

    /**
     * Parses arguments into an IncomeCommand.
     *
     * @param args Command arguments
     * @return The IncomeCommand
     */
    private Command parseIncomeCommand(String args) {
        try {
            Map<String, String> parameters = parseParameters(args);

            if (!parameters.containsKey("")) {
                return new InvalidCommand("Amount is required for income command.");
            }

            if (!parameters.containsKey("d")) {
                return new InvalidCommand("Description is required for income command.");
            }

            double amount = parseAmount(parameters.get(""));
            String description = parameters.get("d");
            List<String> tags = parseTags(parameters);

            return new IncomeCommand(amount, description, tags);
        } catch (NumberFormatException e) {
            return new InvalidCommand("Invalid amount format. Please provide a valid number with up to 2 decimal places.");
        } catch (Exception e) {
            return new InvalidCommand("Invalid income command: " + e.getMessage());
        }
    }

    /**
     * Parses arguments into an ExpenseCommand.
     *
     * @param args Command arguments
     * @return The ExpenseCommand
     */
    private Command parseExpenseCommand(String args) {
        try {
            Map<String, String> parameters = parseParameters(args);

            if (!parameters.containsKey("")) {
                return new InvalidCommand("Amount is required for expense command.");
            }

            if (!parameters.containsKey("d")) {
                return new InvalidCommand("Description is required for expense command.");
            }

            double amount = parseAmount(parameters.get(""));
            String description = parameters.get("d");

            Expense.Category category = Expense.Category.OTHERS;
            if (parameters.containsKey("c")) {
                category = Expense.Category.fromString(parameters.get("c"));
            }

            List<String> tags = parseTags(parameters);

            return new ExpenseCommand(amount, description, category, tags);
        } catch (NumberFormatException e) {
            return new InvalidCommand("Invalid amount format. Please provide a valid number with up to 2 decimal places.");
        } catch (Exception e) {
            return new InvalidCommand("Invalid expense command: " + e.getMessage());
        }
    }

    /**
     * Parses arguments into a ListCommand.
     *
     * @param args Command arguments
     * @return The ListCommand
     */
    private Command parseListCommand(String args) {
        try {
            Map<String, String> parameters = parseParameters(args);

            Integer limit = null;
            if (parameters.containsKey("n")) {
                limit = Integer.parseInt(parameters.get("n"));
                if (limit <= 0) {
                    return new InvalidCommand("Number of transactions must be positive.");
                }
            }

            LocalDate date = null;
            if (parameters.containsKey("d")) {
                try {
                    date = LocalDate.parse(parameters.get("d"), DATE_FORMATTER);
                } catch (DateTimeParseException e) {
                    return new InvalidCommand("Invalid date format. Please use YYYY-MM-DD.");
                }
            }

            return new ListCommand(limit, date);
        } catch (NumberFormatException e) {
            return new InvalidCommand("Invalid number format.");
        } catch (Exception e) {
            return new InvalidCommand("Invalid list command: " + e.getMessage());
        }
    }

    /**
     * Parses arguments into a DeleteCommand.
     *
     * @param args Command arguments
     * @return The DeleteCommand
     */
    private Command parseDeleteCommand(String args) {
        try {
            int index = Integer.parseInt(args.trim());
            if (index <= 0) {
                return new InvalidCommand("Index must be a positive integer.");
            }
            return new DeleteCommand(index);
        } catch (NumberFormatException e) {
            return new InvalidCommand("Invalid index. Please provide a valid number.");
        } catch (Exception e) {
            return new InvalidCommand("Invalid delete command: " + e.getMessage());
        }
    }

    /**
     * Parses arguments into a SearchCommand.
     *
     * @param args Command arguments
     * @return The SearchCommand
     */
    private Command parseSearchCommand(String args) {
        if (args.trim().isEmpty()) {
            return new InvalidCommand("Search command requires at least one keyword.");
        }

        List<String> keywords = Arrays.asList(args.trim().split("\\s+"));
        return new SearchCommand(keywords);
    }

    /**
     * Parses arguments into a FilterCommand.
     *
     * @param args Command arguments
     * @return The FilterCommand
     */
    private Command parseFilterCommand(String args) {
        try {
            Map<String, String> parameters = parseParameters(args);

            if (!parameters.containsKey("d")) {
                return new InvalidCommand("Start date is required for filter command.");
            }

            LocalDate startDate;
            try {
                startDate = LocalDate.parse(parameters.get("d"), DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                return new InvalidCommand("Invalid start date format. Please use YYYY-MM-DD.");
            }

            LocalDate endDate = null;
            if (parameters.containsKey("to")) {
                try {
                    endDate = LocalDate.parse(parameters.get("to"), DATE_FORMATTER);
                    if (endDate.isBefore(startDate)) {
                        return new InvalidCommand("End date cannot be earlier than start date.");
                    }
                } catch (DateTimeParseException e) {
                    return new InvalidCommand("Invalid end date format. Please use YYYY-MM-DD.");
                }
            }

            return new FilterCommand(startDate, endDate);
        } catch (Exception e) {
            return new InvalidCommand("Invalid filter command: " + e.getMessage());
        }
    }

    /**
     * Parses arguments into a SummaryCommand.
     *
     * @param args Command arguments
     * @return The SummaryCommand
     */
    private Command parseSummaryCommand(String args) {
        try {
            Map<String, String> parameters = parseParameters(args);

            Integer month = null;
            if (parameters.containsKey("m")) {
                month = Integer.parseInt(parameters.get("m"));
                if (month < 1 || month > 12) {
                    return new InvalidCommand("Month must be between 1 and 12.");
                }
            }

            Integer year = null;
            if (parameters.containsKey("y")) {
                year = Integer.parseInt(parameters.get("y"));
                if (year < 1900 || year > 2100) {
                    return new InvalidCommand("Year must be between 1900 and 2100.");
                }
            }

            return new SummaryCommand(month, year);
        } catch (NumberFormatException e) {
            return new InvalidCommand("Invalid number format.");
        } catch (Exception e) {
            return new InvalidCommand("Invalid summary command: " + e.getMessage());
        }
    }

    /**
     * Parses arguments into an ExportCommand.
     *
     * @param args Command arguments
     * @return The ExportCommand
     */
    private Command parseExportCommand(String args) {
        try {
            Map<String, String> parameters = parseParameters(args);

            String format = "csv"; // Default format
            if (parameters.containsKey("f")) {
                format = parameters.get("f").toLowerCase();
                if (!format.equals("csv") && !format.equals("txt")) {
                    return new InvalidCommand("Export format must be either 'csv' or 'txt'.");
                }
            }

            return new ExportCommand(format);
        } catch (Exception e) {
            return new InvalidCommand("Invalid export command: " + e.getMessage());
        }
    }

    /**
     * Parses arguments into a ClearCommand.
     *
     * @param args Command arguments
     * @return The ClearCommand
     */
    private Command parseClearCommand(String args) {
        boolean isConfirmed = args.trim().equalsIgnoreCase("confirm");
        return new ClearCommand(isConfirmed);
    }

    /**
     * Parses a string into parameters.
     *
     * @param paramString The string containing parameters
     * @return A map of parameter prefixes to values
     */
    private Map<String, String> parseParameters(String paramString) {
        Map<String, String> parameters = new HashMap<>();
        String[] tokens = paramString.trim().split("\\s+");

        // Handle the first parameter (usually amount)
        if (tokens.length > 0 && !tokens[0].contains("/")) {
            parameters.put("", tokens[0]);
        }

        // Process the rest of the parameters
        String currentPrefix = null;
        StringBuilder currentValue = new StringBuilder();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            // Skip the first token if it was already processed as the main parameter
            if (i == 0 && parameters.containsKey("")) {
                continue;
            }

            // Check if this token starts a new parameter
            if (token.matches("[a-zA-Z]+/.*")) {
                // Save the previous parameter if it exists
                if (currentPrefix != null) {
                    parameters.put(currentPrefix, currentValue.toString().trim());
                    currentValue = new StringBuilder();
                }

                // Extract the new prefix and start building its value
                int slashIndex = token.indexOf('/');
                currentPrefix = token.substring(0, slashIndex);
                currentValue.append(token.substring(slashIndex + 1));
            } else if (currentPrefix != null) {
                // Continue building the current parameter value
                currentValue.append(" ").append(token);
            }
        }

        // Save the last parameter if it exists
        if (currentPrefix != null) {
            parameters.put(currentPrefix, currentValue.toString().trim());
        }

        return parameters;
    }

    /**
     * Parses a string into a valid amount.
     *
     * @param amountStr The string to parse
     * @return The amount as a double
     * @throws NumberFormatException if the string is not a valid amount
     */
    private double parseAmount(String amountStr) throws NumberFormatException {
        if (!AMOUNT_PATTERN.matcher(amountStr).matches()) {
            throw new NumberFormatException("Invalid amount format.");
        }
        return Double.parseDouble(amountStr);
    }

    /**
     * Extracts tags from parameters.
     *
     * @param parameters The parameters map
     * @return A list of tags
     */
    private List<String> parseTags(Map<String, String> parameters) {
        List<String> tags = new ArrayList<>();

        // Look for parameters with prefix 't'
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            if (entry.getKey().equals("t")) {
                tags.add(entry.getValue());
            }
        }

        return tags;
    }
}