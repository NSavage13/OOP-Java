import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateItemFile {
    public static void main(String[] args) {
        File file = new File("itemFile.txt");

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
                System.out.println("Enter item number (3 digits): ");
                String itemNumber = scanner.nextLine().trim();

                if (itemNumber.length() != 3) {
                    System.out.println("Item number must be 3 digits.");
                    continue;
                }

                System.out.println("Enter item description (up to 20 characters): ");
                String description = scanner.nextLine().trim();

                if (description.length() > 20) {
                    description = description.substring(0, 20);
                }

                String record = itemNumber + " " + String.format("%-20s", description) + "\n";

                if (containsItemNumber(file, itemNumber)) {
                    System.out.println("Item number already exists.");
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

    private static boolean containsItemNumber(File file, String itemNumber) throws IOException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.substring(0, 3).equals(itemNumber)) {
                return true;
            }
        }

        scanner.close();
        return false;
    }
}
