package si.session_activities.mock_practicums.test02.set1.fleebs;

/**
 * A class representing a Fleeb from the planet of Flubbotron.
 */
public class Fleeb implements Comparable<Fleeb> {
    /**
     * The Fleeb's eye color.
     */
    private final EyeColor eyeColor;

    /**
     * The Fleeb's birth month.
     */
    private final Month birthMonth;

    /**
     * The Fleeb's birth day.
     */
    private final int birthDay;

    /**
     * Creates a new Fleeb with the specified attributes.
     * 
     * @param eyeColor The new Fleeb's eye color.
     * @param birthMonth The new Fleeb's birth month.
     * @param birthDay The new Fleeb's birth day.
     */
    public Fleeb(EyeColor eyeColor, Month birthMonth, int birthDay) {
        this.eyeColor = eyeColor;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    public Month getMonth(){
        return this.birthMonth;
    }
    public int getDay(){
        return this.birthDay;
    }
    
    @Override
    public String toString() {
        return "A " + eyeColor + "-eyed Fleeb that was born on " 
            + birthDay + " " + birthMonth; 
    }

    @Override
    public int compareTo(Fleeb other) {
        if(this.eyeColor.getIntensity() == other.eyeColor.getIntensity()){
            return 0;
        }
        else if(this.eyeColor.getIntensity() < other.eyeColor.getIntensity()){
            return 1;
        }
        return -1;
    }

    public static void main(String[] args){
        Fleeb fleeb1 = new Fleeb(EyeColor.CHARTREUSE, Month.BRAUGUST, 12);
        System.out.println(fleeb1);
    }
}
