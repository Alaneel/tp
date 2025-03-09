# FinBro Developer Guide

## Introduction

FinBro is a personal finance management application that operates via a Command Line Interface (CLI). This developer guide provides detailed information about the architecture, implementation, and design decisions of the FinBro application to help new developers understand the codebase and contribute effectively.

## Setting Up

### Prerequisites
- JDK 17
- Gradle 7.6.2 or higher
- IntelliJ IDEA (recommended, not mandatory)

### Getting Started

1. Clone the repository:
```
git clone https://github.com/AY2425S2-CS2113-W13-3/tp.git
```

2. Import the project as a Gradle project in IntelliJ IDEA:
    - Open IntelliJ IDEA
    - Click on "Import Project"
    - Select the `build.gradle` file in the project root directory
    - Follow the prompts to complete the import

3. Verify the setup:
    - Run the tests: `./gradlew test`
    - Run the application: `./gradlew run`

## Design

### Architecture

The FinBro application follows a layered architecture with clear separation of concerns:

![Architecture Diagram](docs/images/architecture.png)

#### Components:

1. **Main Component** (`FinBro.java`): The entry point of the application that coordinates between other components.

2. **UI Component** (`Ui.java`): Handles user interaction through the command line interface.

3. **Logic Component**:
    - `Parser.java`: Parses user input and creates command objects.
    - `Command` classes: Implement the Command pattern for different functionalities.

4. **Model Component**:
    - `Transaction` classes: Represent the core data structures.
    - `TransactionManager`: Manages the collection of transactions and provides operations on them.

5. **Storage Component** (`Storage.java`): Handles saving and loading of data.

### Class Structure

```
seedu.finbro/
├── FinBro.java                 # Main class
├── logic/
│   ├── command/
│   │   ├── Command.java         # Command interface
│   │   ├── IncomeCommand.java
│   │   ├── ExpenseCommand.java
│   │   └── ...                  # Other command implementations
│   └── parser/
│       └── Parser.java          # Input parser
├── model/
│   ├── Transaction.java         # Abstract base class
│   ├── Income.java
│   ├── Expense.java
│   └── TransactionManager.java  # Business logic
├── storage/
│   └── Storage.java             # Data persistence
└── ui/
    └── Ui.java                  # User interface
```

### Sequence Diagrams

#### Adding a Transaction

```
User -> FinBro: input command
FinBro -> Parser: parseCommand(userInput)
Parser -> IncomeCommand: new IncomeCommand(...)
Parser --> FinBro: command
FinBro -> IncomeCommand: execute()
IncomeCommand -> TransactionManager: addTransaction(income)
IncomeCommand -> Storage: saveTransactions()
IncomeCommand --> FinBro: result message
FinBro -> Ui: showMessage(result)
Ui --> User: display result
```

### Design Patterns

The application implements several design patterns:

1. **Command Pattern**: All user actions are encapsulated as command objects implementing the `Command` interface.

2. **Singleton Pattern**: The `TransactionManager` is implemented as a singleton to ensure only one instance manages the transactions.

3. **Factory Method Pattern**: The `Parser` class acts as a factory, creating the appropriate command objects based on user input.

4. **Model-View-Controller (MVC)**: The application follows an MVC-like structure with:
    - Model: `Transaction` classes and `TransactionManager`
    - View: `Ui` class
    - Controller: `Command` classes and `FinBro` class

## Implementation

### Key Features

#### 1. Transaction Management

Transactions are represented by an abstract `Transaction` class with concrete implementations `Income` and `Expense`. The `TransactionManager` provides operations to add, delete, search, and filter transactions.

##### Notable aspects:
- Flexible tag system for categorizing transactions
- Predefined categories for expenses
- Date-based tracking and filtering

#### 2. Command Parsing

The `Parser` class converts user input into appropriate command objects. It handles parameter extraction, validation, and command creation.

```java
public Command parseCommand(String userInput) {
    String[] parts = userInput.split("\\s+", 2);
    String commandWord = parts[0].toLowerCase();
    String arguments = parts.length > 1 ? parts[1] : "";

    switch (commandWord) {
        case "income":
            return parseIncomeCommand(arguments);
        case "expense":
            return parseExpenseCommand(arguments);
        // ... other commands
    }
}
```

#### 3. Data Persistence

The `Storage` class handles saving and loading of transaction data, as well as data export in different formats.

##### File formats:
- Internal data: Custom text format with fields separated by '|'
- Export formats: CSV and TXT

#### 4. Financial Summaries

The `SummaryCommand` generates financial reports for specified time periods, showing income, expenses by category, and overall balance.

### Error Handling

The application implements robust error handling:
- Input validation in the parser
- Exception handling for data operations
- User-friendly error messages

## Testing

### Test Structure

Tests are organized following the same package structure as the main code:

```
test/java/seedu/finbro/
├── logic/
│   ├── command/
│   │   ├── IncomeCommandTest.java
│   │   └── ...
│   └── parser/
│       └── ParserTest.java
├── model/
│   ├── TransactionTest.java
│   └── TransactionManagerTest.java
└── storage/
    └── StorageTest.java
```

### Running Tests

Run all tests:
```
./gradlew test
```

Run a specific test:
```
./gradlew test --tests "seedu.finbro.model.TransactionTest"
```

### Text UI Tests

Text UI testing checks the application's output against expected output:

1. Run the application with test input:
```
cd text-ui-test
./runtest.sh
```

2. The script compares the actual output (`ACTUAL.TXT`) with the expected output (`EXPECTED.TXT`).

## Future Enhancements

Potential improvements for future versions:

1. **Recurring Transactions**: Support for automatically adding recurring income or expenses.

2. **Budget Setting**: Allow users to set budgets for different expense categories.

3. **Data Visualization**: Add simple text-based charts and graphs for financial analysis.

4. **Multiple Accounts**: Support for tracking multiple financial accounts.

5. **Investment Tracking**: Add functionality to track investments and their performance.

## Appendix

### Glossary

- **CLI**: Command Line Interface
- **Transaction**: Any financial event (income or expense)
- **Tag**: User-defined label for categorizing transactions
- **Category**: Predefined classification for expenses

### References

- Java SE 17 Documentation
- JUnit 5 User Guide
- Gradle User Manual