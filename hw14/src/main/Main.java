package main;

import controller.DateController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DateModel;
import view.DateView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create the model
        DateModel model = new DateModel();
        
        // Create the view
        DateView view = new DateView();
        
        // Connect the model and view through the controller
        new DateController(model, view);

        // Show the JavaFX scene
        Scene scene = new Scene(view, 500, 400);
        primaryStage.setTitle("Date Display GUI 2 - MVC JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}
