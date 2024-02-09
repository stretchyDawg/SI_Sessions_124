package si.review.javafx_review.containers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPanes extends Application{  
    private static final String IMG_PATH = "file:media/images/emojis/";
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stackPane = new StackPane();
        
        stackPane.getChildren().addAll(
            new ImageView(IMG_PATH + "headred.png"),
            new ImageView(IMG_PATH + "eyesblue.png"),
            new ImageView(IMG_PATH + "mouthbasic.png"),
            new ImageView(IMG_PATH + "nosegreen.png"),
            new ImageView(IMG_PATH + "browsbasic.png")
        );

        Scene scene = new Scene(stackPane);
        primaryStage.setTitle("StackPanes Activity");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }   
}
