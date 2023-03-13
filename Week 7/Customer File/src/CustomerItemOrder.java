import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CustomerItemOrder {
    public static void main(String[] args) {
        File customerFile = new File("customerFile.txt");
        File itemFile = new File("itemFile.txt");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter customer number (3 digits): ");
            String customerNumber = scanner.nextLine().trim();

            if (customerNumber.length() != 3) {
                System.out.println("Customer number must be 3 digits.");
                continue;
            }

            if (!containsCustomerNumber(customerFile, customerNumber)) {
                System.out.println("Customer number does not exist.");
                continue;
            }

            System.out.println("Enter item number (3 digits): ");
            String itemNumber = scanner.nextLine().trim();

            if (itemNumber.length() != 3) {
                System.out.println("Item number must be 3 digits.");
                continue;
            }

            if (!containsItemNumber(itemFile, itemNumber)) {
                System.out.println("Item number does not exist.");
                continue;
            }

            try {
                Scanner customerScanner = new Scanner(customerFile);
                Scanner itemScanner = new Scanner(itemFile);

                while (customerScanner.hasNextLine()) {
                    String customerLine = customerScanner.nextLine();
                    if (customerLine.substring(0, 3).equals(customerNumber)) {
                        System.out.println("Customer information:");
                        System.out.println(customerLine);
                        break;
                    }
                }

                while (itemScanner.hasNextLine()) {
                    String itemLine = itemScanner.nextLine();
                    if (itemLine.substring(0, 3).equals(itemNumber)) {
                        System.out.println("Item information:");
                        System.out.println(itemLine);
                        break;
                    }
                }

                customerScanner.close();
                itemScanner.close();

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            System.out.println("Do you want to enter another order? (Y/N)");
            String response = scanner.nextLine().trim().toUpperCase();

            if (!response.equals("Y")) {
                break;
            }
        }

        scanner.close();
    }

    private static boolean containsCustomerNumber(File file, String customerNumber) {
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.substring(0, 3).equals(customerNumber)) {
                    scanner.close();
                    return true;
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }

    private static boolean containsItemNumber(File file, String itemNumber) {
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.substring(0, 3).equals(itemNumber)) {
                    scanner.close();
                    return true;
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }
}
