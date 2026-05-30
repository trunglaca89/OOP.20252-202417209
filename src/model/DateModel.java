package model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class DateModel {
    // Selected base date
    private final ObjectProperty<LocalDate> baseDate = new SimpleObjectProperty<>(LocalDate.now());
    // Currently selected date format pattern
    private final StringProperty dateFormat = new SimpleStringProperty("dd/MM/yyyy");
    // Calculated date result
    private final ObjectProperty<LocalDate> resultDate = new SimpleObjectProperty<>();
    // Validation message shown in the view.
    private final StringProperty errorMessage = new SimpleStringProperty("");
    // True only when all required input is valid
    private final BooleanProperty isInputValid = new SimpleBooleanProperty(false);

    public ObjectProperty<LocalDate> baseDateProperty() { return baseDate; }
    public StringProperty dateFormatProperty() { return dateFormat; }
    public ObjectProperty<LocalDate> resultDateProperty() { return resultDate; }
    public StringProperty errorMessageProperty() { return errorMessage; }
    public BooleanProperty isInputValidProperty() { return isInputValid; }

    public LocalDate getBaseDate() { return baseDate.get(); }
    public void setBaseDate(LocalDate date) { this.baseDate.set(date); }

    public void setDateFormat(String format) { this.dateFormat.set(format); }
    public String getDateFormat() { return dateFormat.get(); }

    public LocalDate getResultDate() { return resultDate.get(); }
    public void setResultDate(LocalDate date) { this.resultDate.set(date); }
    
    public String getErrorMessage() { return errorMessage.get(); }
    public void setErrorMessage(String msg) { this.errorMessage.set(msg); }

    public boolean isInputValid() { return isInputValid.get(); }
    public void setInputValid(boolean valid) { this.isInputValid.set(valid); }
}
