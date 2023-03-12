import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter a string. ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int getWordsCount = str.split("[\\s.,;?1-]+").length;
        System.out.println("Word Count: "+ getWordsCount);
        
        input.close();
    }
}
   

