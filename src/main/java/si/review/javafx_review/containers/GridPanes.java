package si.review.javafx_review.containers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import si.review.javafx_review.LabelFactory;

public class GridPanes extends Application{
    private static GridPane gridPaneFactory(int rows, int columns){
        GridPane pane = new GridPane();
        for(int col=0; col<5; col++) {
           for(int row=0; row<3; row++) {
                String display = "Column: " + col + "\nRow: " + row;
               Label label = LabelFactory.makeLabel(display, Color.PINK);
               pane.add(label, col, row);
           }
        }

        return pane;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = gridPaneFactory(5, 3);
        
        Scene scene = new Scene(gridPane);
    primaryStage.setTitle("GridPanes Activity");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }   
}
