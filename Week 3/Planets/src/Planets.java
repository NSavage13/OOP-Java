import java.util.Scanner;

public class Planets {
   public enum Planet {
      Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      while (true) {
         System.out.print("Enter a planet name (or 'quit' to exit): ");
         String planetName = sc.nextLine();
         if (planetName.equalsIgnoreCase("quit")) {
            break;
         }

         try {
            Planet p = Planet.valueOf(planetName);
            int position = p.ordinal() + 1;
            System.out.println(planetName + " is the " + position + " planet in our solar system.");
         } catch (IllegalArgumentException e) {
            System.out.println("Invalid planet name. Try again.");
         }
      }
   }
}
