import java.util.Scanner;

public class InputGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student[] students = new Student[1];

        for (int i = 0; i < 1; i++) {
            System.out.print("Enter ID for student #" + (i + 1) + ": ");
            int id = input.nextInt();
            students[i] = new Student();
            students[i].setIdNumber(id);

            for (int j = 0; j < 5; j++) {
                System.out.print("Enter course ID #" + (j + 1) + ": ");
                String courseName = input.next();
                System.out.print("Enter credits for course #" + (j + 1) + ": ");
                int credits = input.nextInt();
                System.out.print("Enter grade for course #" + (j + 1) + ": ");
                char grade = input.next().charAt(0);

                while (credits != 2 && credits != 3 && credits != 4 && credits != 5){
                    System.out.println("Invalid credit. Please enter 2, 3, 4, 5.");
                    System.out.print("Enter credits for course #" + (j + 1) + ": ");
                    credits = input.nextInt();
                }

                while (grade != 'A' && grade != 'B' && grade != 'C' && grade != 'D' && grade != 'F') {
                    System.out.println("Error: Invalid grade. Please enter A, B, C, D, or F.");
                    System.out.print("Enter grade for course #" + (j + 1) + ": ");
                    grade = input.next().charAt(0);
                }

                CollegeCourse course = new CollegeCourse(courseName, credits, grade);
                students[i].setCollegeCourse(course, j);
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("\nStudent #" + (i + 1) + ": " + students[i]);
        }

        input.close();
    }
}
