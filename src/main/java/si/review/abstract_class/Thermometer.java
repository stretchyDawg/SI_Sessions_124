package si.review.abstract_class;

public abstract class Thermometer {
    private double degrees;
  
    public Thermometer(double degrees) {
      this.degrees = degrees;
    }
  
    public double getTemperature() {
      return degrees;
    }
  
    public void setTemperature(double degrees) {
       this.degrees = degrees;
    }
  
    public abstract double getFreezingPoint(); // Implementation not defined 
  
    public abstract double getBoilingPoint();
  
    public abstract char getScale();

    @Override
    public String toString(){
      return "Toy string ";
    }
}
  