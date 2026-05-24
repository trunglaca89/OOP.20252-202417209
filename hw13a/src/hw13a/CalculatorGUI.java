package hw13a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private final JTextField display = new JTextField("0");
    private final CalculatorLogic logic = new CalculatorLogic();

    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;
    private boolean hasError = false;

    public CalculatorGUI() {
        setTitle("Calculator");
        setSize(280, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 28));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(5, 4, 6, 6));
        String[] buttons = {
                "C", "<-", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                ".", "0", "", "="
        };

        for (String text : buttons) {
            if (text.isEmpty()) {
                panel.add(new JLabel());
            } else {
                JButton button = new JButton(text);
                button.setFont(new Font("Arial", Font.BOLD, 18));
                button.addActionListener(this);
                panel.add(button);
            }
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]") || command.equals(".")) {
            inputNumber(command);
        } else if (command.equals("C")) {
            clear();
        } else if (command.equals("<-")) {
            delete();
        } else if (command.equals("=")) {
            calculateResult();
        } else {
            inputOperator(command);
        }
    }

    private void inputNumber(String text) {
        if (hasError) {
            clear();
        }

        if (startNewNumber) {
            display.setText(text.equals(".") ? "0." : text);
            startNewNumber = false;
            return;
        }

        if (text.equals(".") && display.getText().contains(".")) {
            return;
        }

        display.setText(display.getText().equals("0") && !text.equals(".")
                ? text
                : display.getText() + text);
    }

    private void inputOperator(String nextOperator) {
        if (hasError) {
            clear();
        }

        if (!operator.isEmpty() && !startNewNumber) {
            if (!calculate()) {
                return;
            }
        } else if (operator.isEmpty()) {
            firstNumber = Double.parseDouble(display.getText());
        }

        operator = nextOperator;
        startNewNumber = true;
        display.setText(format(firstNumber) + " " + operator);
    }

    private void calculateResult() {
        if (operator.isEmpty()) {
            return;
        }
        if (startNewNumber) {
            showError("Error: missing number");
            return;
        }

        if (calculate()) {
            operator = "";
            startNewNumber = true;
        }
    }

    private boolean calculate() {
        try {
            double secondNumber = Double.parseDouble(display.getText());
            firstNumber = logic.evaluateExpression(firstNumber, secondNumber, operator);
            display.setText(format(firstNumber));
            return true;
        } catch (ArithmeticException ex) {
            showError("Error: divide by 0");
        } catch (NumberFormatException ex) {
            showError("Error: invalid input");
        }
        return false;
    }

    private void delete() {
        if (hasError) {
            clear();
            return;
        }
        if (startNewNumber) {
            return;
        }

        String text = display.getText();
        display.setText(text.length() == 1 ? "0" : text.substring(0, text.length() - 1));
        startNewNumber = display.getText().equals("0");
    }

    private void clear() {
        firstNumber = 0;
        operator = "";
        startNewNumber = true;
        hasError = false;
        display.setText("0");
    }

    private void showError(String message) {
        operator = "";
        hasError = true;
        startNewNumber = true;
        display.setText(message);
    }

    private String format(double value) {
        return value == (long) value ? String.valueOf((long) value) : String.valueOf(value);
    }
}
