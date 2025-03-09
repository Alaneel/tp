# FinBro User Guide

## Introduction
FinBro is a desktop application for managing personal finances, optimized for use via a Command Line Interface (CLI). If you can type fast, FinBro can help you manage your finances more efficiently than traditional GUI apps!

## Quick Start
1. Ensure you are using Java 17 only
2. Download the latest FinBro.jar file
3. Run the jar file in your terminal using: `java -jar FinBro.jar` (Ensure you are in the correct working directory)

## Features
### Notes:
- Words in UPPER_CASE are the parameters to be supplied by the user
- e.g., in `income AMOUNT d/DESCRIPTION`, AMOUNT is a parameter which can be used as `income 3000 d/Monthly salary`
- Items in square brackets are optional
- e.g., `expense AMOUNT d/DESCRIPTION [c/CATEGORY]` can be used as `expense 25.50 d/Lunch c/Food` or `expense 25.50 d/Lunch`
- Items with `...` after them can be used multiple times including zero times
- e.g., `[t/TAG]...` can be used as `t/work t/urgent` or omitted entirely
- Parameters can be in any order

### Transaction Management

#### Adding income: `income`
Adds an income transaction to track money received.

Format: `income AMOUNT d/DESCRIPTION [t/TAG]...`
- AMOUNT must be a positive number with up to 2 decimal places
- DESCRIPTION must not be empty
- Multiple tags are allowed

Examples:
```
income 3000 d/Monthly salary t/work
income 500.50 d/Freelance project t/work t/design
```

#### Adding expense: `expense`
Records money spent on various items or services.

Format: `expense AMOUNT d/DESCRIPTION [c/CATEGORY] [t/TAG]...`
- AMOUNT must be a positive number with up to 2 decimal places
- DESCRIPTION must not be empty
- CATEGORY must be one of the following: Food, Transport, Shopping, Bills, Entertainment, Others
- If no category is specified, it defaults to "Others"

Examples:
```
expense 25.50 d/Lunch c/Food t/work
expense 75 d/New shoes c/Shopping
expense 10.80 d/Bus fare c/Transport
```

#### Listing transactions: `list`
Shows a list of all transactions in reverse chronological order.

Format: `list [n/NUMBER] [d/DATE]`
- NUMBER specifies how many transactions to show
- DATE must be in YYYY-MM-DD format
- If no parameters are provided, lists all transactions

Examples:
```
list
list n/10
list d/2025-02-18
```

#### Deleting transactions: `delete`
Removes a transaction from the record.

Format: `delete INDEX`
- Deletes the transaction at the specified INDEX
- INDEX must be a positive integer referring to the transaction number shown in the list

Examples:
```
delete 1
```

#### Searching transactions: `search`
Finds transactions whose descriptions contain any of the given keywords.

Format: `search KEYWORD [MORE_KEYWORDS]...`
- Search is case-insensitive
- Only the description field is searched
- Transactions matching at least one keyword will be returned

Examples:
```
search grocery
search lunch dinner
```

#### Filtering transactions: `filter`
Shows transactions within a specific date range.

Format: `filter d/DATE [to/DATE]`
- DATE must be in YYYY-MM-DD format
- If to/DATE is not specified, shows transactions from the specified date to present

Examples:
```
filter d/2025-02-01 to/2025-02-18
filter d/2025-02-01
```

#### Viewing current balance: `balance`
Shows the current account balance based on all recorded transactions.

Format: `balance`

#### Viewing financial summary: `summary`
Generates a summary of income and expenses for a specific period.

Format: `summary [m/MONTH] [y/YEAR]`
- MONTH must be 1-12
- YEAR must be a valid 4-digit year
- If no parameters are provided, shows summary for the current month

Examples:
```
summary
summary m/2 y/2025
```

### Data Management

#### Exporting data: `export`
Exports all financial data to a file.

Format: `export [f/FORMAT]`
- FORMAT must be either csv or txt
- If format is not specified, defaults to csv
- File will be saved in the same directory as the application

Examples:
```
export
export f/txt
```

#### Clearing all data: `clear`
Deletes all financial records.

Format: `clear`
- This action cannot be undone
- Requires confirmation before proceeding

#### Exiting the program: `exit`
Closes the application.

Format: `exit`

## Command Summary

| Action | Format | Examples |
|--------|--------|----------|
| Add Income | `income AMOUNT d/DESCRIPTION [t/TAG]...` | `income 3000 d/Monthly salary t/work` |
| Add Expense | `expense AMOUNT d/DESCRIPTION [c/CATEGORY] [t/TAG]...` | `expense 25.50 d/Lunch c/Food t/work` |
| List Transactions | `list [n/NUMBER] [d/DATE]` | `list n/10` |
| Delete Transaction | `delete INDEX` | `delete 1` |
| Search | `search KEYWORD [MORE_KEYWORDS]...` | `search grocery food` |
| Filter | `filter d/DATE [to/DATE]` | `filter d/2025-02-01 to/2025-02-18` |
| View Balance | `balance` | `balance` |
| View Summary | `summary [m/MONTH] [y/YEAR]` | `summary m/2 y/2025` |
| Export Data | `export [f/FORMAT]` | `export f/csv` |
| Clear Data | `clear` | `clear` |
| Exit | `exit` | `exit` |