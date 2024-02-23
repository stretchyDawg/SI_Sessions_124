package si.data_structures.queues;

public class QueueMain {
    public static void main(String[] args) {
        Queue<String> q = new ArrayQueue<String>();

        q.enqueue("Fart");
        q.enqueue("Poop");
        System.out.println(q);
    }
}
