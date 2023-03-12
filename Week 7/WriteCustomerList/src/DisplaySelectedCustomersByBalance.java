import java.io.FileReader;
import java.util.Scanner;

public class DisplaySelectedCustomersByBalance {
    public static void main(String[] args) throws Exception {
        FileReader readFile = new FileReader("customerList.txt");
        Scanner fileScanner = new Scanner(readFile);
        Scanner key = new Scanner(System.in);
        System.out.println("Enter balance to get customers");
        double bal = Double.parseDouble(key.nextLine());
        while (fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            Scanner lineNext = new Scanner(line);
            while (lineNext.hasNext()){
                String next = lineNext.next();
//                System.out.println(next);
                if (next.contains("owe")){
                    double val = Double.parseDouble(next.replace("owe=","").replace("}",""));
                    if (val>bal){
                        System.out.println(line);
                    }

                }
            }
        }

    }
}
