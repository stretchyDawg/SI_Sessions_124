package si.session_activities.mock_practicums.test03.set2.two;

public class Product {
    private String name;
    private double price;
    private Discount discount;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Discount getDiscount() {
        return discount;
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
}