/**
 *  @ChristianMorgado
 *  I made this file.
 */

package si.session_activities.mock_practicums.test02.set1.fleebs;

import java.util.Comparator;

public class BirthdaySorter implements Comparator<Fleeb> {

    @Override
    public int compare(Fleeb a, Fleeb b) {
        if(a.getMonth().getOrder() == b.getMonth().getOrder()){
            if(a.getDay() == b.getDay()){
                return 0;
            } 
            else if(a.getDay() < b.getDay()){
                return -1;
            } 
            return 1;
        }
        else{
            if(a.getMonth().getOrder() < b.getMonth().getOrder()){
                return -1;
            }
            return 1;
        }
    }
    
}
