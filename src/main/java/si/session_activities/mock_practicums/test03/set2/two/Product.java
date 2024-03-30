package si.session_activities.mock_practicums.test03.set2.two;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }
}