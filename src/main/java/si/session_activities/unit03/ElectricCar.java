package si.session_activities.unit03;

public class ElectricCar extends Car{

    private int battery;
    
    public ElectricCar(String make, String model, int year) {
        super(make, model, year);
    }

    public void chargeBattery(){
        if(this.battery < 100){
            this.battery += 1;
        }   
    }

    @Override
    public void honk(){
        System.out.println("Beep beep");
    }

    @Override
    public void start() {
        if(this.battery >= 1){
            System.out.println("Car started!");
        }
        System.out.println("Not enought battery in car :(");
    }

    @Override
    public void noise() {
        System.out.println("mmmmmmmmmmmmmmmmmmm");
    }
    
}
