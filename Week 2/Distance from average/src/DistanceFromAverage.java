import java.util.ArrayList;
import java.util.Scanner;

public class DistanceFromAverage {
    public static void main(String[] args) {
        ArrayList<Double> numList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a double value. ");
        System.out.println("You may enter up to 15 numbers.");
        System.out.println("Enter 99999 to quit.");
        System.out.print("Enter number >> ");
        double number = input.nextDouble();
        int count = 0;
        double total = 0;

        while (number != 99999 && count < 14){
        numList.add(number);
            total += number;
            count ++;
            System.out.print("Enter number >> ");
            number = input.nextDouble();
        }
        if (count == 0){
            System.out.println("ERROR! No doubles entered.");
        }else {
            double average = total / count;
            System.out.println("Number of doubles entered: " + numList.size());
            System.out.println("The AVERAGE is: " + String.format("%.2f",average));
            for (int i = 0; i < count; i++) {
                System.out.println(numList.get(i) + " is " + String.format("%.2f", (average - numList.get(i))) + " from the average.");
            }
        }

    }
}