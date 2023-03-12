import java.util.Scanner;


public class UseGeometric2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GeometricFigure2[] figures = new GeometricFigure2[5];

        for (int i = 0; i < figures.length;i++){
            System.out.println("Enter (S) for square\nEnter (T) for Triangle\nEnter (Q) to quit");
            String shapeInput = input.nextLine();
            
                if (shapeInput.equalsIgnoreCase("S")){
                    System.out.print("Enter the length of a side >> ");
                    double side = input.nextDouble();
                    input.nextLine();
                    figures[i] = new Square2(side);
                    
                }else if (shapeInput.equalsIgnoreCase("T")){
                    System.out.print("Enter the base >> ");
                    double base = input.nextDouble();
                    System.out.print("Enter height >> ");
                    double height = input.nextDouble();
                    input.nextLine();
                    figures[i] = new Triangle2(height, base);
                    
                }else  {
                    System.out.println("Invalid input.");
                    i--;
                }
            
        }
        for (int i = 0; i < figures.length;i++){
            System.out.println("Figure type: " + figures[i].getType());
            System.out.println("Area: " + figures[i].getArea());
            figures[i].displaySides();
            System.out.println();
            
        }
        input.close();

    }
}
