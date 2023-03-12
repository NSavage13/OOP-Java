public class CollegeCourse {
    private String name;
    private int credits;
    private char grade;

    public CollegeCourse(String name, int credits, char grade) {
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public char getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "CollegeCourse [name=" + name + ", credits=" + credits + ", grade=" + grade + "]";
    }
}

