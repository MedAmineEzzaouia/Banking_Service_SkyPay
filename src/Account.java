import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account implements AccountService {
    private final List<Transaction> transactions = new ArrayList<>();
    private final Clock clock;
    private int balance = 0;

    public Account(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
        transactions.add(new Transaction(clock.today(), amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (amount > balance) throw new IllegalStateException("Insufficient funds");
        balance -= amount;
        transactions.add(new Transaction(clock.today(), -amount, balance));
    }

    @Override
    public void printStatement() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Date || Amount || Balance");
        List<Transaction> copy = new ArrayList<>(transactions);
        Collections.reverse(copy);
        for (Transaction t : copy) {
            System.out.println(t.getDate().format(formatter) + " || " + t.getAmount() + " || " + t.getBalanceAfter());
        }
    }
} 