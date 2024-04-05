package si.session_activities.unit10;

public class Racer implements Runnable {
    private String name;
    private double speed;

    public Racer(String name, double speed) {
        this.name = name;
        // Generate a random speed for the runner
        this.speed = speed; // Speed between 1 and 100 meters per second
    }

   public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        System.out.println(name + " has started the race!");
        try {
            // Simulate running by sleeping for a random amount of time
            Thread.sleep((int)(1000 / speed)); // Convert speed to milliseconds
            System.out.println(name + " has finished the race!");
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted!");
        }
    }
}
