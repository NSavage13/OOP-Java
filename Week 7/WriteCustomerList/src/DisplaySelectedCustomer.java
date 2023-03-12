import java.io.FileReader;
import java.util.Scanner;

public class DisplaySelectedCustomer {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        FileReader read = new FileReader("customerList");
        Scanner scan = new Scanner(read);
        Boolean findID = false;

        System.out.println("Enter an ID number.");
        int idNum = Integer.parseInt(input.nextLine());
        while (scan.hasNextLine()){
            
            String find = scan.nextLine();
            
            if (find.contains("ID= "+ idNum)){
                findID = true;
                System.out.println(find);
            }
        }
        if (findID){
            System.out.println("Found ID number.");
        }else {
            System.out.println("ID number was not found.");
        }
        input.close();
        scan.close();
    }

}