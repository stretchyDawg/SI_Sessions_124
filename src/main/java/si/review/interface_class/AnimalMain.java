package si.review.interface_class;

public class AnimalMain {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        System.out.println("\nDog says: " + dog.speak());
        System.out.println("Cat says: " + cat.speak());
        System.out.println("Dog & Cat kingdom: " + Animal.getKingdom());
    }
}
