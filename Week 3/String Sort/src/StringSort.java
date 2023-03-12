import java.util.Arrays;
import java.util.Scanner;

public class StringSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strings = new String[15];

        System.out.println("Enter up to 15 strings, one per line. Enter 'stop' to finish.");
        int i;
        for (i = 0; i < 15; i++) {
            System.out.print("Enter string #" + (i + 1) + ": ");
            strings[i] =input.nextLine();
            if (strings[i].equalsIgnoreCase("stop")) {
                break;
                
            }
            
        }
        
        Arrays.sort(strings, 0, i);
        System.out.println("The sorted strings are:");
        for (int j = 0; j < i; j++) {
            System.out.println(strings[j]);
        }
         
    }
    
}
