package si.session_activities.mock_practicums.test03.set2.two;

public class ProductMain {
    public static class TenOff implements Discount{
        @Override
        public double applyDiscount(double price) {
            return price * .9;
        }
    }
    
    public static void main(String[] args) { 
        // Class
        Product a = new Product("a", 50);
        a.setDiscount(new HalfOff());
        System.out.println(a.getPriceAfterDiscount());

        // Inner Class
        Product b = new Product("a", 50);
        b.setDiscount(new TenOff());

        // Anon Class
        Product c = new Product("c", 50);
        c.setDiscount(new Discount(){
            @Override
            public double applyDiscount(double price) {
                return price * .95;
            }
        });

        // Lambda
        Product d = new Product("d", 50);
        Discount twentyOff = f -> f*.8;
        d.setDiscount(twentyOff);

        // Even crazier lambda
        Product e = new Product("d", 50);
        e.setDiscount(f -> f * .01);
    }
}
