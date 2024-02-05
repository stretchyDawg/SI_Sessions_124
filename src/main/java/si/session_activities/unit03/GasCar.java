package si.session_activities.unit03;

public class GasCar extends Car{
    public int gasTank;

    public GasCar(String make, String model, int year) {
        super(make, model, year);
    }

    public void fillUpGasTank(){
        if(this.gasTank < 100){
            this.gasTank += 1;
        }
    }
    
    @Override 
    public void start(){
        if(this.gasTank >= 1){
            System.out.println("Car started!");
        }
        System.out.println("Not enough fuel to start car :(");
    }

    @Override
    public void noise() {
        System.out.println("brum brum brum boom clack");
    }
    
    @Override
    public void honk(){
        super.honk();
    }
}
