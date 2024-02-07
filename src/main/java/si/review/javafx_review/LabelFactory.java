package unit04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelFactory extends Application{

    private static Label makeLabel(String text, Color textColor, Color backgroundColor) {
        Label label = new Label(text);
        label.setFont(new Font("Arial", 24));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPadding(new Insets(40));
        label.setTextFill(textColor);
        label.setBackground(new Background(new BackgroundFill(backgroundColor, new CornerRadii(100), new Insets(30))));    
        label.setAlignment(Pos.CENTER);
        
        return label;   
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label1 = makeLabel("Top", Color.GREEN, Color.AQUAMARINE);
        Label label2 = makeLabel("Middle", Color.ORANGERED, Color.ORANGE);
        Label label3 = makeLabel("Bottom", Color.PALETURQUOISE, Color.PURPLE);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(label1, label2, label3);

        Scene scene = new Scene(vBox);

        primaryStage.setTitle("Factory Activity");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
