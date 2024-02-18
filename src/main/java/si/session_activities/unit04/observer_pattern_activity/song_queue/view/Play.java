package si.session_activities.unit04.observer_pattern_activity.song_queue.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import si.session_activities.unit04.observer_pattern_activity.song_queue.model.SpotifyQueue;

public class Play implements EventHandler<ActionEvent>{

    private SpotifyGUI gui;
    private SpotifyQueue model;

    public Play(SpotifyGUI gui, @SuppressWarnings("exports") SpotifyQueue model){
        this.gui = gui;
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        if(model.getSongsLeft().equals("0")){
            gui.songDisplay.setText("Queue finished!");
            gui.songDisplay.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            gui.songCount.setText("Yippee!!!");
            gui.songCount.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else{
            String songTitle = model.dequeueSong();
            gui.songDisplay.setText(songTitle);
            gui.songCount.setText("Songs left: " + model.getSongsLeft());
        }
    }
    
}
