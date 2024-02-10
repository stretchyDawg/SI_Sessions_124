package si.session_activities.mock_practicums.test01.magic_test;

public enum House {
    GRYFFINDOR("Gryffindor", "Bravery"),
    HUFFLEPUFF("Hufflepuff", "Empathy"),
    RAVENCLAW("Ravenclaw", "Intelligence"),
    SLYTHERIN("Slytherin", "Ambition");

    private String houseString;
    private String houseCharacteristic;

    private House(String houseString, String houseCharacteristic){
        this.houseString = houseString;
        this.houseCharacteristic = houseCharacteristic;
    }

    public String getHouseString(){
        return this.houseString;
    }

    public String getHouseCharacteristic(){
        return this.houseCharacteristic;
    }


}
