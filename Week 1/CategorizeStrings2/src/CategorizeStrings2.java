import java.util.ArrayList;
import java.util.Scanner;

public class CategorizeStrings2 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ArrayList<String> noSpace = new ArrayList<>();
        ArrayList<String> oneSpace = new ArrayList<>();
        ArrayList<String> multiSpace = new ArrayList<>();

        for (int i=0; i<20; i++){
            System.out.println("Enter a String: (Press 'X' to exit)");
            String output = input.nextLine();

            int spaces = output.split(" ").length-1;
            if (output.equalsIgnoreCase("X")){
                break;
            }
            if (spaces == 0){
                noSpace.add(output);
            }else if (spaces == 1) {
                oneSpace.add(output);
            }else {
                multiSpace.add(output);
            }
        }

        while (true){
        System.out.println("To see the no spaces list enter 1: ");
        System.out.println("To see the one space list enter 2: ");
        System.out.println("To see the multiple spaces list enter 3: ");
        System.out.println("To quit enter 99: ");
        String listString = input.nextLine();
        
        if (listString.equalsIgnoreCase("99")){
            break;
        }

        if (listString.equalsIgnoreCase("1")){
            System.out.println(noSpace);
        } else if(listString.equalsIgnoreCase("2")) {
            System.out.println(oneSpace);
        }else if(listString.equalsIgnoreCase("3")){
            System.out.println(multiSpace);
        }else {
            System.out.println(noSpace);
            System.out.println(oneSpace);
            System.out.println(multiSpace);
        }
    }
    input.close();
    }
}
