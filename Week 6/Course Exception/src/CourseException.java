public class CourseException extends Exception {
    private String department;
    private int courseNumber;
    private double credits;

    public CourseException(String department, int courseNumber, double credits, String message) {
        super(message);
        this.department = department;
        this.courseNumber = courseNumber;
        this.credits = credits;
    }

    public String getDepartment() {
        return department;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public double getCredits() {
        return credits;
    }
}
