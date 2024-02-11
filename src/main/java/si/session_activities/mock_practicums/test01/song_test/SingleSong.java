package si.session_activities.mock_practicums.test01.song_test;

public class SingleSong extends Song {
    public SingleSong(String title, String author, Genre genre, int runtime) {
        super(title, author, genre, runtime);
    }

    @Override
    public String toString() {
        return super.toString() + " (Single)";
    }
}