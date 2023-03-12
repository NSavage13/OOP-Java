import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class CreateBankFile {
    public static void main(String[] args) {
        try {
            File f = new File("AccountRecord.txt");
            RandomAccessFile bank = new RandomAccessFile(f,"rw");
            Scanner sc = new Scanner(System.in);

            //Adding the blank records

            for (int x = 0; x < 10000; x++) {
                bank.writeBytes("0000 ******** 0000.00\n");
            }

            //Getting Record Info

            while(true) {
                System.out.println("Enter the account number or QUIT to exit.");
                String accountNum = sc.nextLine();

                if (accountNum.equalsIgnoreCase("Quit")){
                    break;
                }

                System.out.println("Enter the last name");
                String name = sc.nextLine();

                while (name.length() < 8) {
                    name += "*";
                }

                System.out.println("Enter the balance");
                double balance = sc.nextDouble();
                sc.nextLine();

                String record = accountNum + " " + name + " " + balance + "\n";
                System.out.println(record);

                //Adding the record
                bank.seek((Integer.parseInt(accountNum) - 1) * 22);
                bank.writeBytes(record);

                bank.seek(0);
            }
            bank.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}