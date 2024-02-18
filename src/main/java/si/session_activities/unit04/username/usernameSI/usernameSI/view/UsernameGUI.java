package si.session_activities.unit04.username.usernameSI.usernameSI.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class UsernameGUI extends Application {
    TextField textfield = new TextField();
    Label usernameDisplay = makeLabel("Default");
   
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       
        BorderPane bp = new BorderPane();
        bp.setTop(textfield);
        Button clearButton = new Button("Clear");
      

        Button submit = new Button("Generate a Username");
        
        bp.setRight(submit);
        bp.setCenter(clearButton);
        bp.setBottom(usernameDisplay);
        
        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    private Label makeLabel(String msg){
        Label label = new Label(msg);
        label.setMaxWidth(Integer.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
        CornerRadii.EMPTY, BorderStroke.THIN)));
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
