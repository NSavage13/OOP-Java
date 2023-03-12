public class Course {
    private String department;
    private int courseNumber;
    private double credits;

    public Course(String department, int courseNumber, double credits) throws CourseException {
        if (department.length() != 3) {
            throw new CourseException(department, courseNumber, credits, "Department must be three letters");
        }
        if (courseNumber < 100 || courseNumber > 499) {
            throw new CourseException(department, courseNumber, credits, "Course number must be between 100 and 499 inclusive");
        }
        if (credits < 0.5 || credits > 6) {
            throw new CourseException(department, courseNumber, credits, "Credits must be between 0.5 and 6 inclusive");
        }

        this.department = department;
        this.courseNumber = courseNumber;
        this.credits = credits;
    }

    public Course() {
        this.department = "CIS";
        this.courseNumber = 101;
        this.credits = 3.0;
    }

    public String toString() {
        return department + " " + courseNumber + " (" + credits + " credits)";
    }
}
