import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account implements AccountService {
    private final List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    @Override
    public void deposit(int amount) {
        deposit(amount, LocalDate.now());
    }

    // overload for explicit date – no @Override here
    public void deposit(int amount, LocalDate date) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
        transactions.add(new Transaction(date, amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        withdraw(amount, LocalDate.now());
    }

    // overload for explicit date – no @Override here
    public void withdraw(int amount, LocalDate date) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (amount > balance) throw new IllegalStateException("Insufficient funds");
        balance -= amount;
        transactions.add(new Transaction(date, -amount, balance));
    }

    @Override
    public void printStatement() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Date || Amount || Balance");
        // iterate in reverse order to print most recent first
        List<Transaction> copy = new ArrayList<>(transactions);
        Collections.reverse(copy);
        for (Transaction t : copy) {
            String date = t.getDate().format(formatter);
            System.out.println(date + " || " + t.getAmount() + " || " + t.getBalanceAfter());
        }
    }
}
