import java.io.FileReader;
import java.util.Scanner;

public class DisplaySavedCustomerList {
    public static void main(String[] args) throws Exception{
        FileReader read = new FileReader("customerList");
        Scanner scan = new Scanner(read);
        while (scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
        scan.close();
    }
}
