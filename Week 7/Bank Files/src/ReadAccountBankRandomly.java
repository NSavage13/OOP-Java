import java.io.File;
import java.util.Scanner;

public class ReadAccountBankRandomly {
    public static void main(String[] args) {

        try{
            Scanner sc = new Scanner(System.in);
            File file = new File("AccountRecord.txt");
            Scanner reader = new Scanner(file);
            String str;
            String line ="";
            String info ="";
            boolean check = false;

            do{
                System.out.println("Enter the id num to find the balance of");
                str=sc.nextLine();

                while(reader.hasNextLine())
                {
                    line = reader.nextLine();
                    if(line.substring(0,3).contains(str))
                    {
                        info = line;
                        check =true;
                    }
                }

                if(!check)
                {
                    info="No information on that ID Number";
                }

                System.out.println(info);
                reader.close();
                reader= new Scanner(file);
                check =false;

            }while(!str.equals("9999"));

            reader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}