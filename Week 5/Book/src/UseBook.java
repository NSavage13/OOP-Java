import java.util.Scanner;

public class UseBook {
    static Scanner input = new Scanner(System.in);



    public static void main(String[] args){
        System.out.println("Enter a fiction book title. ");
        System.out.print(">>> ");
        String bookTitle = input.nextLine();
        Fiction fictionBook = new Fiction(bookTitle);
        
        System.out.println("Enter a non-fiction book title. ");
        System.out.print(">>> ");
        String bookTitle2 = input.nextLine();
        NonFiction nonFictionBook = new NonFiction(bookTitle2);

        System.out.println("Fiction book: " + fictionBook.getTitle() + " Price: $" + String.format("%.2f", fictionBook.getPrice()));

        System.out.println("Non-fiction book: " + nonFictionBook.getTitle() + " Price: $" + String.format("%.2f", nonFictionBook.getPrice()));
        
        
        
    }
    
}
