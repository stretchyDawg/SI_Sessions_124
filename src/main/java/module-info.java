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
    exports si.session_activities.unit04;
    exports si.review.javafx_review;
    exports si.review.javafx_review.containers;
    exports si.review.javafx_review.user_input;
    exports si.review.javafx_review.images;
}
