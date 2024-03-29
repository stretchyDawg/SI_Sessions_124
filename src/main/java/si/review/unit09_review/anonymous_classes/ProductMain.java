package si.review.unit09_review.anonymous_classes;

public class ProductMain {
    public static void main(String[] args) { 
        Product plushie = new Product("Plushie", 30);
        Product laptop = new Product("Laptop", 1000);

        plushie.setDiscount(new HalfOff());

        // Applying 10% discount for laptop using anonymous inner class
        laptop.setDiscount(new Discount() {
            @Override
            public double applyDiscount(double price) {
                // 10% discount
                return price * 0.9;
            }
        });

        // Displaying product information
        System.out.println("Product: " + laptop.getName());
        System.out.println("Price after discount: $" + laptop.getPriceAfterDiscount());

        System.out.println("Product: " + plushie.getName());
        System.out.println("Price after discount: $" + plushie.getPriceAfterDiscount());
        }
}
