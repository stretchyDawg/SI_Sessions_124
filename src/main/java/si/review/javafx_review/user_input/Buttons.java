package si.review.javafx_review.user_input;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Buttons extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField nameField = new TextField();
        nameField.setAlignment(Pos.CENTER);
        nameField.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nameField.setPromptText("Text Field 1");

        Button button1 = new Button("Button 1");
        button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button button2 = new Button("Button 2");
        button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        VBox box = new VBox(nameField, button1, button2);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Your Name");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
