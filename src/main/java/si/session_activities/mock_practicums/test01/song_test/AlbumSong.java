package si.session_activities.mock_practicums.test01.song_test;

public class AlbumSong extends Song {
    private String albumTitle;

    public AlbumSong(String title, String author, Genre genre, int runtime, String albumTitle) {
        super(title, author, genre, runtime);
        this.albumTitle = albumTitle;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    @Override
    public String toString() {
        return this.getTitle() + " by " + this.getAuthor() + " from " + this.getAlbumTitle() + ": " + this.getRuntime() + " seconds, Genre: " + this.getGenre();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AlbumSong){
            AlbumSong other = (AlbumSong)obj;
            return this.getTitle().equals(other.getTitle()) && this.getAuthor().equals(other.getAuthor()) && this.getRuntime() == other.getRuntime() && this.getAlbumTitle().equals(other.getAlbumTitle());
        }
        return false;
    }
}
