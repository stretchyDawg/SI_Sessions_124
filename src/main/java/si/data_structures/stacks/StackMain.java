package si.data_structures.stacks;

public class StackMain {
    public static void main(String[] args) {
        Stack<String> a = new ArrayStack<String>();
        a.push("Pancake");
        a.push("Waffle");
        a.push("Bacon");
        System.out.println(a);
        System.out.println(a.top());
        System.out.println(a.size());
        System.out.println("Popping..");
        a.pop();
        System.out.println(a);
    }
}
