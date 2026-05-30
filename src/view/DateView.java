package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DateView extends VBox {
    private Label currentDisplayDateLabel;
    private ComboBox<String> formatComboBox;
    private DatePicker datePicker;
    private TextField amountField;
    private ComboBox<String> directionComboBox;
    private ComboBox<String> unitComboBox;
    private Button applyButton;
    private Label resultLabel;
    private Label errorLabel;

    public DateView() {
        setPadding(new Insets(20));
        setSpacing(15);
        setAlignment(Pos.TOP_CENTER);

        // 1. Current Displayed Date Area
        Label titleLabel = new Label("Current Displayed Date:");
        titleLabel.setFont(Font.font("Arial", 14));
        currentDisplayDateLabel = new Label();
        currentDisplayDateLabel.setFont(Font.font("Arial", 20));
        currentDisplayDateLabel.setTextFill(Color.DARKBLUE);

        // 2. Format Selection
        HBox formatBox = new HBox(10, new Label("Format:"));
        formatBox.setAlignment(Pos.CENTER_LEFT);
        formatComboBox = new ComboBox<>();
        formatComboBox.getItems().addAll(
                "Vietnamese (dd/MM/yyyy)", 
                "US (MM/dd/yyyy)", 
                "European (dd.MM.yyyy)"
        );
        formatComboBox.setValue("Vietnamese (dd/MM/yyyy)");
        formatBox.getChildren().add(formatComboBox);

        // 3. Date Selection
        HBox dateBox = new HBox(10, new Label("Base Date:"));
        dateBox.setAlignment(Pos.CENTER_LEFT);
        datePicker = new DatePicker();
        dateBox.getChildren().add(datePicker);

        // 4. Operation Controls
        HBox operationBox = new HBox(10);
        operationBox.setAlignment(Pos.CENTER_LEFT);
        
        amountField = new TextField();
        amountField.setPromptText("Enter amount (e.g. 5)");
        amountField.setPrefWidth(140);
        
        directionComboBox = new ComboBox<>();
        directionComboBox.getItems().addAll("After", "Before");
        directionComboBox.setValue("After");
        
        unitComboBox = new ComboBox<>();
        unitComboBox.getItems().addAll("Days", "Months", "Years");
        unitComboBox.setValue("Days");

        operationBox.getChildren().addAll(amountField, directionComboBox, unitComboBox);

        // 5. Apply Button & Error Label
        applyButton = new Button("Apply Calculation");
        applyButton.setStyle("-fx-font-weight: bold; -fx-base: #4CAF50;");
        
        errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);

        // 6. Result Area
        VBox resultBox = new VBox(5);
        resultBox.setAlignment(Pos.CENTER);
        resultBox.setStyle("-fx-border-color: gray; -fx-border-radius: 5; -fx-padding: 10;");
        Label resTitle = new Label("Result Date:");
        resultLabel = new Label("---");
        resultLabel.setFont(Font.font("Arial", 18));
        resultLabel.setTextFill(Color.DARKGREEN);
        resultBox.getChildren().addAll(resTitle, resultLabel);

        // Add all to root
        getChildren().addAll(
                titleLabel, currentDisplayDateLabel, new Separator(),
                formatBox, dateBox, operationBox, 
                errorLabel, applyButton, new Separator(), resultBox
        );
    }

    // Getters for Controller
    public Label getCurrentDisplayDateLabel() { return currentDisplayDateLabel; }
    public ComboBox<String> getFormatComboBox() { return formatComboBox; }
    public DatePicker getDatePicker() { return datePicker; }
    public TextField getAmountField() { return amountField; }
    public ComboBox<String> getDirectionComboBox() { return directionComboBox; }
    public ComboBox<String> getUnitComboBox() { return unitComboBox; }
    public Button getApplyButton() { return applyButton; }
    public Label getResultLabel() { return resultLabel; }
    public Label getErrorLabel() { return errorLabel; }
}