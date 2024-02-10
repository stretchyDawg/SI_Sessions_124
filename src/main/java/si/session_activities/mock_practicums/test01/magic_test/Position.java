package si.session_activities.mock_practicums.test01.magic_test;

public enum Position {
    BEATER("Beater"),
    CHASER("Chaser"),
    KEEPER("Keeper"),
    SEEKER("Seeker");

    private String positionString;

    private Position(String positionString){
        this.positionString = positionString;
    }

    public String getPositionString(){
        return this.positionString;
    }
}
