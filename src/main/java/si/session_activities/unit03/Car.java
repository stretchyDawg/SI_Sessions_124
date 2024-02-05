package si.session_activities.unit03;

public abstract class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }

    public abstract void start();

    public abstract void noise();

    public void honk() {
        System.out.println("Honk Honk!");
    }
}
