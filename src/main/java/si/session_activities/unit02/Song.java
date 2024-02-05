package si.session_activities.unit02;

public class Song {
    private String title;
    private String author;
    private int runtime;
    private SongType songType;

    // Constructor
    public Song(String title, String author, int runtime, SongType songType){
        this.title = title;
        this.author = author; 
        this.runtime = runtime;
        this.songType = songType;
    }

    // Getters & Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRuntime() {
        return runtime;
    }
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    // Special/Override Methods
    @Override
    public String toString(){
        String songString =  "Song: " + this.title + "\n   Author: " + this.author + "\n   Runtime: " + this.runtime;
        return songString + "\n   Type: " + this.songType + " Song";
    }

    @Override 
    public boolean equals(Object obj){
        if(obj instanceof Song){
            Song other = (Song)obj; // Casting
            return (title.equals(other.getTitle()) && author.equals(other.getAuthor()) && runtime == other.getRuntime()); // Note the difference between .equals() and ==
        }
        return false; // ALways return false when it is not of the same type.
    }
}
