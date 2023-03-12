import java.util.Scanner;

public class BookArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        

        for (int i = 0; i < books.length; i++) {
            System.out.print("Enter the title of book #" + (i + 1) + ": ");
            String title = scanner.nextLine();

            while (true) {
                System.out.print("Is it fiction or nonfiction? (F/N): ");
                String type = scanner.nextLine();
                if (type.equalsIgnoreCase("F")) {
                    books[i] = new Fiction(title);
                    break;
                } else if (type.equalsIgnoreCase("N")) {
                    books[i] = new NonFiction(title);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter F or N.");
                    i--;
                }
            }
        }

        for (int i = 0; i < books.length; i++) {
            System.out.println("Book #" + (i + 1) + ": " + books[i].getTitle() + " - Price: $" + books[i].getPrice());
        }
        scanner.close();
    }
}
