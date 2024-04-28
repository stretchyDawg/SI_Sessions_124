package si.session_activities.mock_practicums.test04.set01.buckets;

public class Bucket implements Runnable{
    private Ball ball;
    private Funnel funnel;
    private int ballCount;

    // Constructor
    public Bucket(Ball ball, Funnel funnel) {
        this.ball = ball;
        this.funnel = funnel;
        this.ballCount = 0;
    }

    // Accessors
    public Ball getBallType() {
        return ball;
    }
    public int getBallCount() {
        return ballCount;
    }

    // Thread method
    @Override
    public synchronized void run(){
        while(!this.funnel.isEmpty()){
            if(this.funnel.peekAtBottom() == this.ball){
                this.funnel.dropFromBottom();
                this.ballCount++;
            }
        }
    }

    
}
