import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateCustomerFile {
    public static void main(String[] args) {
        File file = new File("customerFile.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(file);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Enter customer ID (3 digits): ");
                String id = scanner.nextLine().trim();

                if (id.length() != 3) {
                    System.out.println("ID must be 3 digits.");
                    continue;
                }

                System.out.println("Enter customer last name (6 characters): ");
                String lastName = scanner.nextLine().trim();

                while (lastName.length() < 6) {
                    lastName += "*";
                }
                if (lastName.length() > 6) {
                    lastName = lastName.substring(0, 6);
                }

                System.out.println("Enter customer zip code (5 digits): ");
                String zipCode = scanner.nextLine().trim();

                if (zipCode.length() != 5) {
                    System.out.println("Zip code must be 5 digits.");
                    continue;
                }

                String record = id + " " + lastName + " " + zipCode + "\n";

                if (containsID(file, id)) {
                    System.out.println("ID already exists.");
                    continue;
                }

                writer.write(record);
                System.out.println("Record added.");
                System.out.println("Do you want to add another record? (Y/N)");
                String response = scanner.nextLine().trim().toUpperCase();

                if (!response.equals("Y")) {
                    break;
                }
            }

            writer.close();
            System.out.println("File saved.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static boolean containsID(File file, String id) throws IOException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.substring(0, 3).equals(id)) {
                return true;
            }
        }

        scanner.close();
        return false;
    }
}
