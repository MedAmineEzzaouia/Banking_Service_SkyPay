import java.time.LocalDate;

public class StubClock implements Clock {
    private LocalDate currentDate;

    public void setDate(LocalDate date) {
        this.currentDate = date;
    }

    @Override
    public LocalDate today() {
        return currentDate;
    }
}