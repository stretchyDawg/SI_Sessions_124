package si.session_activities.unit03;

public class Inheritance {
    
    public static void printAnimalName(Animal a){
        System.out.println(a.getName());
    }

    public static void printAnimalFurColor(Rabbit a){
        System.out.println(a.getFurColor());
    }

    public static void main(String[] args) {
        Rabbit r = new Rabbit(3.4, "Red");
        Animal a = new Animal("Poop", 0.1);  
        printAnimalName(r);
        printAnimalName(a);        // Does NOT give you an error (written for 'Animal', but Rabbit inherits from Animal)
        // printAnimalFurColor(a); // GIVES YOU AN ERROR (written for Rabbit specifically)
        
        Rabbit r2 = new Rabbit(3.4, "Red");
        Animal ar2 = new Rabbit(2.0, "Blue"); // is an 'animal', uses Rabbit implementation
        Animal a2 = new Animal("Poop", 0.1);  // is an 'animal', uses Animal implementation
        System.out.println(r2);
        System.out.println(ar2);
        System.out.println(a2);
        
        a2.eat();
        r2.eat();

        /* THE GENERAL IDEA:
         * 
         * Any code written for 'Animal', can be used for Rabbit (because Rabbit has the same methods & fields as Animal)
         * Any code written SPECIFICALLY for 'Rabbbit', can NOT be used for Animal because Rabbit has specific methods that Animal doesn't have.
         */
    }
}





