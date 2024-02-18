package si.session_activities.unit04.observer_pattern_activity.song_queue.view;

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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import si.session_activities.unit04.username.username.username.model.Username;

public class SpotifyGUI extends Application{
    Username model = new Username();

    private Label makeLabel(String msg){
        Label label = new Label(msg);
        label.setMaxWidth(Integer.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
        CornerRadii.EMPTY, BorderStroke.THIN)));
        return label;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        int songsLeft = 0;
        // model.setObserver(this);
        VBox vBox = new VBox();
        Label songDisplay = makeLabel("Default");
        Label songCount = makeLabel("Song count: " + songsLeft);
        Button play = new Button("Play next song");
        // play.setOnAction(new Generator(this, model));
        vBox.getChildren().addAll(songDisplay, songCount, play);
        
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
