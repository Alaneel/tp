# Lim Jun Fun - Project Portfolio Page

## Overview

Our team developed FinBro, a personal finance tracker application designed for command-line interaction. It allows users to manage their income and expenses, search and filter transactions, and gain financial insights with minimal friction.

I have focused on implementing the some key functionalities for the application and implementing some JUnit test cases to ensure the application is working as intended.

---

### Code Contributed

[View my code on tP Code Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/?search=ljunfun&sort=groupTitle%20dsc&sortWithin=title&since=2025-02-21&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other) 

---

### Enhancements Implemented

1. **Core Financial Commands in v1.0**
    * Implemented the following commands:
        * `view` / `balance`
          *  What it does: Generates a report of expenses and income for the user to keep track.
          * Justification: Allows user to quickly track the total expenses and income to allow the user to properly allocate budget accordingly.
        * `edit`
          * What it does: Allows the user to update any entry he/she has made to the application.
          * Justification: This allows the user to quickly make changes to their original entry if they have made a mistake to it or they would just want to update with the most accurate value at hand.
    * Enabled guided input mode for `edit` command.
        * What it does: Allows the user to input the fields that they would want to edit.
        * Justification: To allow users to not be overwhelmed by the amount of information they are required to input for one-line inputs, and reduces the errors prone for a failed edit.

2. **Enhancement of existing classes** 
    * Enhanced `Ui.java` with functions such as `readAmount`, `readDescription`, `readDate`, `readCategory` to enable smoother user input for the application and allows the user to input information as an option.
    * Reconfigured `LoggingConfig.java` to adjust the priority levels of logging, to not spam the user with all the logging messages that are unnecessary, and to provide appropriate logging levels for different runtime scenarios.
    * Created `updateTransaction` and `getTransaction` for ease of use of EditCommand to amend anything within the transaction list, and to simplify data manipulation.
3. **Implementation of JUnit Tests**
    * Developed comprehensive JUnit tests for multiple commands:
      * `EditCommand` 
      * `BalanceCommand` 
      * `ClearCommand`
      * `LoggingConfig`
      * `SetBudgetCommandTest`
      * `SetSavingsGoalCommand`
      * `TrackBudgetCommand`
      * `TrackSavingsGoalCommand` 
    * Updated and expanded existing test suites for `Ui` and `Parser` classes.

---

### Contributions to the User Guide

* Documentation for the `view`/`balance` command, including:
    * Date filtering options
    * Output formatting
    * Integration with budgeting features
* Documentation for the `edit` command, covering:
    * Parameter specification
    * Interactive mode usage
    * Error handling scenarios

---

### Contributions to the Developer Guide

* Added sequence diagrams illustrating the workflow of:
    * Balance viewing operations
    * Transaction editing process
* Wrote technical documentation for:
    * Implementation details of transaction updating
    * Balance calculation logic
    * Error handling approaches

---

### Contributions to Team-Based Tasks

- Assisted in debugging and testing features related to user interactions. 
- Participated in milestone planning discussions and contributed to documentation reviews. 
- Contributed to team discussions on UI/UX enhancements and feature prioritization.
- Assisted in verifying cross-component functionality

---

### Review/Mentoring Contributions

- Reviewed multiple Pull Requests, focusing on: Enhancements to `balance` command functionality
- Improvements in error messaging 
- Parser modifications and refinements 
- Provided feedback on handling corner cases and improving overall application reliability. 
- Assisted teammates in troubleshooting various errors and debugging challenges. 
- Guided team members on best practices for code modularization and refactoring.
  - PRs reviewed: [#4](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/4) [#5](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/5) [#26](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/26) [#27](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/27) [#36](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/36) [#39](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/39) [#41](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/41) [#49](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/49) [#50](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/50) [#51](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/51) [#52](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/52) [#74](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/74) [#75](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/75) [#77](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/77) [#79](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/79) [#85](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/85) [#88](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/88) [#89](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/89) [#90](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/90) [#95](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/95) [#96](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/96) [#97](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/97) [#102](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/102) [#105](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/105) [#106](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/106) [#107](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/107) [#109](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/109) [#110](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/110) [#116](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/116) [#117](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/117) [#183](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/183) [#185](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/185) [#189](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/189) [#193](https://github.com/AY2425S2-CS2113-W13-3/tp/pull/193)
  