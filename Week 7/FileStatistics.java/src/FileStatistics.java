import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class FileStatistics {
    public static Scanner input = new Scanner(System.in);
     public static void main(String[] args) {
        File file = getFileName();

        System.out.println(file.isFile());
        System.out.printf("Path: %s\nName: %s\nFolder: %s\nSize: %s\nTime of Last Modification: %s", file.getPath(),file.getName(),file.getParentFile(),file.length(),new Date(file.lastModified()));
     }
        


        public static File getFileName(){
            System.out.println("Enter path of the file");
            File file = new File(input.nextLine());
            if (file.isFile()){
                return file;
            }else {
                System.out.println("Error");
                return getFileName();
            }
        }
    
     }
    
    
