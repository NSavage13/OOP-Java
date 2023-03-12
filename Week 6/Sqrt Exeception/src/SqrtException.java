import java.util.Scanner;

public class SqrtException {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        boolean success = false;
        int number = 0;
        double sqRoot = 0;
        while (!success) {
            try {
                System.out.println("Enter an integer.");
                String value = input.nextLine();
                number = Integer.parseInt(value);
                if (number < 0) {
                    System.out.println("Error. Negative input.");
                } else {
                    success = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Number is set to 0");
                number = 0;
                success = true;
            }
        }

        if (number > 0) {
            sqRoot = Math.sqrt(number);
            System.out.println("Square root of " + number + " is " + String.format("%.2f", sqRoot));
            
        }
        input.close();

    }
}
