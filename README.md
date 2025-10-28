# Console Bank 🏦

A production-grade command-line banking application built with Java, demonstrating clean architecture principles and advanced Java concepts.

## 📋 Overview

Console Bank is a fully functional banking system that runs in your terminal. It showcases enterprise-level code structure with proper separation of concerns, custom exception handling, and comprehensive validation.

## ✨ Features

- **Account Management**
  - Open new accounts (Savings/Current)
  - List all accounts
  - Search accounts by customer name

- **Transaction Operations**
  - Deposit funds
  - Withdraw funds
  - Transfer between accounts
  - View account statements

- **Robust Validation**
  - Custom name validation
  - Email format validation
  - Amount validation
  - Account type validation

## 🏗️ Architecture

The project follows a layered architecture pattern:

```
console-bank/
├── app/                    # Application entry point
│   └── Main.java
├── domain/                 # Domain entities
│   ├── Account.java
│   ├── Transaction.java
│   └── Type.java (Enum)
├── Service/                # Business logic layer
│   ├── BankService.java (Interface)
│   └── imp/
│       └── BankServiceImpl.java
├── repository/             # Data access layer
│   ├── AccountRepository.java
│   └── TransactionRepository.java
├── exception/              # Custom exceptions
│   ├── InvalidEmailException.java
│   ├── InvalidAmountException.java
│   └── InsufficientBalanceException.java
└── validator/              # Custom validators
    ├── EmailValidator.java
    ├── NameValidator.java
    └── AmountValidator.java
```

## 🔧 Java Concepts Demonstrated

### Core Concepts
- **OOP Principles**: Encapsulation, Inheritance, Polymorphism
- **Interface**: Service layer abstraction
- **Enums**: Transaction types, Account types
- **Exception Handling**: Custom exceptions for business rules
- **Collections**: List, Map, Stream API

### Advanced Concepts
- **Generics**: Repository pattern with type parameters
- **Lambda Expressions**: Functional programming with streams
- **Method References**: Cleaner code with `::` operator
- **Optional**: Null-safe operations
- **Stream API**: Filtering, mapping, and collecting data

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Installation

1. Clone the repository
```bash
git clone https://github.com/yourusername/console-bank.git
cd console-bank
```

2. Compile the project
```bash
javac -d out src/**/*.java
```

3. Run the application
```bash
java -cp out app.Main
```

## 💻 Usage

### Main Menu
```
Welcome to Console Bank
1) Open Account
2) Deposit
3) Withdraw
4) Transfer
5) Account Statement
6) List Accounts
7) Search Accounts by Customer Name
0) Exit
```

### Example Workflow

**Opening an Account:**
```
CHOOSE: 1
Customer Name: John Doe
Customer Email: john.doe@example.com
Account Type (SAVINGS/CURRENT): SAVINGS
Initial Deposit (optional, blank for 0): 1000
Account Opened: AC000001
```

**Making a Deposit:**
```
CHOOSE: 2
Account Number: AC000001
Amount: 500
Deposited
```

**Checking Account List:**
```
CHOOSE: 6
AC000001 | SAVINGS | 1500.0
```

## 🔐 Validation Rules

- **Name**: Must be 2-50 characters, letters and spaces only
- **Email**: Must follow standard email format (user@domain.com)
- **Amount**: Must be positive, non-zero value
- **Account Type**: Must be either SAVINGS or CURRENT

## 📊 Domain Model

### Account
- Account Number (Auto-generated: AC000001, AC000002, ...)
- Customer ID (UUID)
- Account Type (SAVINGS/CURRENT)
- Balance

### Transaction
- Transaction ID (UUID)
- Account Number
- Amount
- Timestamp
- Description
- Type (DEPOSIT/WITHDRAW/TRANSFER)

## 🛠️ Technical Highlights

### Repository Pattern
```java
public class AccountRepository {
    private Map<String, Account> accounts = new HashMap<>();
    
    public void save(Account account) { ... }
    public Optional<Account> findByNumber(String accountNumber) { ... }
    public List<Account> findAll() { ... }
}
```

### Service Layer with Business Logic
```java
public interface BankService {
    String openAccount(String name, String email, String accountType);
    void deposit(String accountNumber, Double amount, String note);
    void withdraw(String accountNumber, Double amount, String note);
    // ... other methods
}
```

### Custom Exception Handling
```java
if (amount <= 0) {
    throw new InvalidAmountException("Amount must be positive");
}

if (account.getBalance() < amount) {
    throw new InsufficientBalanceException("Insufficient funds");
}
```

### Stream API Usage
```java
return accountRepository.findAll().stream()
    .filter(a -> a.getCustomerName().contains(searchTerm))
    .sorted(Comparator.comparing(Account::getAccountNumber))
    .collect(Collectors.toList());
```

## 🧪 Testing

The application includes comprehensive validation and error handling:
- Input validation at service layer
- Custom exceptions for business rule violations
- Transaction integrity checks
- Balance verification before withdrawals

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 Future Enhancements

- [ ] Add customer management (separate Customer entity)
- [ ] Implement interest calculation for savings accounts
- [ ] Add transaction history with pagination
- [ ] Export statements to PDF/CSV
- [ ] Add authentication and authorization
- [ ] Implement account closure functionality
- [ ] Add scheduled/recurring transactions
- [ ] Multi-currency support

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

Your Name
- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [Your Name](https://linkedin.com/in/yourprofile)

## 🙏 Acknowledgments

- Inspired by real-world banking systems
- Built as a demonstration of Java best practices
- Clean architecture principles

---

⭐ If you found this project helpful, please consider giving it a star!
