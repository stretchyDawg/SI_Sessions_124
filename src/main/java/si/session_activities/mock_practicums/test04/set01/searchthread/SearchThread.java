package si.session_activities.mock_practicums.test04.set01.searchthread;

public class SearchThread {
    private static int targetIndex = -1;
    private long[] searchArray;
    private int start;
    private int end; // Exclusive
    private long targetValue;

    public SearchThread(long[] searchArray, int start, int end, long targetValue){
        this.searchArray = searchArray;
        this.start = start;
        this.end = end;
        this.targetValue = targetValue;
    }

    public void search(){
        for(int i = this.start; i < this.end; i++){
            if(searchArray[i] == targetValue){
                targetIndex = i;
                System.out.println("Target value (" + targetValue + ") found at " + targetIndex);
            }
        }
    }

    public static void main(String[] args){
        long[] randArray = SearchUtils.randomArray(1000000);

        Thread firstQuarter = new Thread(new Runnable(){
            @Override
            public void run() {
                SearchThread st = new SearchThread(randArray, 0, 249999, SearchUtils.TARGET_VALUE);
                st.search();
            }
        });
        Thread secondQuarter = new Thread(new Runnable(){
            @Override
            public void run() {
                SearchThread st = new SearchThread(randArray, 250000, 499999, SearchUtils.TARGET_VALUE);
                st.search();
            }
        });
        Thread thirdQuarter = new Thread(new Runnable(){
            @Override
            public void run() {
                SearchThread st = new SearchThread(randArray, 500000, 749999, SearchUtils.TARGET_VALUE);
                st.search();
            }    
        });
        Thread fourthQuarter = new Thread(new Runnable(){
            @Override
            public void run() {
                SearchThread st = new SearchThread(randArray, 750000, 999999, SearchUtils.TARGET_VALUE);
                st.search();
            }
        });

        firstQuarter.start();
        secondQuarter.start();
        thirdQuarter.start();
        fourthQuarter.start();

    }
}
