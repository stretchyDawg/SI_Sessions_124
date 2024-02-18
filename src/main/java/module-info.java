module si {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;

    opens si to javafx.fxml;
    exports si;
    exports si.session_activities.unit04;
    exports si.session_activities.unit04.username.username.username.view;
    exports si.session_activities.unit04.observer_pattern_activity.song_queue.view;
    exports si.review.javafx_review;
    exports si.review.javafx_review.containers;
    exports si.review.javafx_review.user_input;
    exports si.review.javafx_review.images;
}
