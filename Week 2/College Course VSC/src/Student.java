import java.util.Arrays;

public class Student {
    private int idNumber;
    private CollegeCourse[] courses = new CollegeCourse[5];

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public CollegeCourse getCollegeCourse(int index) {
        return courses[index];
    }

    public void setCollegeCourse(CollegeCourse course, int index) {
        courses[index] = course;
    }

    @Override
    public String toString() {
        return "Student [idNumber=" + idNumber + ", courses=" + Arrays.toString(courses) + "]";
    }
}
