module si {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;

    opens si to javafx.fxml;
    exports si;
    exports si.reversi.model;
    exports si.reversi.view;
    exports si.tic_tac_toe.model;
    exports si.tic_tac_toe.view;
}
