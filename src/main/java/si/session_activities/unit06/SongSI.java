package si.session_activities.unit06;

// The finished version.

public class SongSI implements Comparable<SongSI>{
    private String title;
    private String author;
    private int runtime;

    // Constructor
    public SongSI(String title, String author, int runtime){
        this.title = title;
        this.author = author; 
        this.runtime = runtime;
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
        return songString;
    }

    @Override 
    public boolean equals(Object obj){
        if(obj instanceof SongSI){
            SongSI other = (SongSI)obj; 
            return (title.equals(other.getTitle()) && author.equals(other.getAuthor()) && runtime == other.getRuntime()); 
        }
        return false;
    }

    @Override
    public int compareTo(SongSI other) {
        if(this.getTitle().compareTo(other.getTitle()) == -1){
            return -1;
        } 
        else if(this.getTitle().compareTo(other.getTitle()) == 1){
            return 1;
        }
        else{
            if(this.getAuthor().compareTo(other.getAuthor()) == -1){
                return -1;
            }
            else if(this.getAuthor().compareTo(other.getAuthor()) == 1){
                return 1;
            }
            else{
                return 0;
            }
        }   
    }
}
