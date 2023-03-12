public class Square2 extends GeometricFigure2 {
    private double area;
    public Square2(double side) {
        super(side, side, "Square");
        area = side * side;
        displaySides();
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return String.format("Sqaure area = %.2f", area);
    }

    @Override
    public void displaySides() {
        System.out.println("A square has 4 sides.");
    }

    

    

    
}
