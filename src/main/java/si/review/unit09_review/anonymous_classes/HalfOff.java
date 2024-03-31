package si.review.unit09_review.anonymous_classes;

public class HalfOff implements Discount{
    @Override
    public double applyDiscount(double price) {
        return price * .5;
    }
}
