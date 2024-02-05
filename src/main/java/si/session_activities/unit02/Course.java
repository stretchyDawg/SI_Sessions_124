package si.session_activities.unit02;

public class Course {
    private String courseNumber;
    private String courseName;
    private Student[] enrolledStudents;
    private Student[] waitlist;

    public Course(String courseNumber, String courseName) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.enrolledStudents = new Student[30];
        this.waitlist = new Student[10];
    }

    public String getCourseNumber() {
        return courseNumber;
    }
    public String getCourseName() {
        return courseName;
    }
    public Student[] getEnrolledStudents() {
        return enrolledStudents;
    }
    public Student[] getWaitlist() {
        return waitlist;
    }

    @Override
    public String toString(){
        return this.courseNumber;
    }
}
