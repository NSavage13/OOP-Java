import java.util.Scanner;

public class TryToParseDouble {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        double number = 0;

        try{
            System.out.println("Enter a decimal number");
            String userDouble = input.nextLine();
            number = Double.parseDouble(userDouble);
        
        }catch (NumberFormatException error){
            System.out.println("Invalid input. Number = 0.0");
        }
        System.out.println("Number: " + number);
        input.close();
    }
}
