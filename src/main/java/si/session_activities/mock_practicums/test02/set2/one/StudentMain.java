package si.session_activities.mock_practicums.test02.set2.two;

import java.util.Collections;
import java.util.LinkedList;

public class StudentMain {
    public static void main(String[] args) {
        System.out.println();

        Student student1 = new Student("c", 4.0);
        Student student2 = new Student("b", 3.8);
        Student student3 = new Student("a", 3.7);

        LinkedList<Student> students = new LinkedList<>(); 
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Collections.sort(students);
        System.out.println("Class Comparator:");
        for(Student student: students){
            System.out.println(student);
        }
        System.out.println();

        System.out.println("External Song Comparator:");
        Collections.sort(students, new StudentComparator());
        for(Student student: students){
            System.out.println(student);
        }
        System.out.println();
    }
}
