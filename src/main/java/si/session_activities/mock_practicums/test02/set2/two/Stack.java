package si.session_activities.mock_practicums.test02.set2.two;

import java.util.Iterator;

public interface Stack<E> extends Iterable<E>{
    int size();
    E top();
    void push(E value);
    E pop();

    default Iterator<E> iterator(){
        throw new UnsupportedOperationException("Iterator() not supported");
    }
}
