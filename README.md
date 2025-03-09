# FinBro - Personal Finance Manager

FinBro is a command-line application designed to help you manage your personal finances efficiently. With its straightforward CLI interface, FinBro allows you to track income, expenses, view financial summaries, and export your financial data, all from the comfort of your terminal.

![FinBro Logo](docs/images/finbro_logo.png)

## Features

* Track income and expenses with detailed descriptions and tags
* Categorize expenses for better organization
* Search and filter transactions by keywords or date ranges
* View your current balance at any time
* Generate financial summaries to understand your spending patterns
* Export your financial data for further analysis or record-keeping

## Quick Start

1. Ensure you have Java 17 installed on your computer
2. Download the latest version of FinBro from the [releases page](https://github.com/yourusername/finbro/releases)
3. Run the application using:
   ```
   java -jar FinBro.jar
   ```

## Sample Usage

### Adding income
```
income 3000 d/Monthly salary t/work
```

### Adding expense
```
expense 25.50 d/Lunch c/Food t/work
```

### Viewing current balance
```
balance
```

### Viewing a monthly summary
```
summary m/2 y/2025
```

## Documentation

* [User Guide](docs/UserGuide.md) - Detailed instructions on how to use FinBro
* [Developer Guide](docs/DeveloperGuide.md) - Information for developers who wish to contribute or understand the implementation

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

## Requirements

* Java 17 or higher
* Support for text-based interface (any terminal or command prompt)

## Contributing

Contributions to FinBro are welcome! Please refer to the [Developer Guide](docs/DeveloperGuide.md) for details on the project architecture and contribution guidelines.

## License

FinBro is released under the [MIT License](LICENSE)