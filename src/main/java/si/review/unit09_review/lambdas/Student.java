package si.review.unit09_review.lambdas;

import java.util.ArrayList;

/**
 * A class that represents a student with a first and last na
 */
public class Student implements Comparable<Student> { // remove Comparable
    /**
     * The student's first name.
     */
    private final String firstName;

    /**
     * The student's last name.
     */
    private final String lastName;

    /**
     * Creates a new student.
     * 
     * @param firstName The new student's first name.
     * @param lastName The new student's last name.
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Student other) {
        return this.firstName.compareTo(other.firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{" + this.lastName + ", " + this.firstName + "}";
    }

    // public static class StudentComparator implements Comparator<Student>{

    //     @Override
    //     public int compare(Student a, Student b) {
    //         return a.getLastName().compareTo(b.getLastName());
    //     }

    // }

    public static void main(String[] args){
        Student student1 = new Student("Christian", "Morgado");
        Student student2 = new Student("Jackson", "Canedy");
        Student student3 = new Student("Abe", "Ashvil");
        Student student4 = new Student("Irwin", "Cano");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        System.out.println(students);
        students.sort((a, b) -> a.getLastName().compareTo(b.getLastName()));
        System.out.println(students);
        students.sort((a, b) -> a.getFirstName().compareTo(b.getFirstName()));
        System.out.println(students);
        students.sort((a, b) -> a.getLastName().compareTo(b.getLastName()));
        System.out.println(students);

        students.sort(Student::compareTo);
        System.out.println(students);

        System.out.println();
        students.stream().forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
        System.out.println();
        students.stream().filter(s -> s.getFirstName().toLowerCase().contains("i")).forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

    }
}
