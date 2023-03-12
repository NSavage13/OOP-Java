import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.*;

public class ReadBankSequentially {
    public static void main(String[] args) throws FileNotFoundException {
        
            File f = new File("AccountRecord.txt");
            RandomAccessFile bank = new RandomAccessFile(f,"rw");
            Scanner read = new Scanner(f);
            ArrayList<String> accounts = new ArrayList<>();
            String line;
            
            while(read.hasNextLine()){
                line = read.nextLine();
                if (!line.equals("0000 ******** 0000.00")){
                    accounts.add(line);
                }
            }
            System.out.println(accounts);
        
        }
}
