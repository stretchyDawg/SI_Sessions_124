package si.session_activities.mock_practicums.test01.song_test;

public class Song {
    private String title;
    private String author;
    private Genre genre;
    private int runtime;

    public Song(String title, String author, Genre genre, int runtime) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.runtime = runtime;
    }

    // Accessors
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Genre getGenre() {
        return genre;
    }
    public int getRuntime() {
        return runtime;
    }

    // Method to get runtime as a string
    public String getRuntimeAsString() {
        return "Runtime: " + runtime + " seconds";
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Song){
            Song other = (Song)obj;
            return this.title.equals(other.title) && this.author.equals(other.author) && this.runtime == other.runtime;
        }
        return false;
    }
    // String representation
    @Override
    public String toString() {
        return title + " by " + author + ": " + runtime + " seconds, Genre: " + genre;
    }
}
