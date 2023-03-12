
import java.util.Scanner;

public class ThreeLetterAcronym {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        // System.out.println("Enter the first word: ");
        // String word1 = input.nextLine();
        // System.out.println("Enter the second word: ");
        // String word2 = input.nextLine();
        // System.out.println("Enter the third word: ");
        // String word3 = input.nextLine();

        // String answer = (word1.charAt(0) + "" + word2.charAt(0) + "" + word3.charAt(0)).toUpperCase();
        // System.out.println("The three letter acronym is: " + answer);

        System.out.println("Enter at least three words to creat an acronym.");
        String str = input.nextLine();
        

        String[] arrayStr = str.split("\\s+");
        // String word1 = arrayStr[0];
        // String word2 = arrayStr[1];
        // String word3 = arrayStr[2];
        

        // String answer = (word1.charAt(0) + "" + word2.charAt(0) + "" + word3.charAt(0)).toUpperCase();
        String answer = (arrayStr[0].charAt(0) + "" + arrayStr[1].charAt(0) + "" + arrayStr[2].charAt(0)).toUpperCase();
        System.out.println("The three letter acronym is: " + answer);

        input.close();
        
        
    }
}
