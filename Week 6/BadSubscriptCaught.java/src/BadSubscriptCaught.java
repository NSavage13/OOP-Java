import java.util.Scanner;

public class BadSubscriptCaught {
    public static void main(String[] args) throws Exception {
        String[] firstNames = {"Ben", "Aaron", "Charlie", "Amanda", "Dave", "Lisa", "Megan", "Cody"};
        Scanner input = new Scanner(System.in);
        
        try {
            System.out.println("Pick a number between 0-7");
            int pick = input.nextInt();
            System.out.println("Name at index " + pick + ": " + firstNames[pick]);
        }catch (ArrayIndexOutOfBoundsException error){
            System.out.println("Error: Your pick is out of range");
        }
        input.close();
        
    }
}
