package si.session_activities.unit02;

public enum SongType {
    SINGLE("Single"),
    ALBUM("Album"),
    EP("EP"), 
    LP("LP");

    private String typeString;

    private SongType(String typeString){
        this.typeString = typeString;
    }

    @Override
    public String toString(){
        return this.typeString;
    }
}
