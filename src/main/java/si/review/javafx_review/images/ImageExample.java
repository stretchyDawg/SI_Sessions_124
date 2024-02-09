package si.review.javafx_review.images;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageExample extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image("file:media/images/sunflowers.jpg");
        ImageView view = new ImageView(image);
        HBox box = new HBox();
        box.getChildren().add(view);

        Scene scene = new Scene(box);
        primaryStage.setTitle("Image Activity");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        
    }
}
