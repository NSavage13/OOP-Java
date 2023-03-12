import java.util.InputMismatchException;
import java.util.Scanner;

public class DistanceFromAverageWithExceptionHandling {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int size = 0;
        int x = 0;
        double sum = 0;
        double[] numbers = new double[5];
        boolean success = false;

        while (!success) {
            try {
                System.out.println("Enter the size of the array.");
                String value = input.next();
                size = Integer.parseInt(value);
                success = true;
            } catch (NumberFormatException i) {
                System.out.println("Must enter and integer value");
            }
        }
        // -----------------------------------------------------------
        try {
            numbers = new double[size];
        } catch (NegativeArraySizeException e) {
            System.out.println("Invalid. Entered a negative value. Array size will be set to 5.");
            size = 5;
        }

        while (x < numbers.length) {
            try {
                System.out.println("Enter a number value.");
                double entry = input.nextDouble();
                numbers[x] = entry;
                sum += numbers[x];
                x++;
            } catch (InputMismatchException e) {
                System.out.println("ERROR.");
                input.nextLine();
            }
        }
        double average = sum / x;
        System.out.println("Average: " + String.format("%.2f", average));
        for (int y = 0; y < x; y++) {
            System.out.println(numbers[y] + " is " + String.format("%.2f", (numbers[y] - average)) + " away from the average");
        }
        input.close();

    }
}
