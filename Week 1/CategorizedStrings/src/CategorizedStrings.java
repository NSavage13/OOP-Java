import java.util.ArrayList;
import java.util.Scanner;

public class CategorizedStrings {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ArrayList<String> shortS = new ArrayList<>();
        ArrayList<String> longS = new ArrayList<>();

        for (int i=0; i<20; i++){
            System.out.println("Enter a String: (Press 'X' to exit)");
            String output = input.nextLine();
            if (output.equalsIgnoreCase("X")){
                break;
            }
            if(output.length() <= 10){
                shortS.add(output);
            } else {
                longS.add(output);
            }
        }

        while (true){
        System.out.println("To see the short list enter 1: ");
        System.out.println("To see the long list enter 2: ");
        System.out.println("To quit enter 3: ");
        String listString = input.nextLine();
        
        if (listString.equalsIgnoreCase("3")){
            System.out.println(longS);
            break;
        }
        if (listString.equalsIgnoreCase("1")){
            System.out.println(shortS);
        } else if(listString.equalsIgnoreCase("2")) {
            System.out.println(longS);
        }else {
            System.out.println("Invalid answer");
            
        }
    }
    input.close();
    }
}
