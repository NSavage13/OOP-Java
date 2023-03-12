
 import java.util.Arrays;
 import java.util.Scanner;



 public class SalespersonSort {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         Salesperson[] salesPeople = new Salesperson[7];
        
         for (int i = 0; i < salesPeople.length; i++){

             System.out.println("ID number for sales person " + (i+1) + ": ");
             int id = input.nextInt();
             System.out.println("Annual Sales Amount " + (i+1) + ": ");
             double annSales = input.nextDouble();
             salesPeople[i] = new Salesperson(id, annSales);

         }
        
         System.out.println("To sort by ID number enter (1)");
         System.out.println("To sort by sales amount enter (2)");
         int sortby = input.nextInt();

         if (sortby == 1){
             Arrays.sort(salesPeople, (s1, s2) -> Integer.compare(s1.getIdNumber(), s2.getIdNumber()));
         }else if (sortby == 2){
             Arrays.sort(salesPeople, (s1, s2) -> Double.compare(s1.getAnnSalesAmount(), s2.getAnnSalesAmount()));
         }else{

             System.out.println("Invalid input.");
             System.out.println("To sort by ID number enter (1)");
             System.out.println("To sort by sales amount enter (2)");
             sortby = input.nextInt();

         }
         for (Salesperson salesperson: salesPeople){

             System.out.println("ID number: " + salesperson.getIdNumber());
             System.out.println("Annual sales amount: $" + salesperson.getAnnSalesAmount());
         }

         input.close();
     }
 }
