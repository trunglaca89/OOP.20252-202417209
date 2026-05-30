package hw13b;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DateView extends JFrame {
    private JLabel lblDate;
    private JTextField txtInputX;
    private JButton btnSubDays, btnAddDays, btnSubMonths, btnAddMonths;

    public DateView() {
        setTitle("Date Display GUI");
        setSize(420, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(245, 245, 250));

        // Date display area
        lblDate = new JLabel("Date ...", SwingConstants.CENTER);
        lblDate.setFont(new Font("Arial", Font.BOLD, 26));
        lblDate.setForeground(new Color(41, 128, 185));
        lblDate.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(lblDate, BorderLayout.NORTH);

        // Control area
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1, 5, 10));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        controlPanel.setBackground(new Color(245, 245, 250));

        // Input area
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(new Color(245, 245, 250));
        inputPanel.add(new JLabel("Enter x (days/months):"));
        txtInputX = new JTextField(10);
        txtInputX.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(txtInputX);
        controlPanel.add(inputPanel);

        // Day operation buttons
        JPanel daysPanel = new JPanel(new FlowLayout());
        daysPanel.setBackground(new Color(245, 245, 250));
        btnSubDays = new JButton("x Days Before");
        btnAddDays = new JButton("x Days After");
        daysPanel.add(btnSubDays);
        daysPanel.add(btnAddDays);
        controlPanel.add(daysPanel);

        // Month operation buttons
        JPanel monthsPanel = new JPanel(new FlowLayout());
        monthsPanel.setBackground(new Color(245, 245, 250));
        btnSubMonths = new JButton("x Months Before");
        btnAddMonths = new JButton("x Months After");
        monthsPanel.add(btnSubMonths);
        monthsPanel.add(btnAddMonths);
        controlPanel.add(monthsPanel);

        add(controlPanel, BorderLayout.CENTER);
    }

    // Methods used by the Controller to interact with the View
    public void setDateLabel(String dateText) {
        lblDate.setText("Date " + dateText);
    }

    public String getInputX() {
        return txtInputX.getText().trim();
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    // Methods used by the Controller to register listeners
    public void addSubDaysListener(ActionListener listenForBtn) { btnSubDays.addActionListener(listenForBtn); }
    public void addAddDaysListener(ActionListener listenForBtn) { btnAddDays.addActionListener(listenForBtn); }
    public void addSubMonthsListener(ActionListener listenForBtn) { btnSubMonths.addActionListener(listenForBtn); }
    public void addAddMonthsListener(ActionListener listenForBtn) { btnAddMonths.addActionListener(listenForBtn); }
}
