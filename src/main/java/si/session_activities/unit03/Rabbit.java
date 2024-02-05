package si.session_activities.unit03;

public class Rabbit extends Animal {
    private String furColor;
   
    public Rabbit(double weight, String furColor) {
       super("Rabbit", weight);
       this.furColor = furColor;
    }
     
    // getters
    public String getFurColor(){
        return this.furColor;
    }

    public void move() {
       System.out.println(super.getName() + " goes hop, hop, hop!");
    }  

    @Override
    public void eat(){
        System.out.println(this.getName() + " eats some carrots!");
    }

    @Override
    public String toString() {
       return "Rabbit[weight=" + this.getWeight() + ", fur color=" + this.furColor + "]";
    }      
}

    
