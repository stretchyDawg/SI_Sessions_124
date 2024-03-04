package si.session_activities.mock_practicums.test02.set2.three;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CalculatorGUI extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        // HBox
        HBox buttons = new HBox();
        Button add = makeButton("+");
        Button minus = makeButton("-");
        buttons.getChildren().addAll(add, minus);
        HBox.setHgrow(add, Priority.ALWAYS); // not required
        HBox.setHgrow(minus, Priority.ALWAYS); // not required

        // VBox
        VBox vBox = new VBox();
        Label numDisplay = makeLabel("0");
        vBox.getChildren().addAll(numDisplay, buttons);
        
        // Setting Button's Action
        add.setOnAction(new Add(numDisplay));
        minus.setOnAction(new Minus(numDisplay));

        // Scene
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Calc GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }





    private Button makeButton(String msg){
        Button button = new Button(msg);
        button.setMaxWidth(Integer.MAX_VALUE);
        button.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
        CornerRadii.EMPTY, BorderStroke.THIN)));
        return button;
    }
    
    private Label makeLabel(String msg){
        Label label = new Label(msg);
        label.setMaxWidth(Integer.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font(50));
        return label;
    }
    
}
