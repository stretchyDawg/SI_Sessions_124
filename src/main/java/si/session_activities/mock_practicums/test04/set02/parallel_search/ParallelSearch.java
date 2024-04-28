package si.session_activities.mock_practicums.test04.set02.parallel_search;

public class ParallelSearch {
    private static boolean foundParallelTarget = false;
    
    public static void doParallelSearch(int[] intArray, int target) throws InterruptedException{
        if(intArray.length > 1){
            Thread firstHalf = new Thread(() -> {
                for(int i = 0; i < intArray.length/2; i++){
                    if(intArray[i] == target){
                        foundParallelTarget = true;
                        System.out.println("[PARALLEL SEARCH]: Found target value " + target + " at index " + i + ".");
                        break;
                    }
                }
            });
            Thread secondHalf = new Thread(() -> {
                for(int i = intArray.length/2; i < intArray.length; i++){
                    if(intArray[i] == target){
                        foundParallelTarget = true;
                        System.out.println("[PARALLEL SEARCH]: Found target value " + target + " at index " + i + ".");
                        break;
                    }
                }
            });
            firstHalf.start();
            secondHalf.start();
            Thread.sleep(1000); // <-- Gotta wait for the threads to run
            if(!foundParallelTarget){
                System.out.println("[PARALLEL SEARCH]: Target value not found!");
            }
        } else {
            System.out.println("Switching to linear search...");
            doLinearSearch(intArray, target);
        }
    }

    public static void doLinearSearch(int[] intArray, int target){
        boolean found = false;
        int index = -1;
        for(int integer : intArray){
            index++;
            if(integer == target){
                found = true;
                System.out.println("[LINEAR SEARCH]: Found target value " + target + " at index " + index + ".");
                break;
            }
        }
        if(!found){
            System.out.println("[LINEAR SEARCH]: Target value not found!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] randomArray = ArrayGenerator.generateRandomArray(100000000, 0, 100000000);
        int targetValue = 8008135;

        System.out.println();
        doParallelSearch(randomArray, targetValue);
        doLinearSearch(randomArray, targetValue);
    }
}
