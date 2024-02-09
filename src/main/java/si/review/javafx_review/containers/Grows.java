package si.review.javafx_review.containers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Grows extends Application{
    private static final String IMG_DIR = "file:media/images/smb/";

    public Label makeLabel(String text,String imagePath) {
        ImageView imageView = new ImageView(imagePath);

        Label label = new Label(text, imageView);
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        label.setContentDisplay(ContentDisplay.TOP);
        
        VBox.setVgrow(label, Priority.ALWAYS); // Static method, try commenting this out to see what it does.

        return label;
    }

    public Button makeButton(String text,String imagePath) {
        ImageView imageView = new ImageView(imagePath);

        Button button = new Button(text, imageView);
        button.setMaxSize(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        button.setContentDisplay(ContentDisplay.BOTTOM);
        HBox.setHgrow(button,Priority.ALWAYS); // Static method, try commenting this out to see what it does.

        return button;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox vbox = new VBox();
        vbox.getChildren().addAll(
            makeLabel("Jump!",IMG_DIR + "jump.png"),
            makeLabel("Jump!",IMG_DIR + "jump.png"),
            makeLabel("Jump!",IMG_DIR + "jump.png")
        );

        HBox hbox = new HBox();
        hbox.getChildren().addAll(
            vbox,
            makeButton("Goomba!",IMG_DIR + "goomba.png"),
            makeButton("Goomba!",IMG_DIR + "goomba.png"),
            makeButton("Goomba!",IMG_DIR + "goomba.png")
        );

        stage.setTitle("Grow Examples");
        stage.setScene(new Scene(hbox));
        stage.show();        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
