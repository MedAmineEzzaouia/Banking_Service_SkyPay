import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        StubClock clock = new StubClock();
        Account account = new Account(clock);
        clock.setDate(LocalDate.of(2012, 1, 10));
        account.deposit(1000);
        clock.setDate(LocalDate.of(2012, 1, 13));
        account.deposit(2000);
        clock.setDate(LocalDate.of(2012, 1, 14));
        account.withdraw(500);
        account.printStatement();
    }
}

