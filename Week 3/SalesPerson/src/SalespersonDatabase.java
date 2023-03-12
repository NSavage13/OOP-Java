import java.util.Scanner;

public class SalespersonDatabase {
    static Salesperson[] database = new Salesperson[20];
    static Scanner input = new Scanner(System.in);
    static int maxRec = 20;
    static int currentRec = 0;
    static boolean exit = false;

    // -------------------------------------------------------------------------

    public static void display() {
        int a, b;
        Salesperson temp;
        int count = currentRec - 1;

        for (a = 0; a < count; ++a)

            for (b = 0; b < count; ++b) {
                if (database[b].getIdNumber() > database[b + 1].getIdNumber()) {
                    temp = database[b];
                    database[b] = database[b + 1];
                    database[b + 1] = temp;
                }
            }
        System.out.println("\nCurrent database:");
        for (a = 0; a < currentRec; ++a) {
            System.out.println("ID #" + database[a].getIdNumber() + "\nSales Amount = $" + String.format("%.2f", database[a].getAnnSalesAmount()));
            System.out.println();
        }
    }

    // -------------------------------------------------------------------------
    public static void addRecord() {
        System.out.println("ADD:");
        if (currentRec == maxRec) {
            System.out.println("ERROR! Database is full.");
            return;
        }

        System.out.print("Enter ID number >> ");
        int id = input.nextInt();

        for (int i = 0; i < currentRec; i++) {
            if (database[i].getIdNumber() == id) {
                System.out.println("ERROR! Id number already exist.");
                return;
            }

        }
        System.out.print("Enter sales amount >> $");
        double salesAmount = input.nextDouble();

        database[currentRec++] = new Salesperson(id, salesAmount);

    }

    // -------------------------------------------------------------------------
    public static void deleteRecord() {
        System.out.println("DELETE: ");
        if (currentRec == 0) {
            System.out.println("ERROR! Database is empty.");
            return;
        }
        System.out.print("Enter ID number >> ");
        int id = input.nextInt();
        // use index as a counter
        int index = -1;
        for (int i = 0; i < currentRec; i++) {
            if (database[i].getIdNumber() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("ERROR! ID not found.");
            return;
        }
        for (int i = index; i < currentRec - 1; i++) {
            database[i] = database[i + 1];
        }
        currentRec--;
    }
    
    // -------------------------------------------------------------------------
    public static void changeRec(){
        System.out.println("CHANGE: ");
        if (currentRec == 0){
            System.out.println("ERROR! Database is empty.");
            return;
        }
        System.out.print("Enter ID number >> ");
        int id = input.nextInt();
        int index = -1;
        for (int i = 0; i < currentRec; i++) {
            if (database[i].getIdNumber() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("ERROR! ID not found.");
            return;
        }
        System.out.println("Enter new sales amount: ");
        double salesAmount = input.nextDouble();
        database[index].setAnnSalesAmount(salesAmount);


    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {

        while (!exit) {

            System.out.println("Enter a number acoordingly.");
            System.out.println("Enter (1) to add record");
            System.out.println("Enter (2) to delete record");
            System.out.println("Enter (3) to change a record");
            System.out.println("Enter (4) to EXIT");
            System.out.print(">>> ");
            int output = input.nextInt();

            if (output == 1) {
                addRecord();
                display();
            } else if (output == 2) {
                deleteRecord();
                display();
            } else if (output == 3) {
                changeRec();
                display();
            } else if (output == 4) {
                exit = true;
            }

        }
        display();

    }
}