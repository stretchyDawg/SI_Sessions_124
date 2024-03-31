package si.session_activities.mock_practicums.test03.set2.two;

public class HalfOff implements Discount{
    @Override
    public double applyDiscount(double price) {
        return price * .5;
    }
}
