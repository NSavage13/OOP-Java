public abstract class GeometricFigure2 {
    protected double height;
    protected double width;
    private String type;

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public String getType() {
        return type;
    }

    public GeometricFigure2(double height, double width, String type) {
        this.height = height;
        this.width = width;
        this.type = type;
    }
    
    

    public abstract double getArea();
    public abstract void displaySides();


}
