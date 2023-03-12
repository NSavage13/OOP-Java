import java.io.FileReader;
import java.util.Scanner;

public class DisplaySelectedCustomersByName {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        FileReader read = new FileReader("customerList");
        Scanner scan = new Scanner(read);
        Boolean findLastName = false;

        System.out.println("Enter the last name.");
        String lName = input.nextLine();

        while(scan.hasNextLine()){
            String find = scan.nextLine();
            if (find.contains(", last name = '" + lName)){
                findLastName = true;
                System.out.println(find);
            }
        }
        if (findLastName){
            System.out.println("Found the customer data");
        }else {
            System.out.println("Last name can not be found");
        }
        input.close();
        scan.close();
        




        
    }
}
