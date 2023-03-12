import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NineInts {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 9 numbers: ");
        for(int i = 1; i<= 9; i++) {
            numbers.add(input.nextInt());
        }
        System.out.println("List " + numbers);
        Collections.reverse(numbers);
        System.out.println("Reversed order list: " + numbers);

    }
}
