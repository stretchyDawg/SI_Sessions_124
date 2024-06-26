package si.review.unit09_review.anonymous_classes;

public class Product {
    private String name;
    private double price;
    private Discount discount;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getPriceAfterDiscount() {
        if (discount != null) {
            return discount.applyDiscount(price);
        }
        return price;
    }

    public String getName() {
        return name;
    }
}