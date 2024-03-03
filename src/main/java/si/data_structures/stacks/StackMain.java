package si.data_structures.stacks;

public class StackMain {
    public static void main(String[] args) {
        // Stack<String> a = new ArrayStack<String>();
        // a.push("Pancake");
        // a.push("Waffle");
        // a.push("Bacon");
        // System.out.println(a);
        // System.out.println(a.top());
        // System.out.println(a.size());
        // System.out.println("Popping..");
        // a.pop();
        // System.out.println(a);
        System.out.println();

        NodeStack<Integer> nodeStack = new NodeStack<>(1);
        System.out.println(nodeStack);
        nodeStack.push(2);
        System.out.println(nodeStack);
        nodeStack.push(3);
        System.out.println(nodeStack);
        nodeStack.push(4);
        System.out.println(nodeStack);

        for(Integer element : nodeStack){
            System.out.println(element);
        }

        nodeStack.pop();
        System.out.println(nodeStack);
        nodeStack.pop();
        System.out.println(nodeStack);
        nodeStack.pop();
        System.out.println(nodeStack);
        nodeStack.pop();
        System.out.println(nodeStack);
        nodeStack.push(1);
        System.out.println(nodeStack);
        nodeStack.push(2);
        System.out.println(nodeStack);
        int value = nodeStack.pop();
        System.out.println(nodeStack);
        System.out.println(value);

        for(Integer element : nodeStack){
            System.out.println(element);
        }
    }
}
