package si.session_activities.unit10;

public class EvensAndOdds extends Thread{
    private final String name;

    public EvensAndOdds(String name){
        this.name = name;
    }

    @Override
    public void run(){        
        if(name.equals("Odd")){
            for(int i = 1; i < 100; i++){
                if(i % 2 != 0){
                    System.out.println(i);
                }
                try {
                    Thread.sleep(10);
                } 
                catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }
            }
        }
        else if(name.equals("Even")){
            for(int i = 1; i < 100; i++){
                if(i % 2 == 0){
                    System.out.println(i);
                }
                try {
                    Thread.sleep(10);
                } 
                catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }
            }
        }
    }

    public static void main(String[] args) {
        
        Thread odd = new EvensAndOdds("Odd");
        odd.start();
        Thread even = new EvensAndOdds("Even");
        even.start();
    }
}
