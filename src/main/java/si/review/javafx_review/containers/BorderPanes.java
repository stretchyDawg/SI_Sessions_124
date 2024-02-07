package si.review.javafx_review.containers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import si.review.javafx_review.LabelFactory;

public class BorderPanes extends Application{ 
    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();
        pane.setTop(LabelFactory.makeLabel("Top", Color.YELLOW));
        pane.setBottom(LabelFactory.makeLabel("Bottom", Color.PINK));
        pane.setLeft(LabelFactory.makeLabel("Left", Color.GREEN));
        pane.setRight(LabelFactory.makeLabel("Right", Color.LIGHTBLUE));
        pane.setCenter(LabelFactory.makeLabel("Center", Color.CORAL));
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Boxes Activity");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
