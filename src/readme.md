# Banking Service 

<!-- Brief description -->
This repository contains an implementation of the **Banking Service** technical test provided by Skypay.

<!-- List of features/operations that the solution provides -->
The solution implements the required account operations:
- Deposit
- Withdraw
- Print a bank statement

**Implemented by: Mohamed Amine Ezzaouia**

---

<!-- Section describing the public interface -->
## Public Interface

<!-- Explanation that the original interface requirements are maintained -->
The implementation respects the required interface:

<!-- Code block showing the AccountService interface definition -->
```java
public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
```
-> The public interface is unchanged.

## Implementation Summary

<!-- List of technical choices made in the implementation -->
- Transactions are stored using an ArrayList
- Amounts are handled as int
- Each transaction records its date, amount, and resulting balance
- Dates are obtained using LocalDate.now()
- Statements are printed in reverse chronological order

## Run

<!-- Command to compile Java source files into the 'out' directory -->
```bash
javac -d out src/*.java
```

<!-- Command to execute the Main class from the compiled output -->
```bash
java -cp out Main
```

<!-- Final section with additional information about the project -->
## Notes
The implementation focuses on correctness, simplicity, and compliance with the provided specifications.