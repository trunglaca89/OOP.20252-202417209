package hw13b;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateModel {
    private LocalDate currentDate;
    private final DateTimeFormatter formatter;

    public DateModel() {
        // Automatically use the current date when the application starts
        this.currentDate = LocalDate.now();
        // Vietnamese-style date format
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public String getCurrentDateString() {
        return currentDate.format(formatter);
    }

    // LocalDate handles leap years and different month lengths correctly
    public void adjustDays(long days) throws DateTimeException {
        currentDate = currentDate.plusDays(days);
    }

    public void adjustMonths(long months) throws DateTimeException {
        currentDate = currentDate.plusMonths(months);
    }
}
