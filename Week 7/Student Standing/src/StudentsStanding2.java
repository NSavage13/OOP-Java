import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentsStanding2 {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner goodStandingFile = new Scanner(new File("students-in-good-standing.txt"));
        Scanner probationFile = new Scanner(new File("students-on-probation.txt"));
        
        System.out.println("Students in good standing:");
        printStudentData(goodStandingFile);
        
        System.out.println("\nStudents on academic probation:");
        printStudentData(probationFile);
        
        goodStandingFile.close();
        probationFile.close();
    }
    
    public static void printStudentData(Scanner fileScanner) {
        System.out.printf("%-10s %-15s %-15s %-5s %-5s%n", "ID", "First Name", "Last Name", "GPA", "Diff");
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] data = line.split(",");
            int id = Integer.parseInt(data[0]);
            String firstName = data[1];
            String lastName = data[2];
            double gpa = Double.parseDouble(data[3]);
            double diff = gpa - 2.0;
            System.out.printf("%-10d %-15s %-15s %-5.2f %-5.2f%n", id, firstName, lastName, gpa, diff);
        }
    }
}
    
