import java.util.Scanner;

public class QuartsToGallonsWithExceptionHandling {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        double quarts = 0;
        double gallons = 0;
        while (true) {
            try {
                System.out.println("Enter amount of quarts");
                System.out.print(">> ");
                String str = input.nextLine();
                quarts = Double.parseDouble(str);
                gallons = quarts / 4;
                break;
            } catch (NumberFormatException error) {
                System.out.println("Invalid input");

            }
        }
        System.out.println(quarts + " quarts equals " + gallons + " gallons");
        input.close();
    }
}
