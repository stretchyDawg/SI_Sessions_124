package si.session_activities.unit04.username.username.username.view;

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
import si.session_activities.unit04.username.username.username.model.USObserver;
import si.session_activities.unit04.username.username.username.model.Username;

public class UsernameGUI extends Application implements USObserver {
    TextField textfield = new TextField();
    Label usernameDisplay = makeLabel("Default");
    Username model = new Username();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        model.setObserver(this);
        BorderPane bp = new BorderPane();
        bp.setTop(textfield);
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(new Cleaner(this));

        Button submit = new Button("Generate a Username");
        submit.setOnAction(new Generator(this, model));
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

    @Override
    public void update(@SuppressWarnings("exports") Username model) {
        model.makeUsername(textfield.getText());
        String userName = model.getUsername();
        usernameDisplay.setText(userName);
    }
}
