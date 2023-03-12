import java.util.Scanner;

public class CustomerInfo {
    public static Scanner key = new Scanner(System.in);
    int ID;
    String first,last;
    double owe;

    public CustomerInfo() {
        System.out.println("Enter Customer ID >>");
        ID = Integer.parseInt("0"+key.nextLine());
        System.out.println("Enter First Name >>");
        first = key.nextLine();
        System.out.println("Enter Last Name >>");
        last = key.nextLine();
        System.out.println("Enter Amount Owed >>");
        owe = Double.parseDouble("0"+key.nextLine());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", owe=" + owe +
                "}\n";
    }
}

