package hw13a;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Fallback
        }

        SwingUtilities.invokeLater(() -> {
            CalculatorGUI app = new CalculatorGUI();
            app.setVisible(true);
        });
    }
}