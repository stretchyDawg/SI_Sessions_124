/**
 *  @ChristianMorgado
 *  I made this file :p
 */

package si.session_activities.mock_practicums.test02.set1.deque;

import java.util.Iterator;

public interface Deque<E> extends Iterable<E>{
    void enqueueFront(E element);
    void enqueueBack(E element);
    E dequeueFront();
    E dequeueBack();
    int size();

    default Iterator<E> iterator(){
        throw new UnsupportedOperationException();
    }

}
