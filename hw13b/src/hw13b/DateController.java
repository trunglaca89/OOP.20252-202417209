package hw13b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;

public class DateController {
    private DateModel model;
    private DateView view;

    public DateController(DateModel model, DateView view) {
        this.model = model;
        this.view = view;

        // Show the current date when the application starts
        this.view.setDateLabel(model.getCurrentDateString());

        // Register listeners for all operation buttons
        this.view.addSubDaysListener(new ActionHandler(-1, true));
        this.view.addAddDaysListener(new ActionHandler(1, true));
        this.view.addSubMonthsListener(new ActionHandler(-1, false));
        this.view.addAddMonthsListener(new ActionHandler(1, false));
    }

    // Inner class that handles all date operation buttons
    private class ActionHandler implements ActionListener {
        private int multiplier; // 1 means after, -1 means before
        private boolean isDays; // true means days, false means months

        public ActionHandler(int multiplier, boolean isDays) {
            this.multiplier = multiplier;
            this.isDays = isDays;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String input = view.getInputX();
                
                // Validate empty input
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Please enter a value for x.");
                }

                long x = Long.parseLong(input);

                // Validate negative input
                if (x < 0) {
                    throw new IllegalArgumentException("x must not be negative.");
                }
                // Limit very large input values
                if (x > 1000000) {
                    throw new IllegalArgumentException("x is too large. The maximum value is 1,000,000.");
                }

                long adjustedValue = x * multiplier;

                // Ask the Model to update the date
                if (isDays) {
                    model.adjustDays(adjustedValue);
                } else {
                    model.adjustMonths(adjustedValue);
                }

                // Refresh the View after the date changes
                view.setDateLabel(model.getCurrentDateString());

            } catch (NumberFormatException ex) {
                // Handle letters or special characters
                view.showError("Invalid input. Please enter an integer.");
            } catch (IllegalArgumentException ex) {
                view.showError(ex.getMessage());
            } catch (DateTimeException ex) {
                view.showError("The calculated date is outside the supported system range.");
            }
        }
    }
}
