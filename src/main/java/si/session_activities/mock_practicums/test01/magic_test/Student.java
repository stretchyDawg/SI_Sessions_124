package si.session_activities.mock_practicums.test01.magic_test;

public class Student {
    private String name;
    private House house;
    private int yearLevel;

    public Student(String name, House house){
        this.name = name;
        this.house = house;
        this.yearLevel = 1;
    }

    // Accessors:
    public String getName(){
        return this.name;
    }
    public House getHouse(){
        return this.house;
    }
    public int getYear(){
        return this.yearLevel;
    }

    //Year Method
    public String getYearString(){
        if(this.yearLevel == 11){
            return "11th";
        }
        else if(this.yearLevel == 12){
            return "12th";
        }
        else if(this.yearLevel == 13){
            return "13th";
        }
        else{
            int lastDigit = this.yearLevel % 10;
            if(lastDigit == 1){
                return this.yearLevel + "st";
            }
            else if(lastDigit == 2){
                return this.yearLevel + "nd";
            }
            else if(lastDigit == 3){
                return this.yearLevel + "rd";
            }
            else {
                return this.yearLevel + "th";
            }
        }
    }

    // Mutators:
    public void advanceYear(){
        this.yearLevel++;
        if(this.yearLevel > 7){
            this.yearLevel = 7;
        }
    }

    // Special Functions:
    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student other = (Student)(obj);
            return ((this.house == other.house) && (this.yearLevel == other.yearLevel));
        }
        else{
            return false;
        }
    }

    public String toString(){
        return this.name + ", a " + this.getYearString() + " year student in " + this.house.getHouseString() +" house.";
    }

    
}
