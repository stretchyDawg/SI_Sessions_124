package si.session_activities.mock_practicums.test01.song_test;

public enum Genre {
    POP("Pop"),
    RAP("Rap"),
    HIPHOP("Hip-Hop"),
    ROCKNROLL("Rock and Roll"),
    JAZZ("Jazz");

    private final String typeString;

    private Genre(String typeString) {
        this.typeString = typeString;
    }

    @Override
    public String toString(){
        return this.typeString;
    }
}



