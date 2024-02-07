package si.review.javafx_review.user_input;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextFields extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox nameTag = new HBox();
        Label nameTagLabelTop = new Label("HELLO MY NAME IS");


        // Scene scene = new Scene();
        // primaryStage.setTitle("Button Activity");
        // primaryStage.setScene(scane);
        // primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
