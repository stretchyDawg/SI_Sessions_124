package si.data_structures.queues;
import java.util.Iterator;

public interface Queue<E> extends Iterable<E>{
    void enqueue(E value);
    E dequeue();
    int size();

    default Iterator<E> iterator(){
        throw new UnsupportedOperationException("Iterator() not supported");
    }
}