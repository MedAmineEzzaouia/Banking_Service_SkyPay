<!-- ============================================ -->
<!-- PROJECT HEADER -->
<!-- ============================================ -->

# Banking Service – Technical Test

<!-- Introduction paragraph explaining the repository purpose and origin -->
This repository contains an implementation of the **Banking Service** technical test provided by **Skypay**.  It implements the required account operations:
<!-- List of core functionalities implemented -->
- Deposit
- Withdraw
- Print a bank statement

Implemented by: Mohamed Amine Ezzaouia

---

<!-- ============================================ -->
<!-- PUBLIC INTERFACE SECTION -->
<!-- ============================================ -->

## Public Interface

The implementation respects the required interface:

<!-- Code block displaying the AccountService interface contract -->
```java
public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
```

<!-- Confirmation statement emphasizing no changes to the public API -->
This public interface is unchanged, as mandated by the specification.

<!-- ============================================ -->
<!-- IMPLEMENTATION DETAILS SECTION -->
<!-- ============================================ -->

## Implementation Summary

<!-- List of key technical decisions and implementation details -->

*Transactions are stored in an ArrayList.
*Monetary amounts are handled as int.
*Each transaction records its date, amount and resulting balance.
*Statements are printed in reverse chronological order, following the desired behaviour.
*Invalid inputs and insufficient balance conditions throw exceptions, as required.

<!-- ============================================ -->
<!-- DATE HANDLING EXPLANATION SECTION -->
<!-- ============================================ -->

## Date handling

<!-- Detailed explanation of the clock abstraction design decision -->
The solution uses a Clock abstraction (with SystemClock for production and StubClock for tests) to obtain transaction dates. This keeps the public interface simple and decouples business logic from the system clock. It also makes acceptance tests deterministic and easier to implement.

<!-- Discussion of alternative approach considered -->
An alternative approach would have been to overload deposit and withdraw with a LocalDate parameter (e.g. deposit(int amount, LocalDate date)). While functional, this directly couples date handling to business operations. The clock‑based design was chosen for better separation of concerns and testability.


## Architecture Diagram

The diagram shows the core structure of the Banking Service.
Account implements the AccountService interface and manages a collection of Transaction objects.

Date management is delegated to a Clock abstraction, with SystemClock for production usage and StubClock for deterministic testing.

![Banking Service - Class Diagram](docs/class-diagram.png)


<!-- ============================================ -->
<!-- EXECUTION INSTRUCTIONS SECTION -->
<!-- ============================================ -->

## How to Run

<!-- Step 1: Compilation instruction -->
Compile the project:

<!-- Command to compile all Java source files into the 'out' directory -->
```bash
javac -d out src/*.java
```

<!-- Step 2: Execution instruction -->
Run the program:

<!-- Command to execute the Main class with proper classpath -->
```bash
java -cp out Main
```

<!-- ============================================ -->
<!-- ADDITIONAL NOTES SECTION -->
<!-- ============================================ -->

## Notes

<!-- Final statement about project goals and design principles -->
The implementation focuses on correctness, simplicity, and compliance with the provided specifications.