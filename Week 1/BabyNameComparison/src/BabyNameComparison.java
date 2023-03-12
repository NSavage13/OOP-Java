import java.util.Scanner;

public class BabyNameComparison {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first name: ");
        String name1 = input.nextLine();

        System.out.println("Enter the second name: ");
        String name2 = input.nextLine();

        System.out.println("Enter the third name: ");
        String name3 = input.nextLine();

        System.out.println("The possible name combinations are ");
        System.out.println(name1 + " " + name2);
        System.out.println(name1 + " " + name3);
        System.out.println(name2 + " " + name3);

        input.close();


    }
}
