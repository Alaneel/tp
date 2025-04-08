# Ng Ya Xuen - Project Portfolio Page

## Overview
Our team developed FinBro, a personal finance tracker application designed for command-line interaction. It allows users to manage their income and expenses, search and filter transactions, and gain financial insights with minimal friction.

I focused on implementing and testing the command parsing logic, ensuring that key financial features such as financial summaries, filtering, budgeting, and savings goal tracking functioned correctly and efficiently.

---

### Summary of Contributions
[View my code on tP Code Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/?search=laitcanard05&breakdown=true)

---

### Enhancements Implemented

1. **Implementation of Key Financial Commands**
    * Developed the command parsing logic for:
        * `summary`: Generates a financial summary, displaying income, expenses, and net balance.
        * `filter`: Filters transactions based on date range and/or category.'
        * `trackbudget`: Enables users to track monthly budgets.
        * `setsavings`: Allows users to set monthly savings goals.
        * `tracksavings`: Allows users to monitor monthly savings goals.
    * Integrated user-friendly guided input prompts for seamless interaction.

2. **Enhancement of Existing Classes**
    * Improved `Ui.java` with structured input handling functions such as `readMonthYear()` and `readDates()` to enhance usability.
    * Optimized `Parser.java` with a main parsing function `parseCommandWord(userInput, ui)` that allows for subsequent calling of 
helper functions in `Ui.java` to prompt for subsequent inputs from the user to support a more user-interactive command parsing experience.
    * Extended Parser to support new commands:
        * `summary`
        * `filter`
        * `trackbudget`
        * `setsavings`
        * `tracksavings`
    * Implemented additional helper methods in `TransactionManager.java` for budget and savings calculations, filtering of transactions by month sorted by category or tag.

3. **Implementation of JUnit Tests**
    * Wrote comprehensive JUnit tests for:
        * `SummaryCommand`
        * `FilterCommand`

4. **Savings Goals Persistence System**
    * Developed the logic in `Storage.java` to save and load monthly savings goals from `savings_goals.txt`.
    * Used a simple `yyyy-MM|amount` format for easy readability and debugging.

---

### Contributions to the User Guide

- Documented:
    - Interactive usage of `summary`, `filter`, `trackbudget`, `setsavings` and `tracksavings` commands.
    - Provided example outputs of these features for better user understanding.

---

### Contributions to the Developer Guide

- Added:
    - Sequence diagrams for `summary`, and `filter` commands.
    - Class diagrams for `Ui` and Command classes including `Command`, `SetBudgetCommand`, `TrackBudgetCommand`, 
`SetSavingsGoalCommand`, `TrackSavingsGoalCommand`, `BalanceCommand`, `ClearCommand` and `ExportCommand`.
    - Detailed descriptions of the sequence diagrams for key operations explaining the general execution flow of these features.

---

### Contributions to Team-Based Tasks

- Assisted in testing and debugging features related to financial calculations and user interaction.
- Collaborated on refining error handling and validation logic across different commands.
- Participated in milestone discussions and documentation reviews.

---

### Review/Mentoring Contributions

- Reviewed PRs related to budgeting features and user input parsing.
- Assisted teammates in troubleshooting command parsing errors and debugging logic-related issues.

