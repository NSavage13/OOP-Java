import java.util.ArrayList;
import java.util.List;

public class DrugTests2 {
  public static void main(String[] args) {
    final int numEmployees = 30;
    final int numTest = 52;
    //use list because it is already determined
    int[] count = new int[numEmployees];
    // array list uses for statement to track count #
    List<Integer> notTested = new ArrayList<>();
    for (int i = 0; i < numEmployees; i++) {
      notTested.add(i + 1);
    }
    
    for (int i = 0; i < numTest; i++) {
      int selected = (int) (Math.random() * numEmployees) + 1;
      //have to -1 or count will start at 2
      count[selected-1]++;
      notTested.remove(Integer.valueOf(selected));
      // i is counter for weeks selected is for employee
      System.out.printf("%d ", selected);
      
      if ((i + 1) % 4 == 0) {
        System.out.println("\n");
      }
    }
    
    System.out.println("\nEmployee selection count:");
    for (int i = 0; i < numEmployees; i++) {
      System.out.printf("Employee %d: %d\n", i + 1, count[i]);
    }
    
    System.out.println("\nEmployees not tested:");
    for (int i : notTested) {
      System.out.printf("%d ", i);
    }
  }
}

