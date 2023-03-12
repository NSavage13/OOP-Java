public class UsedCar {
    private String vin;
    private String make;
    private int year;
    private int mileage;
    private double price;

    public UsedCar(String vin, String make, int year, int mileage, double price) throws UsedCarException {
        if (!isValidVin(vin)) {
            throw new UsedCarException(vin, "Vin is not four digits.");
        }
        if (!isValidMake(make)) {
            throw new UsedCarException(make, "Invalid input for make.");
        }
        if (!isValidYear(year)) {
            throw new UsedCarException(String.valueOf(year), "Year is not between 1997-2004.");
        }
        if (mileage < 0) {
            throw new UsedCarException(String.valueOf(mileage), "Negative mileage.");
        }
        if (price < 0) {
            throw new UsedCarException(String.valueOf(price), "Negative price.");
        }

        this.vin = vin;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    private boolean isValidVin(String vin) {
        return vin.matches("\\d{4}");
    }

    private boolean isValidMake(String make) {
        return make.equalsIgnoreCase("Ford") || make.equalsIgnoreCase("Honda") || make.equalsIgnoreCase("Toyota") || make.equalsIgnoreCase("Chrysler") || make.equalsIgnoreCase("Other");
    }

    private boolean isValidYear(int year) {
        return year >= 1997 && year <= 2024;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public double getPrice() {
        return price;
    }
}
