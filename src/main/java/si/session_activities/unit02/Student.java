package si.session_activities.unit02;

public class Student {
    private String name;
    private String studentId;
    private double gpa;
    private Course[] enrolledCourses;

    public Student(String name, String studentId, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.gpa = gpa;
        this.enrolledCourses = new Course[3]; // Assuming a maximum of 10 enrolled courses
    }

    public Student(String name, String studentId, double gpa, Course[] enrolledCourses) {
        this(name, studentId, gpa);
        this.enrolledCourses = enrolledCourses; 
    }

    public String getName() {
        return name;
    }
    public String getStudentId() {
        return studentId;
    }
    public double getGpa() {
        return gpa;
    }
    public Course[] getEnrolledCourses() {
        return enrolledCourses;
    }

    /*
     * Made for you to easily visualize the courses being printed.
     */
    public void printCourses(){
        for(int i = 0; i < this.enrolledCourses.length; i++){
            System.out.println(this.enrolledCourses[i]);
        }
    }

    @Override
    public String toString(){
        return this.studentId;
    }

}
