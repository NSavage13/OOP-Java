import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentsStanding {
    
    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        
        FileWriter goodStandingFile = new FileWriter("students-in-good-standing.txt");
        FileWriter probationFile = new FileWriter("students-on-probation.txt");
        
        for (int i = 1; i <= numStudents; i++) {
            System.out.println("Enter data for student #" + i);
            System.out.print("ID number: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Grade point average: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();
            
            String studentData = id + "," + firstName + "," + lastName + "," + gpa;
            if (gpa >= 2.0) {
                goodStandingFile.write(studentData + "\n");
            } else {
                probationFile.write(studentData + "\n");
            }
        }
        
        goodStandingFile.close();
        probationFile.close();
        scanner.close();
        
        System.out.println("Student data saved successfully.");
    }
}
