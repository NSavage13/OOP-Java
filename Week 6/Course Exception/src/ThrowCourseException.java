import java.util.Scanner;

public class ThrowCourseException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] departments = new String[6];
        int[] courseNumbers = new int[6];
        double[] credits = new double[6];

        // Prompt the user for values for each field
        for (int i = 0; i < 6; i++) {
            System.out.println("Enter information for course #" + (i+1));
            System.out.print("Department: ");
            departments[i] = input.nextLine();

            System.out.print("Course number: ");
            while (!input.hasNextInt()) {
                System.out.print("Invalid input. Course number must be an integer. Try again: ");
                input.next();
            }
            courseNumbers[i] = input.nextInt();
            input.nextLine(); // consume the newline character

            System.out.print("Credits: ");
            while (!input.hasNextDouble()) {
                System.out.print("Invalid input. Credits must be a number. Try again: ");
                input.next();
            }
            credits[i] = input.nextDouble();
            input.nextLine(); // consume the newline character
        }

        Course[] courses = new Course[6];

        // Try to construct Course objects using the field values
        for (int i = 0; i < 6; i++) {
            try {
                courses[i] = new Course(departments[i], courseNumbers[i], credits[i]);
            } catch (CourseException e) {
                System.out.println("Failed to create course #" + (i+1) + ": " + e.getMessage());
                courses[i] = new Course(); // create course with default constructor
            }
        }

        // Display all the stored Course values using the Course toString() method
        System.out.println("\nAll courses:");
        for (int i = 0; i < 6; i++) {
            System.out.println("Course #" + (i+1) + ": " + courses[i].toString());
        }
        input.close();
    }
}
