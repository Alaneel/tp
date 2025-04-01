# FinBro - Personal Finance Manager

![FinBro Logo](img/FinBro.png)

## Overview

FinBro is a streamlined command-line application designed to help you efficiently manage your personal finances. With its intuitive interactive CLI interface, FinBro enables you to track your income and expenses, categorize transactions, set budgets, establish savings goals, generate financial summaries, and export your financial data—all from the comfort of your terminal.

## Key Features

* **Transaction Management**: Record income and expenses with detailed descriptions and custom tags
* **Categorization System**: Organize expenses into predefined categories for better financial insights
* **Budget Tracking**: Set monthly budgets and track your spending against them
* **Savings Goals**: Establish savings targets and monitor your progress
* **Smart Search**: Find transactions using keywords or date ranges
* **Real-time Balance**: View your current financial position at any time
* **Financial Analysis**: Generate comprehensive summaries to understand your spending patterns
* **Data Export**: Export your financial records in CSV or TXT formats for external analysis

## Quick Start Guide

1. Ensure you have Java 17 installed on your computer
2. Download the latest version of FinBro from the [releases page](https://github.com/yourusername/finbro/releases)
3. Run the application using the command:
   ```
   java -jar FinBro.jar
   ```

## Command Examples

### Adding Income
```
> income
Enter amount:
> 3000
Enter description:
> Monthly salary
Enter up to 3 tags (separated by space or comma), or press Enter to skip:
> work
```

### Recording an Expense
```
> expense
Enter amount:
> 25.50
Enter description:
> Lunch
Please select a category by entering its corresponding index
0 - OTHERS
1 - FOOD
2 - TRANSPORT
3 - SHOPPING
4 - BILLS
5 - ENTERTAINMENT
> 1
Enter up to 3 tags (separated by space or comma), or press Enter to skip:
> work
```

### Setting a Monthly Budget
```
> setbudget
Please enter the month (1-12). (Leave blank for current month)
> 4
Please enter the year. (Leave blank for current year)
> 2025
Enter your budget:
> 1500
```

### Tracking Your Budget
```
> trackbudget
Please enter the month (1-12). (Leave blank for current month)
> 4
Please enter the year. (Leave blank for current year)
> 2025
```

### Setting a Savings Goal
```
> setsavings
Please enter the month (1-12). (Leave blank for current month)
> 4
Please enter the year. (Leave blank for current year)
> 2025
Enter your savings goal:
> 500
```

### Tracking Your Savings Progress
```
> tracksavings
Please enter the month (1-12). (Leave blank for current month)
> 4
Please enter the year. (Leave blank for current year)
> 2025
```

### Checking Your Balance
```
> balance
```

### Viewing a Monthly Summary
```
> summary
Please enter the month (1-12). (Leave blank for current month)
> 4
Please enter the year. (Leave blank for current year)
> 2025
```

## Documentation

* [User Guide](docs/UserGuide.md) - Comprehensive instructions for using FinBro
* [Developer Guide](docs/DeveloperGuide.md) - Technical documentation for developers

## Project Structure

```
finbro/
├── src/
│   ├── main/java/seedu/finbro/
│   │   ├── FinBro.java           # Main application class
│   │   ├── logic/                # Command processing logic
│   │   ├── model/                # Data models
│   │   ├── storage/              # Data persistence
│   │   └── ui/                   # User interface
│   └── test/java/seedu/finbro/   # Test classes
├── data/                         # Data storage directory
├── docs/                         # Documentation
├── build.gradle                  # Build configuration
└── README.md                     # This file
```

## System Requirements

* Java 17 or higher
* Support for text-based interface (any terminal or command prompt)

## Contributing

Contributions to FinBro are welcome! Please refer to the [Developer Guide](docs/DeveloperGuide.md) for details on the project architecture and contribution guidelines.

## License

FinBro is released under the [MIT License](LICENSE)