package si.session_activities.unit04.observer_pattern_activity.spotify.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import si.session_activities.unit04.observer_pattern_activity.spotify.model.SpotifyQueue;

public class SpotifyGUI extends Application{
    SpotifyQueue model = new SpotifyQueue();
    int songsLeft = 0;
    Label songDisplay = makeLabel("Default");
    Label songCount = makeLabel("Songs left: " + songsLeft);

    private Label makeLabel(String msg){
        Label label = new Label(msg);
        label.setMaxWidth(Integer.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));
        return label;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        model.enqueueFile("C:\\Users\\Christian Morgado\\Repos\\SI\\SI_Sessions_124\\src\\main\\java\\si\\session_activities\\unit04\\observer_pattern_activity\\spotify\\model\\songs2.txt");
        String songTitle = model.dequeueSong();
        songDisplay.setText(songTitle);
        songCount.setText("Songs left: " + model.getSongsLeft());
        
        VBox vBox = new VBox();
        Button play = new Button("Play next song");
        play.setMaxWidth(Integer.MAX_VALUE);
        play.setOnAction(new Play(this, model));          // <-- THIS is where you call the controller.
        // Play.java is the 'controller'. You 'initialize' or 'setup' the controller when you pass it in the setOnAction method.
        vBox.getChildren().addAll(songDisplay, songCount, play);
        
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
