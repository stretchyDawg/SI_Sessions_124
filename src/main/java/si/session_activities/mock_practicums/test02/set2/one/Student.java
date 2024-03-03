package si.session_activities.mock_practicums.test02.set2.two;

public class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {
        if(this.gpa < o.gpa){
            return 1;
        }
        else if(this.gpa > o.gpa){
            return -1;
        }
        else{
            return this.name.compareTo(o.name);
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", gpa=" + gpa + "]";
    }
}
