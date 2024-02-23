package si.data_structures.stacks;

public interface Stack<E> {
    int size();
    E top();
    void push(E value);
    E pop();
}
