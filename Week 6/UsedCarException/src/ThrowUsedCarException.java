import java.util.Scanner;

public class ThrowUsedCarException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UsedCar[] cars = new UsedCar[7];
        int index = 0;

        while (index < cars.length) {
            try {
                System.out.println("Enter car details:");
                System.out.print("VIN (4 digits): ");
                String vin = scanner.nextLine();
                System.out.print("Make (Ford, Honda, Toyota, Chrysler, Other): ");
                String make = scanner.nextLine();
                System.out.print("Year (1997-2024): ");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.print("Mileage: ");
                int mileage = Integer.parseInt(scanner.nextLine());
                System.out.print("Price: ");
                double price = Double.parseDouble(scanner.nextLine());

                UsedCar car = new UsedCar(vin, make, year, mileage, price);
                cars[index] = car;
                index++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (UsedCarException e) {
                System.out.println("Invalid car details: " + e.getMessage());
            }
        }

        System.out.println("List of successfully constructed cars:");
        for (UsedCar car : cars) {
            if (car != null) {
                System.out.println(car.getVin() + " " + car.getMake() + " " + car.getYear() + " " + car.getMileage()
                        + " " + car.getPrice());
            }
        }
        scanner.close();
    }
}
