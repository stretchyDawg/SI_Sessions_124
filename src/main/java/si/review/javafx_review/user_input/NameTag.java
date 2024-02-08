package si.review.javafx_review.user_input;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NameTag extends Application{
    private static final String YOUR_NAME_DEFAULT = "Your Name";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hello = new Label("HELLO MY NAME IS");
        hello.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        hello.setAlignment(Pos.TOP_CENTER);
        hello.setFont(new Font("Impact",24));
        hello.setTextFill(Color.BLUE);
        hello.setPadding(new Insets(10));

        Label yourName = new Label(YOUR_NAME_DEFAULT);
        yourName.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        yourName.setAlignment(Pos.CENTER);
        yourName.setFont(new Font("Comic Sans MS",48));
        yourName.setTextFill(Color.RED);
        yourName.setPadding(new Insets(15));

        VBox tag = new VBox(hello,yourName);
        tag.setBorder(new Border(new BorderStroke(Color.BLUE,
                BorderStrokeStyle.SOLID,
                new CornerRadii(5),
                BorderStroke.THICK)));

        TextField nameField = new TextField();
        nameField.setAlignment(Pos.CENTER);
        nameField.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        nameField.setPromptText("Enter Your Name");

        Button update = new Button("Update Name Tag");
        update.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        update.setOnAction(new Updater(yourName,nameField));

        Button clear = new Button("Clear");
        clear.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        clear.setOnAction(new Clearer(YOUR_NAME_DEFAULT,yourName,nameField));
        
        // VBox box = new VBox(tag,nameField,update,clear);
        // Scene scene = new Scene(box);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
