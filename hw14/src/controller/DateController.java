package controller;

import javafx.beans.binding.Bindings;
import model.DateModel;
import view.DateView;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateController {
    private final DateModel model;
    private final DateView view;

    public DateController(DateModel model, DateView view) {
        this.model = model;
        this.view = view;
        initBindings();
        initListeners();
    }

    private void initBindings() {
        // The displayed base date depends on both the selected date and the selected format
        view.getCurrentDisplayDateLabel().textProperty().bind(
            Bindings.createStringBinding(() -> {
                LocalDate date = model.baseDateProperty().get();
                String formatPattern = model.dateFormatProperty().get();
                if (date != null && formatPattern != null) {
                    return date.format(DateTimeFormatter.ofPattern(formatPattern));
                }
                return "";
            }, model.baseDateProperty(), model.dateFormatProperty())
        );

        view.getDatePicker().valueProperty().bindBidirectional(model.baseDateProperty());
        view.getErrorLabel().textProperty().bind(model.errorMessageProperty());

        // The result label is refreshed automatically when the result date or format changes
        view.getResultLabel().textProperty().bind(
            Bindings.createStringBinding(() -> {
                LocalDate result = model.resultDateProperty().get();
                String formatPattern = model.dateFormatProperty().get();
                if (result == null || formatPattern == null) {
                    return "---";
                }
                return result.format(DateTimeFormatter.ofPattern(formatPattern));
            }, model.resultDateProperty(), model.dateFormatProperty())
        );
        
        view.getApplyButton().disableProperty().bind(model.isInputValidProperty().not());
    }

    private void initListeners() {
        view.getFormatComboBox().valueProperty().addListener((obs, oldVal, newVal) -> {
            model.setDateFormat(toPattern(newVal));
        });

        view.getAmountField().textProperty().addListener((obs, oldText, newText) -> validateInput());
        view.getDatePicker().valueProperty().addListener((obs, oldDate, newDate) -> validateInput());

        view.getApplyButton().setOnAction(e -> calculateDate());
        
        validateInput();
    }

    private String toPattern(String formatLabel) {
        if (formatLabel != null && formatLabel.contains("US")) {
            return "MM/dd/yyyy";
        }
        if (formatLabel != null && formatLabel.contains("European")) {
            return "dd.MM.yyyy";
        }
        return "dd/MM/yyyy";
    }

    private void validateInput() {
        if (model.getBaseDate() == null) {
            model.setErrorMessage("Base date cannot be empty.");
            model.setInputValid(false);
            return;
        }

        String text = view.getAmountField().getText();
        if (text == null || text.trim().isEmpty()) {
            model.setErrorMessage("Amount cannot be empty.");
            model.setInputValid(false);
            return;
        }
        try {
            int amount = Integer.parseInt(text.trim());
            if (amount < 0) {
                model.setErrorMessage("Amount must be zero or a positive integer.");
                model.setInputValid(false);
                return;
            }
            model.setErrorMessage("");
            model.setInputValid(true);
        } catch (NumberFormatException ex) {
            model.setErrorMessage("Invalid input. Please enter a whole number.");
            model.setInputValid(false);
        }
    }

    private void calculateDate() {
        validateInput();
        if (!model.isInputValid()) {
            return;
        }

        LocalDate base = model.getBaseDate();
        int amount = Integer.parseInt(view.getAmountField().getText().trim());
        String direction = view.getDirectionComboBox().getValue();
        String unit = view.getUnitComboBox().getValue();

        if ("Before".equals(direction)) {
            amount = -amount;
        }

        try {
            LocalDate result = base;
            switch (unit) {
                case "Days":
                    result = base.plusDays(amount);
                    break;
                case "Months":
                    result = base.plusMonths(amount);
                    break;
                case "Years":
                    result = base.plusYears(amount);
                    break;
                default:
                    model.setErrorMessage("Unknown time unit.");
                    model.setInputValid(false);
                    return;
            }
            model.setResultDate(result);
            model.setErrorMessage("");
        } catch (DateTimeException ex) {
            model.setErrorMessage("The calculated date is out of range.");
        }
    }
}
