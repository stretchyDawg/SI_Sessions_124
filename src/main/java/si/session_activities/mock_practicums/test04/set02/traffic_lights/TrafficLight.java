package si.session_activities.mock_practicums.test04.set02.traffic_lights;

public class TrafficLight implements Runnable{
    private final String name;
    private LightColor color;
    private final Object key; // <-- I like to call them keys instead of locks, its more accurate to what they actually are

    public TrafficLight(String name, Object key) {
        this.name = name;
        this.color = LightColor.RED;
        this.key = key;
    }

    public void run() {
        while (true) {
            try {
                cycleLight();
                Thread.sleep(1000);  // Sleep for 1 second before changing light again
            } catch (InterruptedException e) {}
        }
    }

    private void cycleLight() throws InterruptedException {
        synchronized (key) {
            switch (this.color) { // <-- these are switch cases, a better alternative to if statements (they're faster)
                                  // (you were taught them in class, but they were rarely used)
                case RED:
                    this.color = LightColor.GREEN;
                    System.out.println(name + " is GREEN");
                    break;
                case GREEN:
                    this.color = LightColor.YELLOW;
                    System.out.println(name + " is YELLOW");
                    break;
                case YELLOW:
                    this.color = LightColor.RED;
                    System.out.println(name + " is RED");
                    key.notifyAll();  // Notify other traffic light to start cycle
                    key.wait();       // Wait for other traffic light to complete its cycle
                    break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object key = new Object();
        Thread light1 = new Thread(new TrafficLight("North/South Light", key));
        Thread light2 = new Thread(new TrafficLight("East/West Light", key));

        light1.start();
        Thread.sleep(3000);  // Sleep for 3 second before changing light again
        light2.start();
    }
}


