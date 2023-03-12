public class Triangle2 extends GeometricFigure2 {
    private double area;
    public Triangle2(double height, double base) {
        super(height, base, "Triangle");
        area = .5 * base * height;
        
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return String.format("Triangle area = %.2f", area);
    }

    @Override
    public void displaySides() {
        System.out.println("A triangle has 3 sides.");
    }
    
}
