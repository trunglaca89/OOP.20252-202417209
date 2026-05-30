package hw13b;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        // Apply the native look and feel of the operating system
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Ignore look and feel errors
        }

        SwingUtilities.invokeLater(() -> {
            // Assemble the MVC components
            DateModel model = new DateModel();
            DateView view = new DateView();
            DateController controller = new DateController(model, view);

            // Display the GUI
            view.setVisible(true);
        });
    }
}
