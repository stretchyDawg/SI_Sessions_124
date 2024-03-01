package si.session_activities.unit06;

import java.util.Comparator;

public class SongComparator implements Comparator<SongSI> {

    @Override
    public int compare(SongSI o1, SongSI o2) {
        if(o1.getAuthor().compareTo(o2.getAuthor()) == -1){
            return -1;
        } 
        else if(o1.getAuthor().compareTo(o2.getAuthor()) == 1){
            return 1;
        }
        else{
            if(o1.getTitle().compareTo(o2.getTitle()) == -1){
                return -1;
            }
            else if(o1.getTitle().compareTo(o2.getTitle()) == 1){
                return 1;
            }
            else{
                return 0;
            }
        }   
    }
}