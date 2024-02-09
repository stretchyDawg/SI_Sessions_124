package si.session_activities.unit04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BasicLabel extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label basicLabel = new Label("Basic label! :)");

        Scene scene = new Scene(basicLabel);
        primaryStage.setTitle("Basic Label");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
