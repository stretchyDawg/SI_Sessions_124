package si.session_activities.mock_practicums.test04.set01.buckets;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BucketMain {
    public static void main(String[] args) throws InterruptedException, IndexOutOfBoundsException {
        /*
         * Create and fill the funnel
         */
        Map<Ball,Integer> ballCounts = new HashMap<>() {{
            put(Ball.RED,2);
            put(Ball.GREEN,1);
            put(Ball.YELLOW,4);
            put(Ball.PURPLE,3);
        }};
        System.out.println("Balls To Catch: " + ballCounts);

        Funnel funnel = fillFunnel(ballCounts);
        System.out.println("\nFunnel: " + funnel);

        /*
         * Your solution goes below
         */
        Thread[] threads = new Thread[4];
        Bucket redBucket = new Bucket(Ball.RED, funnel);
        threads[0] = new Thread(redBucket);

        Bucket greenBucket = new Bucket(Ball.GREEN, funnel);
        threads[1] = new Thread(greenBucket);

        Bucket yellowBucket = new Bucket(Ball.YELLOW, funnel);
        threads[2] = new Thread(yellowBucket);

        Bucket purpleBucket = new Bucket(Ball.PURPLE, funnel);
        threads[3] = new Thread(purpleBucket);
    
        synchronized(funnel){
            for(int i = 0; i < 4; i++){
                threads[i].start();
            }
        }

        Thread.sleep(1000);
        System.out.println("Balls Caught:");
        System.out.println("PURPLE = " + purpleBucket.getBallCount());
        System.out.println("GREEN = " + greenBucket.getBallCount());
        System.out.println("YELLOW = " + yellowBucket.getBallCount());
        System.out.println("RED = " + redBucket.getBallCount());
    }

    /**
     * Helper method. Fills the funnel with balls.
     * 
     * @param ballCounts - a map of ball to count to add to funnel.
     * 
     * @return - a funnel randomly populated with a each type of ball.
     */
    public static Funnel fillFunnel(Map<Ball,Integer> ballCounts) {
        LinkedList<Ball> ballList = new LinkedList<>();

        for (Ball ball : ballCounts.keySet()) {
            for (int i = 0;i < ballCounts.get(ball);++i)
                ballList.add(ball);
        }

        Collections.shuffle(ballList);
        return new Funnel(ballList);
    }
}
