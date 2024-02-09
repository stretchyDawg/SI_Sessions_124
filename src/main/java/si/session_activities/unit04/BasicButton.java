package si.session_activities.unit04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BasicButton extends Application{    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label numberLabel = new Label("0");
        Button basicButton = new Button("Increment :)");
        
        VBox vBox = new VBox();
        vBox.getChildren().addAll(
            numberLabel,    
            basicButton
        );
        
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Basic Button Activity");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
