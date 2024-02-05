package si.review.enum_class;

public enum SongType {
    SINGLE("Single"),
    ALBUM("Album"),
    EP("EP"), 
    LP("LP");

    // Enum classes are 'declared backwards'.

    private String typeString;

    private SongType(String typeString){
        this.typeString = typeString;
    }

    @Override
    public String toString(){
        return this.typeString;
    }
}
