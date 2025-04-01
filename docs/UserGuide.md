# FinBro User Guide

![FinBro Logo](img/FinBro.png)

## Table of Contents
* [Introduction](#introduction)
* [Quick Start](#quick-start)
* [Understanding the Interface](#understanding-the-interface)
* [Features](#features)
    * [Transaction Management](#transaction-management)
        * [Recording Income](#recording-income)
        * [Recording Expenses](#recording-expenses)
        * [Viewing Transactions](#viewing-transactions)
        * [Editing Transactions](#editing-transactions)
        * [Removing Transactions](#removing-transactions)
    * [Finding and Filtering](#finding-and-filtering)
        * [Searching Transactions](#searching-transactions)
        * [Filtering by Date](#filtering-by-date)
    * [Financial Planning](#financial-planning)
        * [Setting Budgets](#setting-budgets)
        * [Tracking Budgets](#tracking-budgets)
        * [Setting Savings Goals](#setting-savings-goals)
        * [Tracking Savings Goals](#tracking-savings-goals)
    * [Financial Insights](#financial-insights)
        * [Checking Balance](#checking-balance)
        * [Generating Summary](#generating-summary)
    * [Data Management](#data-management)
        * [Exporting Data](#exporting-data)
        * [Clearing All Data](#clearing-all-data)
* [Command Summary](#command-summary)
* [FAQ](#faq)

## Introduction

Welcome to FinBro, your personal finance management companion.

FinBro is a desktop application optimized for use via an Interactive Command Line Interface (CLI). If you prefer typing to clicking, FinBro offers an intuitive way to manage your finances more efficiently than traditional GUI applications, with a guided approach that simplifies data entry.

Key capabilities include:
- Recording income and expenses with detailed categorization
- Setting and tracking monthly budgets
- Establishing and monitoring savings goals
- Searching and filtering transactions
- Generating financial summaries and reports
- Exporting data for external analysis

## Quick Start

1. Ensure you have Java 17 or above installed on your computer.
2. Download the latest `FinBro.jar` from [here](https://github.com/AY2425S2-CS2113-W13-3/tp/releases).
3. Copy the file to the folder you want to use as the home folder for FinBro.
4. Open a command prompt/terminal and navigate to the folder where you placed the jar file.
5. Run the application using: `java -jar FinBro.jar`
6. Type a command in the command box and press Enter to execute it.
7. Follow the interactive prompts to complete the command.
8. Type `help` and press Enter to display a summary of available commands.

## Understanding the Interface

FinBro uses an interactive command approach. Rather than requiring you to type complex commands with multiple parameters, it guides you through each step:

1. You enter a basic command keyword (like `income` or `expense`)
2. FinBro prompts you for each piece of information needed
3. You provide the information one step at a time
4. The command is completed once all necessary information is gathered

This approach makes the application more user-friendly and reduces errors in command syntax.

## Features

### Transaction Management

#### Recording Income

Records money received into your account.

**Command:** `income`

**Interactive Process:**
```
Enter command word:
> income
 
Enter amount:
> 3000.00

Enter description:
> Monthly salary

Enter up to 3 tags (separated by space or comma), or press Enter to skip:
> Work, Primary
```

**Notes:**
- Amount must be a positive number with up to 2 decimal places
- Description is required and helps identify the transaction
- Tags are optional and help categorize income sources
- You can enter up to 3 tags, separated by spaces or commas

**Duplicate Detection:**
FinBro automatically checks for duplicate transactions based on the same amount and description. If a potential duplicate is detected:
1. You'll receive a warning message
2. You'll be asked to confirm whether to proceed
3. You can cancel the transaction if it was a mistake

---

#### Recording Expenses

Records money spent from your account.

**Command:** `expense`

**Interactive Process:**
```
Enter command word:
> expense
 
Enter amount:
> 25.50

Enter description:
> Lunch with colleagues

Please select a category by entering its corresponding index
0 - OTHERS
1 - FOOD
2 - TRANSPORT
3 - SHOPPING
4 - BILLS
5 - ENTERTAINMENT
> 1

Enter up to 3 tags (separated by space or comma), or press Enter to skip:
> Work
```

**Notes:**
- Amount must be a positive number with up to 2 decimal places
- Description is required
- Category must be selected from the provided list by entering the corresponding index
- Tags are optional and help with more detailed expense tracking
- Duplicate detection works the same as for income transactions

---

#### Viewing Transactions

Displays your transaction history.

**Command:** `list`

**Interactive Process:**
```
Enter command word:
> list

Please enter the start date in the format yyyy-mm-dd. (Leave blank to show all transactions. You can choose the number of transactions to show after this prompt.)
> 

Enter number of transactions to list. (Leave blank to show all transactions.)
> 5
```

**Notes:**
- Leaving the date field blank shows transactions from all dates
- Leaving the number field blank shows all transactions
- Transactions are displayed in reverse chronological order (newest first)
- Each transaction is shown with its index, which is used for edit and delete operations

---

#### Editing Transactions

Modifies an existing transaction's details.

**Command:** `edit`

**Interactive Process:**
```
Enter command word:
> edit

Enter the index of transaction to edit:
> 2

Do you want to edit transaction at index 2? (y/n)
> y

Enter new amount (press Enter to skip):
> 35.00

Enter new description (press Enter to skip):
> Grocery run

Enter new date (YYYY-MM-DD) (press Enter to skip):
>

Enter new category (press Enter to skip, 'y' to select from menu):
>

Enter new tags (comma separated, press Enter to skip, 'y' to select):
>
```

**Notes:**
- You can leave any field blank to keep its original value
- Only fields you provide values for will be updated
- The transaction's type (income or expense) cannot be changed
- You'll be asked to confirm before editing the transaction

---

#### Removing Transactions

Removes a transaction from your records.

**Command:** `delete`

**Interactive Process:**
```
Enter command word:
> delete

Enter a number or range to delete. (e.g., '1' or '2-5')
> 3
```

**Notes:**
- You can delete a single transaction by specifying its index
- You can delete a range of transactions by specifying a start and end index (e.g., "2-5")
- Indices are based on the current listing order in the application
- After deletion, the remaining transactions are re-indexed

---

### Finding and Filtering

#### Searching Transactions

Finds transactions containing specific keywords.

**Command:** `search`

**Interactive Process:**
```
Enter command word:
> search

Enter keyword or string to search:
> grocery lunch
```

**Notes:**
- Search is case-sensitive
- Only the description field is searched
- Only transactions containing entire keyword will be shown
- Multiple keywords can be entered to find transactions matching any of them

---

#### Filtering by Date

Shows transactions within a specific time period.

**Command:** `filter`

**Interactive Process:**
```
Enter command word:
> filter

Please enter the start date in the format yyyy-mm-dd.
> 2025-02-01

Please enter the end date in the format yyyy-mm-dd. (Leave blank to show transactions up to current date.)
> 2025-02-28
```

**Notes:**
- Dates must be in the format yyyy-mm-dd
- If end date is omitted, it defaults to the current date
- Both start and end dates are inclusive in the filter

---

### Financial Planning

#### Setting Budgets

Sets a spending limit for a specific month.

**Command:** `setbudget`

**Interactive Process:**
```
Enter command word:
> setbudget

Please enter the month (1-12). (Leave blank for current month)
> 4

Please enter the year. (Leave blank for current year)
> 2025

Enter your budget:
> 1500
```

**Notes:**
- Month is specified as a number (1-12)
- Year should be a 4-digit number
- Budget is a positive number representing your spending limit
- If a budget already exists for the specified month, it will be updated

---

#### Tracking Budgets

Checks your progress against the set budget.

**Command:** `trackbudget`

**Interactive Process:**
```
Enter command word:
> trackbudget

Please enter the month (1-12). (Leave blank for current month)
> 4

Please enter the year. (Leave blank for current year)
> 2025
```

**Notes:**
- Shows the budget amount, total expenses, and remaining budget
- Warns if you have exceeded your budget
- If no budget is set for the specified month, prompts you to set one

---

#### Setting Savings Goals

Sets a savings target for a specific month.

**Command:** `setsavings`

**Interactive Process:**
```
Enter command word:
> setsavings

Please enter the month (1-12). (Leave blank for current month)
> 4

Please enter the year. (Leave blank for current year)
> 2025

Enter your savings goal:
> 500
```

**Notes:**
- Month is specified as a number (1-12)
- Year should be a 4-digit number
- Savings goal is a positive number representing your target
- If a savings goal already exists for the specified month, it will be updated

---

#### Tracking Savings Goals

Checks your progress toward your savings goal.

**Command:** `tracksavings`

**Interactive Process:**
```
Enter command word:
> tracksavings

Please enter the month (1-12). (Leave blank for current month)
> 4

Please enter the year. (Leave blank for current year)
> 2025
```

**Notes:**
- Shows the savings goal, total income, total expenses, and calculated savings
- Congratulates you if you've met your savings goal
- If no goal is set for the specified month, prompts you to set one

---

### Financial Insights

#### Checking Balance

Shows your current account balance.

**Command:** `balance` or `view`

**Example Output:**
```
Current Balance: $1,970.00
Total Income: $2,000.00
Total Expenses: $30.00
```

**Notes:**
- Shows your overall financial position
- Balance is calculated as the sum of all income minus the sum of all expenses
- No additional parameters are needed for this command

---

#### Generating Summary

Provides an overview of your financial activity for a specific period.

**Command:** `summary`

**Interactive Process:**
```
Enter command word:
> summary

Please enter the month (1-12). (Leave blank for current month)
> 4

Please enter the year. (Leave blank for current year)
> 2025
```

**Example Output:**
```
Financial Summary for April 2025:

Total Income: $4700.50
Total Expenses: $427.49

Top Expense Categories:
1. Bills: $150.20
2. Food: $145.50
3. Shopping: $75.00

Tags Summary:
1. Work: $3025.50
2. Primary: $3000.00
3. Annual: $1200.00
...
```

**Notes:**
- Provides a comprehensive financial overview for the specified month
- Shows total income and expenses
- Lists top expense categories in descending order
- Shows all used tags with their associated amounts
- If month/year are omitted, defaults to the current month and year

---

### Data Management

#### Exporting Data

Exports your financial records to a file.

**Command:** `export`

**Interactive Process:**
```
Enter command word:
> export

Enter export format (csv/txt) or press Enter for default (csv):
> txt
```

**Notes:**
- Exports all your transactions to a file for backup or analysis
- Supported formats: CSV (default) and TXT
- CSV format is suitable for importing into spreadsheet applications
- TXT format provides a human-readable report
- Exported files are saved in the "exports" directory with a timestamp
- CSV exports now include budget and savings goal information

---

#### Clearing All Data

Deletes all your financial records.

**Command:** `clear`

**Interactive Process:**
```
Enter command word:
> clear

Warning: This will delete all your data. Are you sure? (y/n)
> 
```

**Notes:**
- This action cannot be undone, so use with caution
- You will be asked to confirm with 'y' (yes) or 'n' (no)
- All transactions, budgets, and savings goals will be permanently deleted

---

### Additional Commands

#### Exiting the Program

Closes the application.

**Command:** `exit`

**Notes:**
- Ensures all data is saved before exiting
- Displays a goodbye message

---

#### Getting Help

Displays the list of available commands.

**Command:** `help`

**Notes:**
- Shows a summary of all available commands and their functions
- Useful for quick reference when you forget a command

---

## Command Summary

| Action             | Command Word     | Function                                        |
|--------------------|------------------|--------------------------------------------------|
| Add Income         | `income`         | Record money received with description and tags  |
| Add Expense        | `expense`        | Record money spent with category and tags        |
| List Transactions  | `list`           | Display transaction history with optional filters |
| Edit Transaction   | `edit`           | Modify an existing transaction's details         |
| Delete Transaction | `delete`         | Remove a transaction from your records           |
| Search             | `search`         | Find transactions by keyword                     |
| Filter             | `filter`         | Show transactions within a date range            |
| Set Budget         | `setbudget`      | Set a spending limit for a specific month        |
| Track Budget       | `trackbudget`    | Check progress against your budget               |
| Set Savings Goal   | `setsavings`     | Set a savings target for a specific month        |
| Track Savings      | `tracksavings`   | Check progress toward your savings goal          |
| View Balance       | `balance`/`view` | See your current financial position              |
| View Summary       | `summary`        | Get a financial overview for a specific month    |
| Export Data        | `export`         | Save your financial records to a file            |
| Clear Data         | `clear`          | Delete all your financial data                   |
| Exit               | `exit`           | Close the application                            |
| Help               | `help`           | Display available commands                       |

## FAQ

**Q: How do I transfer my data to another computer?**

A: Copy the entire "data" folder from your current installation to the same location as FinBro.jar on the new computer. This folder contains all your transaction data, budgets, and savings goals.

**Q: Can I use decimal points in the amount?**

A: Yes, you can use up to 2 decimal places for transaction amounts (e.g., 25.50).

**Q: What happens if I enter invalid input?**

A: FinBro provides clear error messages and usually prompts you to try again. The interactive design helps prevent many common input errors.

**Q: What is the difference between tags and categories?**

A: Categories are predefined classifications for expenses (Food, Transport, etc.), while tags are custom labels that you can apply to both income and expenses for more personalized tracking.

**Q: How do I back up my financial data?**

A: Use the `export` command to create a CSV or TXT file containing all your transactions, budgets, and savings goals. Store this exported file in a safe location.

**Q: Can I import data from other financial applications?**

A: FinBro doesn't currently support direct import from other applications. However, you can manually enter your transactions using the `income` and `expense` commands.

**Q: What happens if I close the application without using the `exit` command?**

A: FinBro automatically saves your data after each transaction, so you shouldn't lose any recorded information. However, it's always best to exit properly using the `exit` command.

**Q: How far back can I track my finances?**

A: There's no time limit - you can track your finances as far back as needed by entering the appropriate dates for your transactions.