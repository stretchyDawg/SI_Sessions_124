package si.session_activities.unit10;

public class RaceMain {
    public static void main(String[] args) {
        // Create runner instances
        Racer runner1 = new Racer("Third", .5);
        Racer runner2 = new Racer("Second", 1);
        Racer runner3 = new Racer("First", 100);

        // Create threads for each runner
        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
        Thread thread3 = new Thread(runner3);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}