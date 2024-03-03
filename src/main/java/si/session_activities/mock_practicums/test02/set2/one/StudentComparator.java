package si.session_activities.mock_practicums.test02.set2.two;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getName().compareTo(o2.getName()) == 1){
            if(o1.getGpa() < o2.getGpa()){
                return -1;
            }
            else if(o1.getGpa() > o2.getGpa()){
                return 1;
            }
            else{
                return 0;
            }
        }
        else {
            return o1.getName().compareTo(o2.getName());
        }
    }
    
}
