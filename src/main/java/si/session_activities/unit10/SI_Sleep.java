package si.session_activities.unit10;

/*
EXPERIMENTING WITH SLEEP:
With a partner, create a Racer.java class. Have the class implement Runnable:
- Each racer has a name and a speed (int). Create getters for both fields and a constructor.
- In the run() method, print “<name> has started the race!”, then put the thread to sleep for 
  1 second divided by the speed field (1000 / speed). On the line after you put it to sleep, 
  print “<name> has finished!”

- Now, create a RaceMain.java file with only a main method. Create 3-5 instances of Threads 
  using the Runnable interface implementation in the main method. Then run them and see who wins!
 */

public class SI_Sleep {

    public static class Racer implements Runnable
    { 
        private String name; 
        private int speed;
        public String getName() {
            return name;
        }
        public int getSpeed() {
            return speed;
        }
        public Racer(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }
        @Override
        public void run() {
            System.out.println(this.name + " has started the race!");
            try {
                Thread.sleep(1000/this.speed);
            } catch (InterruptedException e) {}
            System.out.println(this.name + " has finished!");
        } 
    }

    public static void main(String[] args) {
        Thread a = new Thread(new Racer("A", 1));
        Thread b = new Thread(new Racer("B", 2));
        Thread c = new Thread(new Racer("C", 3));

        Thread d = new Thread(() -> System.out.println("Fart"));

        a.start();
        b.start();
        c.start();
    }

}
