import java.util.Scanner;

public class DemoBlankets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create a Blanket with default values
        Blanket blanket = new Blanket();

        // Display the starting values
        System.out.println("Starting Blanket:");
        System.out.println(blanket);

        // Prompt the user for a material
        while (true) {
            System.out.print("Enter a material (wool, cotton, cashmere) or Q to quit: ");
            String material = input.nextLine();

            if (material.equalsIgnoreCase("q")) {
                break;
            }
            blanket.setMaterial(material);
            System.out.println("");
            System.out.print("Updated Blanket: ");
            System.out.println(blanket);
            System.out.print("Enter a size (Twin, Double, Queen, King): ");
            String size = input.nextLine();

            blanket.setSize(size);
            System.out.println("");
            System.out.println("Updated Blanket:");
            System.out.println(blanket);
            break;
        }

        ElectricBlanket electricBlanket = new ElectricBlanket();
        System.out.println("");
        System.out.println("Starting Electric Blanket:");
        System.out.println(electricBlanket);

        while (true) {
            System.out.print("Enter a material (wool, cotton, cashmere) or Q to quit: ");
            String material = input.nextLine();

            if (material.equalsIgnoreCase("q")) {
                break;
            }
            electricBlanket.setMaterial(material);
            System.out.println("");
            System.out.print("Updated Electric Blanket: ");
            System.out.println(electricBlanket);

            System.out.print("Enter a size (Twin, Double, Queen, King): ");
            String size = input.nextLine();

            electricBlanket.setSize(size);

            System.out.println("Updated Electric Blanket:");
            System.out.println(electricBlanket);
            System.out.println("");
            System.out.print("Enter the number of heat settings (1-5): ");
            int heatSettings = input.nextInt();
            input.nextLine(); 
            electricBlanket.setHeat(heatSettings);

            System.out.print("Does the electric blanket have automatic shutoff (Y/N)? ");
            String hasAutomaticShutoff = input.nextLine();
            electricBlanket.setShutoff(hasAutomaticShutoff.equalsIgnoreCase("Y"));// hasAutomaticShutoff.equalsIgnoreCase("Y") makes it a boolean
            
            System.out.println("");
            System.out.println("Updated Electric Blanket:");
            System.out.println(electricBlanket);
            break;
        }

        input.close();
    }
}
