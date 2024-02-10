package si.session_activities.unit03;

public class Animal {
    private String name;
    private double weight;
   
    /**
     * 
     * @param name
     * @param weight
     */
    public Animal(String name, double weight) {
       this.name = name;
       this.weight = weight;
    }
   

    // getters 
    public String getName() {
       return this.name;
    }
    public double getWeight(){
        return this.weight;
    }
   
    /**
     * 
     * @param other
     */
    public void greet(Animal other) {
       System.out.println(this.name + " greets " + other.getName() + "!");
    }

    public void eat(){
        System.out.println(this.name + " eats some food!");
    }
}